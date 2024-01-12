package com.science.earth.biogeochemistry.freshwaters.pandora.config.reactions.abstractions;

import java.util.Map;

import com.science.earth.biogeochemistry.freshwaters.pandora.config.species.abstractions.Specie;

public interface ReactionConfiguration {
    /**
     * Initializes the reaction configuration. This method is called during the initialization phase and is responsible
     * for setting up any required parameters or states for the reaction.
     */
    void initialize();

    /**
     * Retrieves a map representing the species produced by the reaction and their corresponding production quantities.
     *
     * @return A map associating instances of
     * {@link com.science.earth.biogeochemistry.freshwaters.pandora.config.species .abstractions.Specie} with their
     * production values.
     */
    Map<Specie, Integer> getProducedSpecies();

    /**
     * Retrieves a map representing the species removed by the reaction and their corresponding removal quantities.
     *
     * @return A map associating instances of
     * {@link com.science.earth.biogeochemistry.freshwaters.pandora.config.species .abstractions.Specie} with their
     * removal values.
     */
    Map<Specie, Integer> getRemovedSpecies();

    /**
     * Calculates the changes in species concentrations based on the provided array of concentrations.
     *
     * @param y An array representing the concentrations of chemical species involved in the reaction.
     * @return An array representing the changes in concentrations for each chemical species.
     */
    double[] calculate(double[] y);
}
