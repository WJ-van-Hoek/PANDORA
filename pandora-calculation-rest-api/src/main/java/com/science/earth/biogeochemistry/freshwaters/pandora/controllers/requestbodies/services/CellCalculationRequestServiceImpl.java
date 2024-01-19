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

    /**
     * The service responsible for managing Y values at the cell and timestep level.
     */
    private final YMapService yMapService;

    /**
     * The service responsible for managing discharges at the cell and timestep level.
     */
    private final DischargesMapService dischargesMapService;

    /**
     * The service responsible for managing volumes at the cell and timestep level.
     */
    private final VolumesMapService volumesMapService;

    /**
     * The service responsible for managing upstream sources at the cell and timestep level.
     */
    private final UpstreamSourcesMapService upstreamSourcesMapService;

    /**
     * The service responsible for managing terrestrial sources at the cell and timestep level.
     */
    private final TerrestrialSourcesMapService terrestrialSourcesMapService;

    /**
     * The service responsible for managing local date-time operations.
     */
    private final LocalDateTimeService localDateTimeService;

    /**
     * The service responsible for managing cell timestep calculations.
     */
    private final CellTimestepService cellTimestepService;

    /**
     * Constructs a new {@code CellCalculationRequestServiceImpl} instance with the specified services.
     *
     * @param yMapServiceParam The service for managing Y values.
     * @param dischargesMapServiceParam The service for managing discharges.
     * @param volumesMapServiceParam The service for managing volumes.
     * @param upstreamSourcesMapServiceParam The service for managing upstream sources.
     * @param terrestrialSourcesMapServiceParam The service for managing terrestrial sources.
     * @param localDateTimeServiceParam The service for managing local date-time operations.
     * @param cellTimestepServiceParam The service for managing cell timestep calculations.
     */
    @Autowired
    public CellCalculationRequestServiceImpl(final YMapService yMapServiceParam,
            final DischargesMapService dischargesMapServiceParam, final VolumesMapService volumesMapServiceParam,
            final UpstreamSourcesMapService upstreamSourcesMapServiceParam,
            final TerrestrialSourcesMapService terrestrialSourcesMapServiceParam,
            final LocalDateTimeService localDateTimeServiceParam, final CellTimestepService cellTimestepServiceParam) {
        this.yMapService = yMapServiceParam;
        this.dischargesMapService = dischargesMapServiceParam;
        this.volumesMapService = volumesMapServiceParam;
        this.upstreamSourcesMapService = upstreamSourcesMapServiceParam;
        this.terrestrialSourcesMapService = terrestrialSourcesMapServiceParam;
        this.localDateTimeService = localDateTimeServiceParam;
        this.cellTimestepService = cellTimestepServiceParam;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void preprocess(final CellCalculationRequest request) {
        List<LocalDateTime> dates = fetchDateTimeList(request);
        saveToMemory(request, dates);
    }

    private void saveToMemory(final CellCalculationRequest request, final List<LocalDateTime> dates) {
        Cell cell = request.getCell();
        yMapService.saveAtCellAndTimestep(cell, request.getT0(), request.getY0());
        saveDischarge(request, dates, cell);
        saveVolume(request, dates, cell);
        saveUpstreamSources(request, dates, cell);
        saveTerrestrialSources(request, dates, cell);
    }

    private void saveTerrestrialSources(final CellCalculationRequest request, final List<LocalDateTime> dates,
            final Cell cell) {
        IntStream.range(0, request.getTerrestrialSources().size()).forEach(i -> terrestrialSourcesMapService
                .saveAtCellAndTimestep(cell, dates.get(i), request.getTerrestrialSources().get(i)));
    }

    private void saveUpstreamSources(final CellCalculationRequest request, final List<LocalDateTime> dates,
            final Cell cell) {
        IntStream.range(0, request.getUpstreamSources().size()).forEach(i -> upstreamSourcesMapService
                .saveAtCellAndTimestep(cell, dates.get(i), request.getUpstreamSources().get(i)));
    }

    private void saveVolume(final CellCalculationRequest request, final List<LocalDateTime> dates, final Cell cell) {
        IntStream.range(0, request.getVolumes().size())
                .forEach(i -> volumesMapService.saveAtCellAndTimestep(cell, dates.get(i), request.getVolumes().get(i)));
    }

    private void saveDischarge(final CellCalculationRequest request, final List<LocalDateTime> dates, final Cell cell) {
        IntStream.range(0, request.getDischarges().size()).forEach(
                i -> dischargesMapService.saveAtCellAndTimestep(cell, dates.get(i), request.getDischarges().get(i)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CellTimestep> process(final CellCalculationRequest request) {
        Cell cell = request.getCell();
        LocalDateTime t0 = request.getT0();
        int numberOfTimesteps = request.getNumberOfTimesteps();
        return cellTimestepService.calculateTimeSeries(cell, t0, numberOfTimesteps);
    }

    private List<LocalDateTime> fetchDateTimeList(final CellCalculationRequest request) {
        LocalDateTime t0 = request.getT0();
        int numberOfTimesteps = request.getNumberOfTimesteps();
        return localDateTimeService.getDateTimeList(t0, numberOfTimesteps);
    }
}
