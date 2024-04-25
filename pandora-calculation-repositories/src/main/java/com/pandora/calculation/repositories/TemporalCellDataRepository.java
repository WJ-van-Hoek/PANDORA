package com.pandora.calculation.repositories;

import java.time.LocalDateTime;

import com.pandora.calculation.data.TemporalCellDataPointVector;

/**
 * A repository for saving and retrieving temporal cell data.
 */
public interface TemporalCellDataRepository {

    /**
     * Saves the temporal vector of cell data.
     *
     * @param temporalVector The temporal vector containing cell data points to be saved.
     */
    void saveData(TemporalCellDataPointVector temporalVector);

    /**
     * Retrieves the data value associated with the given LocalDateTime and index.
     *
     * @param localDateTime The LocalDateTime for which to retrieve the data value.
     * @param index         The index of the data value to retrieve within the vector.
     * @return The data value associated with the given LocalDateTime and index, or null if not found.
     */
    Double findData(LocalDateTime localDateTime, long index);
}

