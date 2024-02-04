package com.pandora.calculation.config;

/**
 * The Changeable interface represents entities that have an associated change.
 * Implementing classes should provide a method to retrieve the change of the entity.
 *
 * @author Wim Joost van Hoek
 * @version 0.0.1
 * @since 0.0.1
 */
public interface Changeable {
    /**
     * Retrieves the change of the entity.
     *
     * @return the change of the entity as a double value
     */
    double getChange();
}
