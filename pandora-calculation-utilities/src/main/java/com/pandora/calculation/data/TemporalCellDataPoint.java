package com.pandora.calculation.data;

import java.time.LocalDateTime;

public class TemporalCellDataPoint {
    /**
     * The cellDataPoint associated with the TemporalCellDataPoint.
     */
    private final CellDataPoint _cellDataPoint;

    /**
     * The time stamp associated with the TemporalDataPoint.
     */
    private final LocalDateTime _timestamp;

    /**
     * Constructs a new SpatioTemporalDataPoint with the specified CellDataPoint and timestamp.
     *
     * @param cellDataPoint the cellDataPoint associated with the TemporalCellDataPoint
     * @param timestamp the timestamp associated with the TemporalCellDataPoint
     */
    public TemporalCellDataPoint(final CellDataPoint cellDataPoint, final LocalDateTime timestamp) {
        _cellDataPoint = cellDataPoint;
        _timestamp = timestamp;
    }

    /**
     * Constructs a TemporalCellDataPoint object with the specified cell ID, value, and timestamp.
     *
     * @param cellId The ID of the cell associated with this data point.
     * @param value The value associated with this data point.
     * @param timestamp The timestamp indicating when the data point was recorded.
     */
    public TemporalCellDataPoint(final int cellId, final double value, final LocalDateTime timestamp) {
        _cellDataPoint = new CellDataPoint(cellId, value);
        _timestamp = timestamp;
    }

    /**
     * Retrieves the cellDataPoint of the TemporalCellDataPoint.
     *
     * @return the cellDataPoint of the TemporalCellDataPoint
     */
    public final CellDataPoint getCellDataPoint() {
        return _cellDataPoint;
    }

    /**
     * Retrieves the timestamp associated with the data point.
     *
     * @return the timestamp associated with the data point
     */
    public final LocalDateTime getTimestamp() {
        return _timestamp;
    }
}
