package com.pandora.calculation.services;

import com.pandora.calculation.PandoraTimestep;

/**
 * Defines a service for performing numerical integration of Pandora simulations.
 * <p>
 * Implementations of this interface are responsible for integrating the Pandora
 * simulation over a specified timestep, computing the state of the system at the
 * next time instant based on the current state and dynamics.
 * </p>
 * <p>
 * Users of this interface should provide implementations tailored to their specific
 * simulation requirements, considering factors such as the integration method, accuracy,
 * and performance requirements of the simulation.
 * </p>
 *
 * @author Wim Joost van Hoek
 * @since 0.0.1
 */
public interface PandoraIntegratorService {

    /**
     * Integrates the Pandora simulation over the specified timestep.
     *
     * @param pandoraTimestep The current timestep information for the simulation.
     * @return The computed state of the system at the next time instant.
     */
    double[] integrate(PandoraTimestep pandoraTimestep);
}

