package com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.interfaces;

public interface MapService {
    /**
     * Cleans or resets the map managed by the service.
     *
     * <p>
     * This method removes all entries from the map or performs any necessary cleanup operations to reset the state of
     * the map.
     * </p>
     */
    void cleanMap();
}
