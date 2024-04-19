package com.pandora.calculation.data;

import lombok.Getter;

@Getter
public class FixCellDataPoint {
    /**
     * cellId The ID of the cell associated with this data point.
     */
    private final int cellId;

    /**
     * The latitude associated with the FixCellDataPoint.
     */
    private final double latitude;

    /**
     * The longitude associated with the FixCellDataPoint.
     */
    private final double longitude;

    /**
     * The previous_cell_id associated with the FixCellDataPoint.
     */
    private final Integer previousCellId;

    /**
     * Constructs a FixCellDataPoint object with the specified cell ID, latitude, longitude and previousCellId.
     *
     * @param cellIdParam The ID of the cell associated with this data point.
     * @param latitudeParam The latitude associated with this data point.
     * @param longitudeParam The longitude associated with this data point.
     * @param previousCellIdParam The previousCellId associated with this data point.
     */
    public FixCellDataPoint(final int cellIdParam, final double latitudeParam, final double longitudeParam,
            final Integer previousCellIdParam) {
        this.cellId = cellIdParam;
        this.latitude = latitudeParam;
        this.longitude = longitudeParam;
        this.previousCellId = previousCellIdParam;
    }
}
