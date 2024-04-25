package com.pandora.calculation.repositories;

import java.util.Set;

import com.pandora.calculation.data.FixCellDataPoint;

/**
 * An interface representing a repository for storing FixCellDataPoint objects. Implementations of this interface are
 * responsible for saving and retrieving FixCellDataPoint objects.
 */
public interface FixCellDataRepository {

    /**
     * Saves the given FixCellDataPoint object.
     *
     * @param dataPoint The FixCellDataPoint to be saved.
     */
    void saveFixCellData(FixCellDataPoint dataPoint);

    /**
     * Retrieves the FixCellDataPoint object associated with the given ID.
     *
     * @param id The ID of the FixCellDataPoint to retrieve.
     * @return The FixCellDataPoint object associated with the given ID, or null if not found.
     */
    FixCellDataPoint findById(long id);

    /**
     * Retrieves the set of all IDs of stored FixCellDataPoint objects.
     *
     * @return A set containing all IDs of stored FixCellDataPoint objects.
     */
    Set<Long> findAllIds();
}

