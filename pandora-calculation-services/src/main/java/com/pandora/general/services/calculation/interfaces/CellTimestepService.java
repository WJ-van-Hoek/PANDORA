package com.pandora.general.services.calculation.interfaces;

import java.time.LocalDateTime;
import java.util.List;

import com.pandora.general.objects.Cell;
import com.pandora.general.objects.CellTimestep;

/**
 * The {@code CellTimestepService} interface defines methods for calculating the time series of cell timesteps for a
 * given geographical cell. It includes methods to calculate a time series starting from a specified time and for a
 * specified number of timesteps, as well as to calculate the next cell timestep for a given cell at a specific time.
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 * @see Cell
 * @see CellTimestep
 * @see LocalDateTime
 */
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
