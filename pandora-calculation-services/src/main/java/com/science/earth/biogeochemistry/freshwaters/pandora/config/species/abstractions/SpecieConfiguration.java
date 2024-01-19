package com.science.earth.biogeochemistry.freshwaters.pandora.config.species.abstractions;

import com.science.earth.biogeochemistry.freshwaters.pandora.config.VariableConfiguration;

public interface SpecieConfiguration extends VariableConfiguration {
    /**
     * Retrieves the molar mass of the biogeochemical species. The molar mass
     * represents the mass of one mole of the species and is a crucial parameter
     * for various biogeochemical calculations.
     *
     * @return The molar mass of the biogeochemical species.
     */
    double getMolarMass();
}
