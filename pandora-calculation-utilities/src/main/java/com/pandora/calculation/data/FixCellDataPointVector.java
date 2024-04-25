package com.pandora.calculation.data;

import java.util.HashMap;
import java.util.Map;

public class FixCellDataPointVector {
    /**
     * Map to store cell data points, where the key is the cell ID and the value is a FixCellDataPoint.
     */
    private final Map<Integer, FixCellDataPoint> data = new HashMap<>();

    /**
     * Adds a FixCellDataPoint to the vector.
     *
     * @param dataPoint The cell data point to add.
     */
    public void add(final FixCellDataPoint dataPoint) {
        data.put(dataPoint.getCellId(), dataPoint);
    }
}
