package com.pandora.calculation.repositories;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.pandora.calculation.data.CellDataPointVector;
import com.pandora.calculation.data.TemporalCellDataPointVector;

/**
 * An implementation of TemporalCellDataRepository that stores cell data points indexed by LocalDateTime.
 */
public abstract class TemporalCellDataRepositoryImpl implements TemporalCellDataRepository {

    /**
     * Map to store {@link CellDataPointVector} indexed by {@link LocalDateTime}.
     */
    private Map<LocalDateTime, CellDataPointVector> _dataMap = new HashMap<>();

    /**
     * Saves the temporal vector of cell data into the repository.
     *
     * @param temporalVector The temporal vector containing cell data points to be saved.
     */
    public final void saveData(final TemporalCellDataPointVector temporalVector) {
        temporalVector.getAllLocalDateTimes().forEach(d -> _dataMap.put(d, temporalVector.getDataAtTime(d)));
    }

    /**
     * Retrieves the data value associated with the given LocalDateTime and index.
     *
     * @param localDateTime The LocalDateTime for which to retrieve the data value.
     * @param cellId        The index of the data value to retrieve within the CellDataPointVector.
     * @return The data value associated with the given LocalDateTime and index, or null if not found.
     */
    public final Double findData(final LocalDateTime localDateTime, final long cellId) {
        return _dataMap.get(localDateTime).get(cellId);
    }
}

