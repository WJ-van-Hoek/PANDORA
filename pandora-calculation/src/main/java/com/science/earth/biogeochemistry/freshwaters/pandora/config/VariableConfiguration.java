package com.science.earth.biogeochemistry.freshwaters.pandora.config;

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
