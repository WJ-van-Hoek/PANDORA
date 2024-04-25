package com.pandora.calculation.config;

/**
 * Represents geographic coordinates consisting of latitude and longitude.
 */
public class Coordinates {
    /**
     * The latitude value of the coordinates.
     */
    private final double latitude;

    /**
     * The longitude value of the coordinates.
     */
    private final double longitude;

    /**
     * Constructs a Coordinates object with the specified latitude and longitude values.
     *
     * @param latitudeParam  The latitude value of the coordinates.
     * @param longitudeParam The longitude value of the coordinates.
     */
    public Coordinates(final double latitudeParam, final double longitudeParam) {
        this.latitude = latitudeParam;
        this.longitude = longitudeParam;
    }

    /**
     * Returns the latitude value of the geographical coordinates.
     *
     * @return The latitude value.
     */
    public double getLatitude() {
        return this.latitude;
    }

    /**
     * Returns the longitude value of the geographical coordinates.
     *
     * @return The longitude value.
     */
    public double getLongitude() {
        return this.longitude;
    }

    @Override
    public final String toString() {
        return String.format("%.2f", getLatitude()).concat(String.format("%.2f", getLongitude()));
    }
}
