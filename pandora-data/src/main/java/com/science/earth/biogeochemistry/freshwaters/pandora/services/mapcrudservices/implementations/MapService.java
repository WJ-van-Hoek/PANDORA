package com.pandora.services.mapcrudservices.implementations;

public interface MapService {
    /**
     * Cleans the map, resetting or removing entries to achieve a clean state.
     *
     * <p>
     * The specific actions taken during the cleaning process are determined by the implementing class. Users should
     * call this method to initiate the cleaning operation, and the exact behavior may vary depending on the
     * implementation.
     */
    void cleanMap();
}
