package com.pandora.calculation.data;

import com.pandora.calculation.config.Coordinates;
import com.pandora.calculation.config.Spatial;

/**
 * Represents a data point with spatial attributes.
 */
public class SpatialDataPoint extends DataPoint implements Spatial {

    /**
     * The spatial coordinates of the data point.
     */
    private final Coordinates coordinates;

    /**
     * Constructs a new SpatialDataPoint with the specified value and coordinates.
     *
     * @param valueParam       the value of the data point
     * @param coordinateParam the spatial coordinates of the data point
     */
    public SpatialDataPoint(final Double valueParam, final Coordinates coordinateParam) {
        super(valueParam);
        coordinates = coordinateParam;
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
}

