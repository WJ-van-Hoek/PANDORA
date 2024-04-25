package com.pandora.calculation.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import com.pandora.calculation.data.TemporalCellDataPointVector;
import com.pandora.calculation.repositories.TemporalCellDataRepository;

/**
 * An abstract implementation of TemporalCellDataMemoryService that delegates data storage and retrieval operations to a
 * provided TemporalCellDataRepository.
 *
 * @param <T> The type of TemporalCellDataRepository implementation used by this service.
 */
public abstract class TemporalCellDataMemoryServiceImpl<T extends TemporalCellDataRepository>
        implements TemporalCellDataMemoryService {

    /**
     * The TemporalCellDataRepository instance used for data storage and retrieval.
     */
    @Autowired
    private T _repository;

    /**
     * Saves the provided TemporalCellDataPointVector object.
     *
     * @param temporalVector The TemporalCellDataPointVector object containing the data to be saved.
     */
    @Override
    public void saveData(final TemporalCellDataPointVector temporalVector) {
        _repository.saveData(temporalVector);
    }

    /**
     * Retrieves the data value associated with the given LocalDateTime and index.
     *
     * @param dateTime The LocalDateTime for which to retrieve the data value.
     * @param index The index of the data value to retrieve.
     * @return The data value associated with the given LocalDateTime and index, or null if not found.
     */
    @Override
    public Double findData(final LocalDateTime dateTime, final long index) {
        return _repository.findData(dateTime, index);
    }
}
