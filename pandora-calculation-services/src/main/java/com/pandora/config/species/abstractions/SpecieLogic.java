package com.pandora.config.species.abstractions;

/**
 * The {@code SpecieLogic} interface defines methods for calculating the transport of a biogeochemical species in the
 * freshwater system. Implementing classes should provide concrete implementations for the
 * {@link #calculateTransport(double, double)} method, which calculates the transport value based on the given amount
 * and discharge parameters. The transport calculation is influenced by the specific logic associated with the behavior
 * of the species in the freshwater system.
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 * @see SpecieConfiguration
 */
public interface SpecieLogic {
    /**
     * Calculates the transport of the biogeochemical species based on the given amount and discharge parameters. The
     * transport calculation is influenced by the specific logic associated with the behavior of the species in the
     * freshwater system.
     *
     * @param amount The amount of the biogeochemical species.
     * @param discharge The discharge rate in the freshwater system.
     * @return The calculated transport value for the species.
     */
    double calculateTransport(double amount, double discharge);
}
