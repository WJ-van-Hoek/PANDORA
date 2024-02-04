package com.pandora.calculation.config;

/**
 * Represents an indexed object
 *
 * <p>
 * Implementing classes must provide a method to retrieve the index.
 *
 * @author Wim Joost van Hoek
 * @version 0.0.1
 * @since 0.0.1
 */
public interface Indexed {
    /**
     * @return the configured index of the object.
     */
    int getIndex();
}
