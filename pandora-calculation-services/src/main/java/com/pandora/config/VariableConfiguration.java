package com.pandora.config;

/**
 * The {@code VariableConfiguration} interface represents a configuration for a variable within the PANDORA model.
 * <p>
 * Implementing classes should provide meaningful implementations for retrieving the index, name, and unit associated
 * with the variable configuration.
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 */
public interface VariableConfiguration {
    /**
     * Retrieves the index associated with the variable configuration. The index represents the position of the variable
     * within the overall configuration.
     *
     * @return The index of the variable configuration.
     */
    int getIndex();

    /**
     * Retrieves the name associated with the variable configuration. The name is a human-readable identifier for the
     * variable.
     *
     * @return The name of the variable configuration.
     */
    String getName();

    /**
     * Retrieves the unit associated with the variable configuration. The unit represents the measurement unit for the
     * variable.
     *
     * @return The unit of the variable configuration.
     */
    String getUnit();
}
