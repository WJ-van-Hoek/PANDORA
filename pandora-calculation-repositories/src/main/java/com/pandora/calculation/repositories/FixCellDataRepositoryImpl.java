package com.pandora.calculation.repositories;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.pandora.calculation.data.FixCellDataPoint;

@Repository
public final class FixCellDataRepositoryImpl implements FixCellDataRepository {

    /**
     * The map to store FixCellDataPoints, using the CellId of the FixCellDataPoint as the key.
     */
    private final Map<Long, FixCellDataPoint> _dataPoints = new HashMap<>();

    @Override
    public void saveFixCellData(final FixCellDataPoint dataPoint) {
        long index = dataPoint.getCellId();
        if (_dataPoints.containsKey(index)) {
            throw new IllegalArgumentException("Index already exists in FixCellDataRepository: " + index);
        }
        _dataPoints.put(index, dataPoint);
    }

    @Override
    public FixCellDataPoint findById(final long id) {
        return _dataPoints.get(id);
    }

    @Override
    public Set<Long> findAllIds() {
        return _dataPoints.keySet();
    }
}
