package com.pandora.general.services.calculation.implementations;

import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;
import org.apache.commons.math3.ode.FirstOrderIntegrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pandora.general.objects.PandoraTimestep;
import com.pandora.general.services.calculation.interfaces.FirstOrderDifferentialEquationsService;
import com.pandora.general.services.calculation.interfaces.PandoraIntegratorService;

/**
 * The {@code PandoraIntegratorServiceImpl} class implements the {@link PandoraIntegratorService} interface and provides
 * functionality for integrating the Pandora model simulation for a given {@code PandoraTimestep}. It utilizes a
 * first-order differential equations service to obtain the Pandora model equations and a first-order integrator for
 * solving these equations. The integration result represents the solution of the Pandora model at the end of the
 * specified timestep.
 * <p>
 * This class uses the Spring Framework's {@code @Service} annotation to indicate that it is a service component and can
 * be injected into other components.
 * </p>
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 * @see PandoraIntegratorService
 * @see FirstOrderDifferentialEquationsService
 */
@Service
public class PandoraIntegratorServiceImpl implements PandoraIntegratorService {
    /**
     * Service responsible for providing first-order differential equations for Pandora models.
     */
    @Autowired
    private FirstOrderDifferentialEquationsService firstOrderDifferentialEquationsService;

    /**
     * First-order integrator for solving differential equations.
     */
    @Autowired
    private FirstOrderIntegrator firstOrderIntegrator;

    /**
     * Integrates the Pandora model simulation for the given {@code PandoraTimestep}.
     *
     * @param pandoraTimestep The Pandora timestep containing simulation parameters.
     * @return The integrated solution of the Pandora model at the end of the timestep.
     */
    public double[] integrate(final PandoraTimestep pandoraTimestep) {
        // Get the first-order differential equations for the Pandora model.
        FirstOrderDifferentialEquations ode = firstOrderDifferentialEquationsService
                .getPandoraDifferentialEquations(pandoraTimestep);

        // Extract necessary simulation parameters.
        double t0 = pandoraTimestep.getT0();
        double[] y0 = pandoraTimestep.getY0();
        double tEnd = pandoraTimestep.getTEnd();

        // Array to store the integrated solution.
        double[] y = new double[pandoraTimestep.getY0().length];

        // Integrate the Pandora model simulation.
        firstOrderIntegrator.integrate(ode, t0, y0, tEnd, y);

        // Return the integrated solution.
        return y;
    }
}
