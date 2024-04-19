package com.pandora.calculation.config;

/**
 * Represents an object that has a spatial location.
 */
public interface Spatial {

    /**
     * Returns the coordinates representing the location of this object.
     *
     * @return The coordinates of the object's location.
     */
    Coordinates getLocation();
}
