package com.pandora.calculation.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pandora.calculation.repositories.CalculationResultMemoryRepository;

/**
 * This service class implements the {@link CalculationResultMemoryService} interface to handle the memory operations
 * related to calculation results. It interacts with a {@link CalculationResultMemoryRepository} for data storage and
 * retrieval.
 */
@Service
public class CalculationResultMemoryServiceImpl implements CalculationResultMemoryService {

    /**
     * The repository responsible for storing and retrieving calculation result data.
     */
    @Autowired
    private CalculationResultMemoryRepository _calculationResultMemoryRepository;

    /**
     * Saves the calculation result data for a specific timestamp and cell ID.
     *
     * @param localDateTime The timestamp indicating when the data was calculated.
     * @param cellId The unique identifier of the cell for which the data is being saved.
     * @param data The array of double values representing the calculation result.
     */
    @Override
    public void saveData(final LocalDateTime localDateTime, final long cellId, final double[] data) {
        _calculationResultMemoryRepository.saveData(localDateTime, cellId, data);
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
        return _calculationResultMemoryRepository.findData(localDateTime, cellId);
    }
}
