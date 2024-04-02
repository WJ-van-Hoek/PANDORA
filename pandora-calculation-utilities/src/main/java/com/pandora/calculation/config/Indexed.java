package com.pandora.calculation.config;

/**
 * Represents an indexed object
 *
 * <p>
 * Implementing classes must provide a method to retrieve the index.
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 */
public interface Indexed {
    /**
     * @return the configured index of the object.
     */
    int getIndex();
}
