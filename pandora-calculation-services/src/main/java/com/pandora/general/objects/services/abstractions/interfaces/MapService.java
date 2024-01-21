package com.pandora.general.objects.services.abstractions.interfaces;

/**
 * The {@code MapService} interface defines a common method for cleaning or resetting the map managed by the service.
 * Implementations of this interface are expected to provide functionality for cleaning or resetting the internal map.
 * <p>
 * This interface is part of the abstraction layer for services related to managing maps.
 * </p>
 *
 * @author Wim Joost van Hoek
 * @version 0.0.1
 */
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
