package com.pandora.calculation.data;

import java.time.LocalDateTime;

import com.pandora.calculation.config.Coordinates;
import com.pandora.calculation.config.Spatial;
import com.pandora.calculation.config.Temporal;

/**
 * Represents a data point with both spatial and temporal attributes.
 */
public class SpatioTemporalDataPoint extends DataPoint implements Spatial, Temporal {

    /**
     * The spatial coordinates of the data point.
     */
    private final Coordinates coordinates;

    /**
     * The time stamp associated with the data point.
     */
    private final LocalDateTime timestamp;

    /**
     * Constructs a new SpatioTemporalDataPoint with the specified value, coordinates, and timestamp.
     *
     * @param value the value of the data point
     * @param coordinatesParam the spatial coordinates of the data point
     * @param timestampParam the timestamp associated with the data point
     */
    public SpatioTemporalDataPoint(final Double value, final Coordinates coordinatesParam,
            final LocalDateTime timestampParam) {
        super(value);
        coordinates = coordinatesParam;
        timestamp = timestampParam;
    }

    /**
     * Retrieves the spatial coordinates of the data point.
     *
     * @return the spatial coordinates of the data point
     */
    @Override
    public final Coordinates getLocation() {
        return coordinates;
    }

    /**
     * Retrieves the timestamp associated with the data point.
     *
     * @return the timestamp associated with the data point
     */
    @Override
    public final LocalDateTime getTimestamp() {
        return timestamp;
    }
}
