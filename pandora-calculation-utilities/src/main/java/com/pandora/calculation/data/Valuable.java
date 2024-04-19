package com.pandora.calculation.data;

/**
 * The {@code Valuable} interface represents objects that have a monetary value. Classes that implement this interface
 * must provide a method to retrieve the value.
 */
public interface Valuable {

    /**
     * Retrieves the monetary value of the object.
     *
     * @return the monetary value of the object as a double.
     */
    double getValue();
}
