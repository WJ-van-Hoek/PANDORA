package com.pandora.calculation.data;

/**
 * Represents a data point associated with a cell.
 */
public class CellDataPoint extends DataPoint {
    /**
     * cellId The ID of the cell associated with this data point.
     */
    private final long _cellId;

    /**
     * Constructs a CellDataPoint object with the specified cell ID and value.
     *
     * @param cellId The ID of the cell associated with this data point.
     * @param value       The value associated with this data point.
     */
    public CellDataPoint(final long cellId, final double value) {
        super(value);
        _cellId = cellId;
    }

    /**
     * Gets the ID of the cell associated with this data point.
     *
     * @return The cell ID.
     */
    public long getCellId() {
        return _cellId;
    }
}
