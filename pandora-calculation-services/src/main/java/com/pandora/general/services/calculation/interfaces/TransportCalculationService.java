package com.pandora.general.services.calculation.interfaces;

import com.pandora.general.objects.PandoraTimestep;

/**
 * The {@code TransportCalculationService} interface defines a method for calculating the transport of each species
 * based on the given state variables and discharge rate. Implementing classes are responsible for performing
 * calculations related to species concentrations and transport changes based on the provided Pandora timestep.
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 */
public interface TransportCalculationService {
    /**
     * Calculates the transport of each species based on the given state variables and discharge rate.
     *
     * @param y The state variables representing species concentrations.
     * @param pandoraTimestep The Pandora timestep containing simulation parameters.
     * @return An array representing the changes in species concentrations due to transport.
     */
    double[] calculateTransport(double[] y, PandoraTimestep pandoraTimestep);
}
