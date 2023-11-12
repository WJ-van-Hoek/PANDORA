package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.implementations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.Cell;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.CellTimestep;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.PandoraTimestep;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.interfaces.DischargesMapService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.interfaces.TerrestrialSourcesMapService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.interfaces.UpstreamSourcesMapService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.interfaces.VolumesMapService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.interfaces.YMapService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.implementations.CellMapCrudService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces.CellTimestepService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces.LocalDateTimeService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces.PandoraIntegratorService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces.TransportCalculationService;

@Service
public class CellTimestepServiceImpl implements CellTimestepService {

    @Autowired
    YMapService yMapService;

    @Autowired
    TerrestrialSourcesMapService terrestrialSourcesMapService;

    @Autowired
    UpstreamSourcesMapService upstreamSourcesMapService;

    @Autowired
    DischargesMapService dischargesMapService;
    
    @Autowired
    VolumesMapService volumesMapService;
        
    @Autowired
    PandoraIntegratorService pandoraIntegratorService;

    @Autowired
    LocalDateTimeService localDateTimeService;

    @Autowired
    TransportCalculationService transportCalculationService;

    @Autowired
    CellMapCrudService cellMapCrudService;

    @Override
    public List<CellTimestep> calculateTimeSeries(Cell cell, LocalDateTime t0, int numberOfTimesteps) {
	List<CellTimestep> results = new ArrayList<>();
	List<LocalDateTime> dateTimeList = localDateTimeService.getDateTimeList(t0, numberOfTimesteps);
	
	for (int i = 0; i < numberOfTimesteps; i++) {
	    CellTimestep nextTimestepResult = calculateNextTimestep(cell, dateTimeList.get(i));
	    results.add(nextTimestepResult);
	}

	return results;
    }

    @Override
    public CellTimestep calculateNextTimestep(Cell cell, LocalDateTime t0) {
	PandoraTimestep preProcess = preProcessing(cell, t0);
	double[] result = pandoraIntegratorService.integrate(preProcess);

	CellTimestep postProcess = postProcessing(cell, t0, preProcess, result);
	return postProcess;
    }

    private PandoraTimestep preProcessing(Cell cell, LocalDateTime t0) {
	double[] y0 = yMapService.findAtCellAndTimestep(cell, t0);
	double[] terrestrialSources = terrestrialSourcesMapService.findAtCellAndTimestep(cell, t0);
	double[] upstreamSources = upstreamSourcesMapService.findAtCellAndTimestep(cell, t0);
	double q = dischargesMapService.findAtCellAndTimestep(cell, t0);
	double v = volumesMapService.findAtCellAndTimestep(cell, t0);
	return PandoraTimestep.builder().y0(y0).t0(0d).tEnd(1d).dimension(y0.length)
		.terrestrialSources(terrestrialSources).upstreamSources(upstreamSources).discharge(q).volume(v).build();
    }

    private CellTimestep postProcessing(Cell cell, LocalDateTime t0, PandoraTimestep timestep, double[] yEnd) {
	LocalDateTime tEnd = localDateTimeService.calculateTEndAsLocalDateTime(t0, timestep.getTEnd());
	yMapService.saveAtCellAndTimestep(cell, tEnd, yEnd);
	Cell nextCell = cellMapCrudService.findById(cell.getNextCellId());
	upstreamSourcesMapService.saveAtCellAndTimestep(nextCell, timestep, tEnd, yEnd);
	CellTimestep cellTimestep = CellTimestep.builder().cell(cell).y0(timestep.getY0()).t0(t0).tEnd(tEnd).build();
	cellTimestep.setYEnd(yEnd);
	return cellTimestep;
    }

}