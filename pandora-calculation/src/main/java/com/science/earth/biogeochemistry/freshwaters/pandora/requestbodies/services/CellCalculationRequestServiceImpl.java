package com.science.earth.biogeochemistry.freshwaters.pandora.requestbodies.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.config.parameters.services.DateTimeService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.Cell;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.CellTimestep;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.interfaces.CellMapService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.interfaces.TerrestrialSourcesMapService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.interfaces.UpstreamSourcesMapService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces.CellTimestepService;
import com.science.earth.biogeochemistry.freshwaters.pandora.requestbodies.CellCalculationRequest;

@Service
public class CellCalculationRequestServiceImpl implements CellCalculationRequestService {

    private final UpstreamSourcesMapService upstreamSourcesMapService;

    private final TerrestrialSourcesMapService terrestrialSourcesMapService;

    private final DateTimeService dateTimeService;

    private final CellTimestepService cellTimestepService;

    @Autowired
    public CellCalculationRequestServiceImpl(UpstreamSourcesMapService upstreamSourcesMapService,
	    TerrestrialSourcesMapService terrestrialSourcesMapService, DateTimeService dateTimeService,
	    CellTimestepService cellTimestepService) {
	this.upstreamSourcesMapService = upstreamSourcesMapService;
	this.terrestrialSourcesMapService = terrestrialSourcesMapService;
	this.dateTimeService = dateTimeService;
	this.cellTimestepService = cellTimestepService;
    }

    @Override
    public void preprocess(CellCalculationRequest request) {
	List<LocalDateTime> dates = fetchDateTimeList(request);

	Cell cell = request.getCell();
	saveSources(request.getUpstreamSources(), cell, dates, upstreamSourcesMapService);
	saveSources(request.getTerrestrialSources(), cell, dates, terrestrialSourcesMapService);
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
	return dateTimeService.getDateTimeList(t0, numberOfTimesteps);
    }

    private void saveSources(List<double[]> sources, Cell cell, List<LocalDateTime> dates,
	    CellMapService cellMapService) {
	IntStream.range(0, sources.size())
		.forEach(i -> cellMapService.saveAtCellAndTimestep(cell, dates.get(i), sources.get(i)));
    }

}
