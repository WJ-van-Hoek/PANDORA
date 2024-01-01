package com.science.earth.biogeochemistry.freshwaters.pandora.general.objects;

import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;
import org.springframework.beans.factory.annotation.Autowired;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces.ReactionCalculationService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces.TransportCalculationService;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class PandoraDifferentialEquations implements FirstOrderDifferentialEquations {

    /**
     * The {@code PandoraTimestep} object representing a specific time step in the Pandora model.
     */
    private PandoraTimestep pandoraTimestep;

    /**
     * Autowired service for calculating transport-related values.
     */
    @Autowired
    private TransportCalculationService transportCalculationService;

    /**
     * Autowired service for calculating reaction-related values.
     */
    @Autowired
    private ReactionCalculationService reactionCalculationService;

    /**
     * Gets the dimension of the ODE system, i.e., the number of variables.
     *
     * @return The number of variables in the ODE system.
     */
    public int getDimension() {
        return pandoraTimestep.getDimension();
    }

    /**
     * Computes the derivatives of the ODE system at a specific time and state.
     *
     * @param tParam The current time.
     * @param y The current state of the ODE system.
     * @param dy The array to store the computed derivatives.
     */
    public void computeDerivatives(final double tParam, final double[] y, final double[] dy) {
        // Calculate reaction-related derivatives
        double[] reactionDY = reactionCalculationService.calculateReactions(y);

        // Calculate transport-related derivatives
        double[] transportDY = transportCalculationService.calculateTransport(y, pandoraTimestep);

        // Combine reaction and transport derivatives to get overall derivatives
        calculateDY(dy, reactionDY, transportDY);
    }

    /**
     * Calculates the overall derivatives based on reaction and transport-related derivatives, as well as contributions
     * from terrestrial sources and upstream sources.
     *
     * @param dy The array to store the overall derivatives.
     * @param reactionDY The reaction-related derivatives.
     * @param transportDY The transport-related derivatives.
     */
    private void calculateDY(final double[] dy, final double[] reactionDY, final double[] transportDY) {
        for (
                int i = 0;
                    i < pandoraTimestep.getDimension();
                    i++) {
            dy[i] = pandoraTimestep.getTerrestrialSources(i) + pandoraTimestep.getUpstreamSources(i) + reactionDY[i]
                    - transportDY[i];
        }
    }
}
