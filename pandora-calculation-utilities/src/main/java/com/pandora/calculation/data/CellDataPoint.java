package com.pandora.calculation.data;

/**
 * Represents a data point associated with a cell.
 */
public class CellDataPoint extends DataPoint {
    /**
     * cellId The ID of the cell associated with this data point.
     */
    private final int cellId;

    /**
     * Constructs a CellDataPoint object with the specified cell ID and value.
     *
     * @param cellIdParam The ID of the cell associated with this data point.
     * @param value       The value associated with this data point.
     */
    public CellDataPoint(final int cellIdParam, final double value) {
        super(value);
        this.cellId = cellIdParam;
    }

    /**
     * Gets the ID of the cell associated with this data point.
     *
     * @return The cell ID.
     */
    public int getCellId() {
        return cellId;
    }
}
