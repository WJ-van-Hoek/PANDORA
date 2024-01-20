package com.pandora.general.services.calculation.interfaces;

import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;

import com.pandora.general.objects.PandoraTimestep;

/**
 * The {@code FirstOrderDifferentialEquationsService} interface defines a method for creating and returning a set of
 * first-order differential equations for the Pandora model based on the provided {@code PandoraTimestep}. Implementing
 * classes are responsible for constructing the differential equations using the simulation parameters contained in the
 * provided {@code PandoraTimestep}.
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 * @see PandoraTimestep
 * @see FirstOrderDifferentialEquations
 */
public interface FirstOrderDifferentialEquationsService {
    /**
     * Creates and returns a set of first-order differential equations for the Pandora model based on the provided
     * {@code PandoraTimestep}.
     *
     * @param pandoraTimestep The Pandora timestep containing simulation parameters.
     * @return The first-order differential equations for the Pandora model.
     */
    FirstOrderDifferentialEquations getPandoraDifferentialEquations(PandoraTimestep pandoraTimestep);
}
