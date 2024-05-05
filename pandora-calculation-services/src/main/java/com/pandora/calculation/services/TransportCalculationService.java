package com.pandora.calculation.services;

import com.pandora.calculation.PandoraTimestep;

/**
 * Defines a service for calculating transport phenomena in a chemical simulation.
 * <p>
 * Implementations of this interface are responsible for computing the transport
 * of chemical species within a simulation, given the current state of the system
 * represented by the variables {@code y} and the information about the simulation
 * timestep provided by {@code pandoraTimestep}.
 * </p>
 * <p>
 * Users of this interface should provide implementations tailored to their specific
 * simulation requirements, considering factors such as diffusion, advection, and
 * other transport processes.
 * </p>
 *
 * @author Wim Joost van Hoek
 * @since 0.0.1
 */
public interface TransportCalculationService {

    /**
     * Calculates the transport of chemical species within the simulation.
     *
     * @param y The current state of the system, represented by an array of variables.
     * @param pandoraTimestep The timestep information for the current state of the simulation.
     * @return An array containing the computed transport derivatives for each variable.
     */
    double[] calculateTransport(double[] y, PandoraTimestep pandoraTimestep);
}
