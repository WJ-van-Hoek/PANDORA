package com.pandora.calculation.config;

/**
 * The Amountable interface represents entities that have an associated amount.
 * Implementing classes should provide a method to retrieve the amount of the entity.
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 */
public interface Amountable {

    /**
     * Retrieves the amount associated with this entity.
     *
     * @return the amount of the entity as a double value
     */
    double getAmount();
}
