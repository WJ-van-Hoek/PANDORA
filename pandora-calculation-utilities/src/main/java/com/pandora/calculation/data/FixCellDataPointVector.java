package com.pandora.calculation.data;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Wrapper class for storage of fixed cell data points.
 */
public class FixCellDataPointVector {
    /**
     * Map to store fixed cell data points, where the key is the cell ID and the value is a FixCellDataPoint.
     */
    private final Map<Long, FixCellDataPoint> _dataMap = new HashMap<>();

    /**
     * Adds a FixCellDataPoint to the vector.
     *
     * @param dataPoint The cell data point to add.
     */
    public void add(final FixCellDataPoint dataPoint) {
        _dataMap.put(dataPoint.getCellId(), dataPoint);
    }

    /**
     * Retrieves all FixCellDataPoint in the dataMap.
     *
     * @return Collection<FixCellDataPoint> The FixCellDataPoints in the {@link dataMap}
     */
    public Collection<FixCellDataPoint> getAllFixCellDataPoints() {
        return _dataMap.values();
    }

}
