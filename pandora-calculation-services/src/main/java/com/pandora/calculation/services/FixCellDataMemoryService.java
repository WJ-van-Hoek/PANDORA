package com.pandora.calculation.services;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.pandora.calculation.data.FixCellDataPoint;

/**
 * An interface representing a service for handling FixCellData in memory.
 *
 * This service allows for saving and retrieving FixCellDataPoint objects in memory.
 *
 * @author Wim Joost van Hoek
 * @since 0.0.1
 */
public interface FixCellDataMemoryService {

    /**
     * Saves the provided FixCellDataPoint object into memory.
     *
     * @param dataPoint The FixCellDataPoint object to be saved.
     */
    void saveFixCellData(FixCellDataPoint dataPoint);

    /**
     * Saves the provided collection of FixCellDataPoint objects into memory.
     *
     * @param dataPoints The collection of FixCellDataPoint objects to be saved.
     */
    void saveFixCellData(Collection<FixCellDataPoint> dataPoints);

    /**
     * Retrieves the FixCellDataPoint object associated with the given ID.
     *
     * @param id The ID of the FixCellDataPoint to retrieve.
     * @return The FixCellDataPoint object associated with the given ID, or null if not found.
     */
    FixCellDataPoint findById(long id);

    /**
     * Finds independent cell sets from the stored FixCellDataPoints.
     *
     * @return A List containing sets of cell IDs representing independent cell sets.
     */
    List<Set<FixCellDataPoint>> findParallelCellSets();
}
