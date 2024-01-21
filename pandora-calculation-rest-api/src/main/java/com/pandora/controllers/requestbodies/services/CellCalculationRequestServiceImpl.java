package com.pandora.controllers.requestbodies.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pandora.controllers.requestbodies.CellCalculationRequest;
import com.pandora.general.objects.Cell;
import com.pandora.general.objects.CellTimestep;
import com.pandora.general.objects.services.abstractions.interfaces.DischargesMapService;
import com.pandora.general.objects.services.abstractions.interfaces.TerrestrialSourcesMapService;
import com.pandora.general.objects.services.abstractions.interfaces.UpstreamSourcesMapService;
import com.pandora.general.objects.services.abstractions.interfaces.VolumesMapService;
import com.pandora.general.objects.services.abstractions.interfaces.YMapService;
import com.pandora.general.services.calculation.interfaces.CellTimestepService;
import com.pandora.general.services.calculation.interfaces.LocalDateTimeService;

/**
 * The {@code CellCalculationRequestServiceImpl} class implements the {@link CellCalculationRequestService} interface.
 * It is a service responsible for preprocessing and processing cell calculation requests. It is annotated with
 * {@link Service}. It utilizes various services for managing Y values, discharges, volumes, upstream sources,
 * terrestrial sources, local date-time operations, and cell timestep calculations.
 *
 * @author Wim Joost van Hoek
 * @version 0.0.1
 * @see CellCalculationRequestService
 */
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
