package com.pandora.calculation.data;

import java.util.HashMap;
import java.util.Map;

/**
 * A wrapper class for storing grouped CellDataPoints.
 */
public final class CellDataPointVector {
    /**
     * Map to store cell data points, where the key is the cell ID and the value is the data value.
     */
    private final Map<Long, Double> _data = new HashMap<>();

    /**
     * Adds a cell data point to the vector.
     *
     * @param dataPoint The cell data point to add.
     */
    public void add(final CellDataPoint dataPoint) {
        _data.put(dataPoint.getCellId(), dataPoint.getValue());
    }

    /**
     * Retrieves the data value associated with the given cell ID.
     *
     * @param cellId The ID of the cell to retrieve the data value for.
     * @return The data value associated with the given cell ID, or null if the cell ID is not found.
     */
    public Double get(final Long cellId) {
        return _data.get(cellId);
    }
}

