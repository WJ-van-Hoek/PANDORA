package com.pandora.calculation.services;

import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pandora.calculation.PandoraDifferentialEquations;
import com.pandora.calculation.PandoraTimestep;

/**
 * Implementation of the {@link FirstOrderDifferentialEquationsService} interface that provides the first-order ordinary
 * differential equations (ODEs) for a Pandora simulation.
 * <p>
 * This implementation constructs and returns an instance of {@link PandoraDifferentialEquations}, which encapsulates
 * the ODEs for the simulation. It utilizes services for calculating transport phenomena and chemical reactions, which
 * are injected as dependencies.
 * </p>
 * <p>
 * Instances of this class are intended to be managed by the Spring framework as Spring beans, allowing for dependency
 * injection of required services.
 * </p>
 *
 * @author Wim Joost van Hoek
 * @since 0.0.1
 */
@Service
public final class FirstOrderDifferentialEquationsServiceImpl implements FirstOrderDifferentialEquationsService {

    /** Service for calculating transport phenomena. */
    @Autowired
    private TransportCalculationService _dischargeCalculationService;

    /** Service for calculating chemical reactions. */
    @Autowired
    private ReactionCalculationService _reactionCalculationService;

    /**
     * Gets the first-order ordinary differential equations (ODEs) for the Pandora simulation.
     *
     * @param pandoraTimestep The current timestep information for the simulation.
     * @return The first-order differential equations governing the simulation dynamics.
     */
    @Override
    public FirstOrderDifferentialEquations getPandoraDifferentialEquations(final PandoraTimestep pandoraTimestep) {
        // Create and return an instance of PandoraDifferentialEquations with injected dependencies
        return new PandoraDifferentialEquations(pandoraTimestep, _dischargeCalculationService,
                _reactionCalculationService);
    }
}
