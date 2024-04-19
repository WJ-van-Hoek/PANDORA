package com.pandora.calculation.data;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a vector of cell data points.
 */
public final class CellDataPointVector {
    /**
     * Map to store cell data points, where the key is the cell ID and the value is the data value.
     */
    private final Map<Integer, Double> data = new HashMap<>();

    /**
     * Adds a cell data point to the vector.
     *
     * @param dataPoint The cell data point to add.
     */
    public void add(final CellDataPoint dataPoint) {
        data.put(dataPoint.getCellId(), dataPoint.getValue());
    }
}

