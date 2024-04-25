package com.pandora.calculation.services;

import java.time.LocalDateTime;

import com.pandora.calculation.data.TemporalCellDataPointVector;

/**
 * A service interface for saving and retrieving temporal cell data from memory.
 */
public interface TemporalCellDataMemoryService {

    /**
     * Saves the temporal vector of cell data.
     *
     * @param temporalVector The temporal vector containing cell data points to be saved.
     */
    void saveData(TemporalCellDataPointVector temporalVector);

    /**
     * Retrieves the data value associated with the given LocalDateTime and index.
     *
     * @param dateTime The LocalDateTime for which to retrieve the data value.
     * @param index    The index of the data value to retrieve.
     * @return The data value associated with the given LocalDateTime and index, or null if not found.
     */
    Double findData(LocalDateTime dateTime, long index);
}
