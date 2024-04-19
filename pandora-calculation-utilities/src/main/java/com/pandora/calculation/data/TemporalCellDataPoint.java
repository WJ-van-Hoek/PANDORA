package com.pandora.calculation.data;

import java.time.LocalDateTime;

public class TemporalCellDataPoint {
    /**
     * The cellDataPoint associated with the TemporalCellDataPoint.
     */
    private final CellDataPoint cellDataPoint;

    /**
     * The time stamp associated with the TemporalDataPoint.
     */
    private final LocalDateTime timestamp;

    /**
     * Constructs a new SpatioTemporalDataPoint with the specified CellDataPoint and timestamp.
     *
     * @param cellDataPointParam the cellDataPoint associated with the TemporalCellDataPoint
     * @param timestampParam the timestamp associated with the TemporalCellDataPoint
     */
    public TemporalCellDataPoint(final CellDataPoint cellDataPointParam, final LocalDateTime timestampParam) {
        cellDataPoint = cellDataPointParam;
        timestamp = timestampParam;
    }

    /**
     * Constructs a TemporalCellDataPoint object with the specified cell ID, value, and timestamp.
     *
     * @param cellId The ID of the cell associated with this data point.
     * @param value The value associated with this data point.
     * @param timestampParam The timestamp indicating when the data point was recorded.
     */
    public TemporalCellDataPoint(final int cellId, final double value, final LocalDateTime timestampParam) {
        cellDataPoint = new CellDataPoint(cellId, value);
        timestamp = timestampParam;
    }

    /**
     * Retrieves the cellDataPoint of the TemporalCellDataPoint.
     *
     * @return the cellDataPoint of the TemporalCellDataPoint
     */
    public final CellDataPoint getCellDataPoint() {
        return cellDataPoint;
    }

    /**
     * Retrieves the timestamp associated with the data point.
     *
     * @return the timestamp associated with the data point
     */
    public final LocalDateTime getTimestamp() {
        return timestamp;
    }
}
