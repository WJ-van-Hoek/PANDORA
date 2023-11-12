package com.science.earth.biogeochemistry.freshwaters.pandora.controllers.requestbodies.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.controllers.requestbodies.CellCalculationRequest;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.Cell;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.CellTimestep;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.interfaces.DischargesMapService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.interfaces.TerrestrialSourcesMapService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.interfaces.UpstreamSourcesMapService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.interfaces.VolumesMapService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.interfaces.YMapService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces.CellTimestepService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces.LocalDateTimeService;

@Service
public class CellCalculationRequestServiceImpl implements CellCalculationRequestService {

    private final YMapService yMapService;

    private final DischargesMapService dischargesMapService;

    private final VolumesMapService volumesMapService;

    private final UpstreamSourcesMapService upstreamSourcesMapService;

    private final TerrestrialSourcesMapService terrestrialSourcesMapService;

    private final LocalDateTimeService localDateTimeService;

    private final CellTimestepService cellTimestepService;

    @Autowired
    public CellCalculationRequestServiceImpl(YMapService yMapService, DischargesMapService dischargesMapService,
	    VolumesMapService volumesMapService, UpstreamSourcesMapService upstreamSourcesMapService,
	    TerrestrialSourcesMapService terrestrialSourcesMapService, LocalDateTimeService localDateTimeService,
	    CellTimestepService cellTimestepService) {
	this.yMapService = yMapService;
	this.dischargesMapService = dischargesMapService;
	this.volumesMapService = volumesMapService;
	this.upstreamSourcesMapService = upstreamSourcesMapService;
	this.terrestrialSourcesMapService = terrestrialSourcesMapService;
	this.localDateTimeService = localDateTimeService;
	this.cellTimestepService = cellTimestepService;
    }

    @Override
    public void preprocess(CellCalculationRequest request) {
	List<LocalDateTime> dates = fetchDateTimeList(request);
	saveToMemory(request, dates);
    }

    private void saveToMemory(CellCalculationRequest request, List<LocalDateTime> dates) {
	Cell cell = request.getCell();
	yMapService.saveAtCellAndTimestep(cell, request.getT0(), request.getY0());
	saveDischarge(request, dates, cell);
	saveVolume(request, dates, cell);
	saveUpstreamSources(request, dates, cell);
	saveTerrestrialSources(request, dates, cell);
    }

    private void saveTerrestrialSources(CellCalculationRequest request, List<LocalDateTime> dates, Cell cell) {
	IntStream.range(0, request.getTerrestrialSources().size()).forEach(i -> terrestrialSourcesMapService
		.saveAtCellAndTimestep(cell, dates.get(i), request.getTerrestrialSources().get(i)));
    }

    private void saveUpstreamSources(CellCalculationRequest request, List<LocalDateTime> dates, Cell cell) {
	IntStream.range(0, request.getUpstreamSources().size()).forEach(i -> upstreamSourcesMapService
		.saveAtCellAndTimestep(cell, dates.get(i), request.getUpstreamSources().get(i)));
    }

    private void saveVolume(CellCalculationRequest request, List<LocalDateTime> dates, Cell cell) {
	IntStream.range(0, request.getVolumes().size())
		.forEach(i -> volumesMapService.saveAtCellAndTimestep(cell, dates.get(i), request.getVolumes().get(i)));
    }

    private void saveDischarge(CellCalculationRequest request, List<LocalDateTime> dates, Cell cell) {
	IntStream.range(0, request.getDischarges().size()).forEach(
		i -> dischargesMapService.saveAtCellAndTimestep(cell, dates.get(i), request.getDischarges().get(i)));
    }

    @Override
    public List<CellTimestep> process(CellCalculationRequest request) {
	Cell cell = request.getCell();
	LocalDateTime t0 = request.getT0();
	int numberOfTimesteps = request.getNumberOfTimesteps();
	return cellTimestepService.calculateTimeSeries(cell, t0, numberOfTimesteps);
    }

    private List<LocalDateTime> fetchDateTimeList(CellCalculationRequest request) {
	LocalDateTime t0 = request.getT0();
	int numberOfTimesteps = request.getNumberOfTimesteps();
	return localDateTimeService.getDateTimeList(t0, numberOfTimesteps);
    }

}
