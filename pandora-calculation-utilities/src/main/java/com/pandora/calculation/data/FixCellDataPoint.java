package com.pandora.calculation.data;

import lombok.Builder;

/**
 * Represents a data point associated with a fixed cell.
 */
public final class FixCellDataPoint {
    /**
     * The ID of the cell associated with this data point.
     */
    private final long _cellId;

    /**
     * The previous cell IDs associated with the FixCellDataPoint.
     */
    private final Long[] _previousCellIds;

    /**
     * The latitude associated with the FixCellDataPoint.
     */
    private final double _latitude;

    /**
     * The longitude associated with the FixCellDataPoint.
     */
    private final double _longitude;

    /**
     * Constructs a FixCellDataPoint object with the specified cell ID, latitude, longitude, and previous cell IDs.
     *
     * @param cellIdParam         The ID of the cell associated with this data point.
     * @param latitudeParam       The latitude associated with this data point.
     * @param longitudeParam      The longitude associated with this data point.
     * @param previousCellIdParams The previous cell IDs associated with this data point.
     */
    @Builder
    public FixCellDataPoint(final long cellIdParam, final double latitudeParam, final double longitudeParam,
                            final Long[] previousCellIdParams) {
        _cellId = cellIdParam;
        _latitude = latitudeParam;
        _longitude = longitudeParam;
        _previousCellIds = previousCellIdParams;
    }

    /**
     * Retrieves the ID of the cell associated with this data point.
     *
     * @return The cell ID.
     */
    public long getCellId() {
        return _cellId;
    }

    /**
     * Retrieves the previous cell IDs associated with this data point.
     *
     * @return An array of Long containing the previous cell IDs.
     */
    public Long[] getPreviousCellIds() {
        return _previousCellIds;
    }

    /**
     * Retrieves the latitude associated with this data point.
     *
     * @return The latitude.
     */
    public double getLatitude() {
        return _latitude;
    }

    /**
     * Retrieves the longitude associated with this data point.
     *
     * @return The longitude.
     */
    public double getLongitude() {
        return _longitude;
    }
}
