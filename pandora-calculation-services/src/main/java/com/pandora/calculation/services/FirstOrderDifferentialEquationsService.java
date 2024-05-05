package com.pandora.calculation.services;

import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;

import com.pandora.calculation.PandoraTimestep;

/**
 * Defines a service for providing first-order ordinary differential equations (ODEs)
 * for a Pandora simulation.
 * <p>
 * Implementations of this interface are responsible for returning the set of
 * differential equations that govern the dynamics of the simulation, based on the
 * provided {@code pandoraTimestep}.
 * </p>
 * <p>
 * Users of this interface should provide implementations tailored to their specific
 * simulation requirements, considering factors such as the state variables, reaction
 * rates, and transport phenomena involved in the simulation.
 * </p>
 *
 * @author Wim Joost van Hoek
 * @since 0.0.1
 */
public interface FirstOrderDifferentialEquationsService {

    /**
     * Gets the first-order ordinary differential equations (ODEs) for the Pandora simulation.
     *
     * @param pandoraTimestep The current timestep information for the simulation.
     * @return The first-order differential equations governing the simulation dynamics.
     */
    FirstOrderDifferentialEquations getPandoraDifferentialEquations(PandoraTimestep pandoraTimestep);
}

