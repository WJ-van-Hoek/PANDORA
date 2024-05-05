package com.pandora.calculation.services;

import java.time.LocalDateTime;
import java.util.List;

import com.pandora.calculation.CellTimestep;
import com.pandora.calculation.data.FixCellDataPoint;

/**
 * Defines a service for calculating time series data for a cell's properties over a sequence of timesteps in a
 * simulation.
 * <p>
 * Implementations of this interface are responsible for generating time series data for a specified cell, starting from
 * a given initial time {@code t0} and continuing for a specified number of timesteps.
 * </p>
 * <p>
 * Users of this interface should provide implementations tailored to their specific simulation requirements,
 * considering factors such as cell properties, simulation duration, and timestep intervals.
 * </p>
 *
 * @author Wim Joost van Hoek
 * @since 0.0.1
 */
public interface CellProcessingService {

    /**
     * Calculates the time series data for a cell's properties over a sequence of timesteps.
     *
     * @param fixCellDataPoint The fixed cell configuration for which the timeseries is to be calculated.
     * @param t0 The initial time from which the time series starts.
     * @param numberOfTimesteps The number of timesteps for which data is to be calculated.
     * @return A list containing the time series data for the cell's properties.
     */
    List<CellTimestep> calculateTimeSeries(FixCellDataPoint fixCellDataPoint, LocalDateTime t0, int numberOfTimesteps);

    /**
     * Calculates the next timestep data for a cell.
     *
     * @param fixCellDataPoint The fixed cell configuration for which the timestep data is to be calculated.
     * @param t0 The current time.
     */
    void processNextTimestep(FixCellDataPoint fixCellDataPoint, LocalDateTime t0);
}
