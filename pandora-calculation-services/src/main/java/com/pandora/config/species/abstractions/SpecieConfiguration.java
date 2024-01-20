package com.pandora.config.species.abstractions;

import com.pandora.config.VariableConfiguration;

/**
 * The {@code SpecieConfiguration} interface extends the {@link VariableConfiguration} interface and provides an
 * additional method for retrieving the molar mass of the biogeochemical species. The molar mass represents the mass of
 * one mole of the species and is a crucial parameter for various biogeochemical calculations.
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 * @see VariableConfiguration
 */
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
