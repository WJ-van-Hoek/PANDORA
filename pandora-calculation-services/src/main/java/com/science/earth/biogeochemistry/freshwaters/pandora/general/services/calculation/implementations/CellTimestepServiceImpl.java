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

@Service
public class CellTimestepServiceImpl implements CellTimestepService {

    /**
     * Service for accessing and manipulating the Y values map for geographical cells at specific timesteps in the
     * Pandora model.
     */
    @Autowired
    private YMapService yMapService;

    /**
     * Service for accessing terrestrial sources map data for geographical cells at specific timesteps in the Pandora
     * model.
     */
    @Autowired
    private TerrestrialSourcesMapService terrestrialSourcesMapService;

    /**
     * Service for accessing upstream sources map data for geographical cells at specific timesteps in the Pandora
     * model.
     */
    @Autowired
    private UpstreamSourcesMapService upstreamSourcesMapService;

    /**
     * Service for accessing discharges map data for geographical cells at specific timesteps in the Pandora model.
     */
    @Autowired
    private DischargesMapService dischargesMapService;

    /**
     * Service for accessing volumes map data for geographical cells at specific timesteps in the Pandora model.
     */
    @Autowired
    private VolumesMapService volumesMapService;

    /**
     * Service for integrating Pandora timesteps in the calculation process.
     */
    @Autowired
    private PandoraIntegratorService pandoraIntegratorService;

    /**
     * Service for managing local date and time operations in the Pandora model.
     */
    @Autowired
    private LocalDateTimeService localDateTimeService;

    /**
     * Service for CRUD operations on the geographical cell map in the Pandora model.
     */
    @Autowired
    private CellMapCrudService cellMapCrudService;

    /**
     * Calculates the time series of cell timesteps for the given cell starting from the specified time and for the
     * specified number of timesteps.
     *
     * @param cell The geographical cell for which the time series is calculated.
     * @param t0 The starting time of the time series.
     * @param numberOfTimesteps The number of timesteps to calculate.
     * @return A list of calculated cell timesteps.
     */
    @Override
    public List<CellTimestep> calculateTimeSeries(final Cell cell, final LocalDateTime t0,
            final int numberOfTimesteps) {
        List<CellTimestep> results = new ArrayList<>();
        List<LocalDateTime> dateTimeList = localDateTimeService.getDateTimeList(t0, numberOfTimesteps);

        for (
                int i = 0;
                    i < numberOfTimesteps;
                    i++) {
            CellTimestep nextTimestepResult = calculateNextTimestep(cell, dateTimeList.get(i));
            results.add(nextTimestepResult);
        }

        return results;
    }

    /**
     * Calculates the next cell timestep for the given cell at the specified time.
     *
     * @param cell The geographical cell for which the timestep is calculated.
     * @param t0 The starting time of the timestep.
     * @return The calculated cell timestep.
     */
    @Override
    public CellTimestep calculateNextTimestep(final Cell cell, final LocalDateTime t0) {
        PandoraTimestep preProcess = preProcessing(cell, t0);
        double[] result = pandoraIntegratorService.integrate(preProcess);

        CellTimestep postProcess = postProcessing(cell, t0, preProcess, result);
        return postProcess;
    }

    private PandoraTimestep preProcessing(final Cell cell, final LocalDateTime t0) {
        double[] y0 = yMapService.findAtCellAndTimestep(cell, t0);
        double[] terrestrialSources = terrestrialSourcesMapService.findAtCellAndTimestep(cell, t0);
        double[] upstreamSources = upstreamSourcesMapService.findAtCellAndTimestep(cell, t0);
        double q = dischargesMapService.findAtCellAndTimestep(cell, t0);
        double v = volumesMapService.findAtCellAndTimestep(cell, t0);
        return PandoraTimestep.builder().y0(y0).t0(0d).tEnd(1d).dimension(y0.length)
                .terrestrialSources(terrestrialSources).upstreamSources(upstreamSources).discharge(q).volume(v).build();
    }

    private CellTimestep postProcessing(final Cell cell, final LocalDateTime t0, final PandoraTimestep timestep,
            final double[] yEnd) {
        LocalDateTime tEnd = localDateTimeService.calculateTEndAsLocalDateTime(t0, timestep.getTEnd());
        yMapService.saveAtCellAndTimestep(cell, tEnd, yEnd);
        Cell nextCell = cellMapCrudService.findById(cell.getNextCellId());
        upstreamSourcesMapService.saveAtCellAndTimestep(nextCell, timestep, tEnd, yEnd);
        CellTimestep cellTimestep = CellTimestep.builder().cellParam(cell).y0Param(timestep.getY0()).t0Param(t0)
                .tEndParam(tEnd).build();
        cellTimestep.setYEnd(yEnd);
        return cellTimestep;
    }

}
