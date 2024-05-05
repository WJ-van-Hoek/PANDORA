package com.pandora.calculation.services;

import java.time.LocalDateTime;

/**
 * This interface defines the contract for a service responsible for managing terrestrial input data in memory.
 * It provides methods to retrieve terrestrial input data.
 */
public interface TerrestrialInputDataMemoryService {

    /**
     * Finds and retrieves the terrestrial input data for a specific timestamp and cell ID.
     *
     * @param localDateTime The timestamp indicating the datetime of the input data.
     * @param cellId        The unique identifier of the cell for which the data is being retrieved.
     * @return The array of double values representing the terrestrial input data, or null if not found.
     */
    double[] findData(LocalDateTime localDateTime, long cellId);
}
