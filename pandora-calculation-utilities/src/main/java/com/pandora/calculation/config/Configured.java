package com.pandora.calculation.config;

public interface Configured<T extends Configuration> {
    /**
     * @return the configuration of the object
     */
    T getConfiguration();
}
