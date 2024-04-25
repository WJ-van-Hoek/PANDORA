package com.pandora.calculation.data;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
/**
 * Represents a collection of {@link CellDataPointVector} indexed by {@link LocalDateTime}.
 */
public final class TemporalCellDataPointVector {

    /**
     * Map to store {@link CellDataPointVector} indexed by {@link LocalDateTime}.
     */
    private Map<LocalDateTime, CellDataPointVector> data = new HashMap<>();

    /**
     * Adds a {@link TemporalCellDataPoint} to the appropriate {@link CellDataPointVector}
     * in the collection.
     *
     * @param dataPoint The {@link TemporalCellDataPoint} to add.
     */
    public void add(final TemporalCellDataPoint dataPoint) {
        // If the timestamp does not exist, create a new CellDataPointVector and add the data point
        // Otherwise, add the data point to the existing CellDataPointVector
        data.computeIfAbsent(dataPoint.getTimestamp(), k -> new CellDataPointVector())
            .add(dataPoint.getCellDataPoint());
    }
}

