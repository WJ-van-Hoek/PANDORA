package com.pandora.calculation;

import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;
import org.springframework.beans.factory.annotation.Autowired;

import com.pandora.calculation.services.ReactionCalculationService;
import com.pandora.calculation.services.TransportCalculationService;

import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * A class representing a set of first-order ordinary differential equations (ODEs) for simulating chemical processes
 * with PANDORA.
 * <p>
 * This class implements the {@link FirstOrderDifferentialEquations} interface, providing methods to compute the
 * derivatives of the variables with respect to time. It utilizes services for calculating reactions and transport,
 * which are autowired for dependency injection.
 * </p>
 * <p>
 * This class is intended to be used within the PANDORA simulation framework.
 * </p>
 *
 * @author Wim Joost van Hoek
 * @since 0.0.1
 */
@AllArgsConstructor
@Builder
public final class PandoraDifferentialEquations implements FirstOrderDifferentialEquations {

    /** The Pandora timestep representing the current state of the simulation. */
    private PandoraTimestep _pandoraTimestep;

    /** Service for calculating transport phenomena. */
    @Autowired
    private TransportCalculationService _transportCalculationService;

    /** Service for calculating chemical reactions. */
    @Autowired
    private ReactionCalculationService _reactionCalculationService;

    /**
     * Gets the dimension of the ODE system.
     *
     * @return The number of variables in the ODE system.
     */
    public int getDimension() {
        return _pandoraTimestep.getDimension();
    }

    /**
     * Computes the derivatives of the variables with respect to time.
     *
     * @param t The current time.
     * @param y The current values of the variables.
     * @param dy The array to store the computed derivatives.
     */
    public void computeDerivatives(final double t, final double[] y, final double[] dy) {
        // Calculate reaction derivatives
        double[] reactionDY = _reactionCalculationService.calculateReactions(y);
        // Calculate transport derivatives
        double[] transportDY = _transportCalculationService.calculateTransport(y, _pandoraTimestep);
        // Combine reaction and transport derivatives to compute total derivatives
        calculateDY(dy, reactionDY, transportDY);
    }

    /**
     * Calculates the total derivatives of the variables.
     *
     * @param dy The array to store the computed derivatives.
     * @param reactionDY The derivatives due to chemical reactions.
     * @param transportDY The derivatives due to transport phenomena.
     */
    private void calculateDY(final double[] dy, final double[] reactionDY, final double[] transportDY) {
        for (
                int i = 0;
                    i < _pandoraTimestep.getDimension();
                    i++) {
            // Calculate total derivative for each variable
            dy[i] = _pandoraTimestep.getTerrestrialSources(i) + _pandoraTimestep.getUpstreamSources(i) + reactionDY[i]
                    - transportDY[i];
        }
    }
}
