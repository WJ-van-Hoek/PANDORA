package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces;

import java.time.LocalDateTime;
import java.util.List;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.Cell;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.CellTimestep;

public interface CellTimestepService {
    /**
     * Calculates the time series of cell timesteps for the given cell starting from the specified time and for the
     * specified number of timesteps.
     *
     * @param cell The geographical cell for which the time series is calculated.
     * @param t0 The starting time of the time series.
     * @param numberOfTimesteps The number of timesteps to calculate.
     * @return A list of calculated cell timesteps.
     */
    List<CellTimestep> calculateTimeSeries(Cell cell, LocalDateTime t0, int numberOfTimesteps);

    /**
     * Calculates the next cell timestep for the given cell at the specified time.
     *
     * @param cell The geographical cell for which the timestep is calculated.
     * @param t0 The starting time of the timestep.
     * @return The calculated cell timestep.
     */
    CellTimestep calculateNextTimestep(Cell cell, LocalDateTime t0);
}
