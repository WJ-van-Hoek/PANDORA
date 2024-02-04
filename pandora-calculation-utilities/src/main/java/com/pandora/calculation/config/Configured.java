package com.pandora.calculation.config;

/**
 * An interface representing an object that is configured with a specific type of configuration.
 *
 * @param <T> The type of configuration object.
 */
public interface Configured<T extends Configuration> {
    /**
     * @return the configuration of the object
     */
    T getConfiguration();
}
