package com.pandora.calculation.repositories;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

/**
 * This repository class implements the {@link CalculationResultMemoryRepository} interface to provide memory storage
 * and retrieval functionality for calculation results. It uses a nested map structure to store calculation results
 * based on LocalDateTime and cellId.
 */
@Repository
public class CalculationResultMemoryRepositoryImpl implements CalculationResultMemoryRepository {

    /**
     * Map to store the calculation results. The outer map keys are LocalDateTime objects, and the inner map keys are
     * cellId values. The inner map values are arrays of double values representing the calculation results.
     */
    private Map<LocalDateTime, Map<Long, double[]>> _dataMap = new HashMap<>();

    /**
     * Saves the calculation result data for a specific timestamp and cell ID.
     *
     * @param localDateTime The timestamp indicating when the data was calculated.
     * @param cellId The unique identifier of the cell for which the data is being saved.
     * @param data The array of double values representing the calculation result.
     */
    @Override
    public void saveData(final LocalDateTime localDateTime, final long cellId, final double[] data) {
        // Get or create a map for the given LocalDateTime
        Map<Long, double[]> cellDataMap = _dataMap.computeIfAbsent(localDateTime, k -> new HashMap<>());
        // Store the data in the map for the given cellId
        cellDataMap.put(cellId, data);
    }

    /**
     * Finds and retrieves the calculation result data for a specific timestamp and cell ID.
     *
     * @param localDateTime The timestamp indicating when the data was calculated.
     * @param cellId The unique identifier of the cell for which the data is being retrieved.
     * @return The array of double values representing the calculation result, or null if not found.
     */
    @Override
    public double[] findData(final LocalDateTime localDateTime, final long cellId) {
        // Retrieve the map for the given LocalDateTime
        Map<Long, double[]> cellDataMap = _dataMap.get(localDateTime);
        // If the map exists, return the data for the given cellId, otherwise return null
        return cellDataMap != null ? cellDataMap.get(cellId) : null;
    }
}
