package com.pandora.calculation.services;

import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;
import org.apache.commons.math3.ode.FirstOrderIntegrator;
import org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pandora.calculation.PandoraTimestep;

/**
 * Implementation of the {@link PandoraIntegratorService} interface. The class allows to perform the numerical
 * integration needed for the calculation.
 * <p>
 * This implementation utilizes a first-order differential equations service to obtain the ODEs governing the simulation
 * dynamics and a first-order integrator to perform the numerical integration over the specified timestep.
 * </p>
 *
 * @author Wim Joost van Hoek
 * @version 0.0.1
 * @since 0.0.1
 */
@Service
public final class PandoraIntegratorServiceImpl implements PandoraIntegratorService {

    /** Absolute tolerance for the numerical integration. */
    private static final double ABSOLUTE_TOLERANCE = 1.0e-8;

    /** Relative tolerance for the numerical integration. */
    private static final double RELATIVE_TOLERANCE = 1.0;

    /** Minimum step size for the numerical integration. */
    private static final double MIN_STEP_SIZE = 1.0e-5;

    /** Maximum step size for the numerical integration. */
    private static final double MAX_STEP_SIZE = 1.0e-2;

    /** Service for obtaining first-order differential equations. */
    @Autowired
    private FirstOrderDifferentialEquationsService _firstOrderDifferentialEquationsService;

    /** First-order integrator for performing numerical integration. */
    private FirstOrderIntegrator _firstOrderIntegrator = new DormandPrince853Integrator(ABSOLUTE_TOLERANCE,
            RELATIVE_TOLERANCE, MIN_STEP_SIZE, MAX_STEP_SIZE);

    /**
     * Integrates the PANDORA simulation over the specified timestep.
     *
     * @param pandoraTimestep The current timestep information for the simulation.
     * @return The computed state of the system at the next time instant.
     */
    public double[] integrate(final PandoraTimestep pandoraTimestep) {
        // Obtain the first-order differential equations for the current timestep
        FirstOrderDifferentialEquations ode = _firstOrderDifferentialEquationsService
                .getPandoraDifferentialEquations(pandoraTimestep);

        // Set initial conditions and integration boundaries
        double t0 = pandoraTimestep.getT0();
        double[] y0 = pandoraTimestep.getY0();
        double tEnd = pandoraTimestep.getTEnd();

        // Array to store computed state at the next time instant
        double[] y = new double[pandoraTimestep.getY0().length];

        // Perform numerical integration
        _firstOrderIntegrator.integrate(ode, t0, y0, tEnd, y);
        return y;
    }
}
