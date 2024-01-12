package com.science.earth.biogeochemistry.freshwaters.pandora.config.species.abstractions;

public interface SpecieLogic {
    /**
     * Calculates the transport of the biogeochemical species based on the given
     * amount and discharge parameters. The transport calculation is influenced
     * by the specific logic associated with the behavior of the species in the
     * freshwater system.
     *
     * @param amount The amount of the biogeochemical species.
     * @param discharge The discharge rate in the freshwater system.
     * @return The calculated transport value for the species.
     */
    double calculateTransport(double amount, double discharge);
}
