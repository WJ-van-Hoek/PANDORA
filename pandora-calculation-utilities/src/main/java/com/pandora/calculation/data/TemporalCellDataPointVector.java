package com.pandora.calculation.data;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents a collection of {@link CellDataPointVector} indexed by {@link LocalDateTime}.
 */
public final class TemporalCellDataPointVector {

    /**
     * Map to store {@link CellDataPointVector} indexed by {@link LocalDateTime}.
     */
    private Map<LocalDateTime, CellDataPointVector> _dataMap = new HashMap<>();

    /**
     * Adds a {@link TemporalCellDataPoint} to the appropriate {@link CellDataPointVector} in the collection.
     *
     * @param dataPoint The {@link TemporalCellDataPoint} to add.
     */
    public void add(final TemporalCellDataPoint dataPoint) {
        // If the timestamp does not exist, create a new CellDataPointVector and add the data point
        // Otherwise, add the data point to the existing CellDataPointVector
        _dataMap.computeIfAbsent(dataPoint.getTimestamp(), k -> new CellDataPointVector())
                .add(dataPoint.getCellDataPoint());
    }

    /**
     * Retrieves a {@link CellPointDataVector} at a given {@link LocalDateTime}.
     *
     * @param localDateTime The {@link LocalDateTime} at which the CellDataPointVector is desired
     * @return the {@link CellDataPointVector} at given {@link LocalDateTime}
     */
    public CellDataPointVector getDataAtTime(final LocalDateTime localDateTime) {
        return _dataMap.get(localDateTime);
    }

    /**
     * Retrieves all CellDataPointVector in the dataMap.
     *
     * @return Collection<CellDataPointVector> The FixCellDataPointVectors in the {@link dataMap}
     */
    public Collection<CellDataPointVector> getAllDataPointVectors() {
        return _dataMap.values();
    }

    /**
     * Retrieves all LocalDateTimes in the dataMap.
     *
     * @return Collection<LocalDateTime> The localDateTimes in the {@link dataMap}
     */
    public Collection<LocalDateTime> getAllLocalDateTimes() {
        return _dataMap.keySet();
    }
}
