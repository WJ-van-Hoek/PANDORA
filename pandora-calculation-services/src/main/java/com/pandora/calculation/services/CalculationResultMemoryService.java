package com.pandora.calculation.services;

import java.time.LocalDateTime;

/**
 * This interface defines the contract for a service responsible for handling memory operations
 * related to calculation results.
 */
public interface CalculationResultMemoryService {

    /**
     * Saves the calculation result data for a specific timestamp and cell ID.
     *
     * @param localDateTime The timestamp indicating when the data was calculated.
     * @param cellId        The unique identifier of the cell for which the data is being saved.
     * @param data          The array of double values representing the calculation result.
     */
    void saveData(LocalDateTime localDateTime, long cellId, double[] data);

    /**
     * Finds and retrieves the calculation result data for a specific timestamp and cell ID.
     *
     * @param localDateTime The timestamp indicating when the data was calculated.
     * @param cellId        The unique identifier of the cell for which the data is being retrieved.
     * @return The array of double values representing the calculation result, or null if not found.
     */
    double[] findData(LocalDateTime localDateTime, long cellId);
}

