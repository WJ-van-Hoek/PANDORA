package com.pandora.general.services.calculation.implementations;

import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pandora.general.objects.PandoraDifferentialEquations;
import com.pandora.general.objects.PandoraTimestep;
import com.pandora.general.services.calculation.interfaces.FirstOrderDifferentialEquationsService;
import com.pandora.general.services.calculation.interfaces.ReactionCalculationService;
import com.pandora.general.services.calculation.interfaces.TransportCalculationService;

/**
 * The {@code FirstOrderDifferentialEquationsServiceImpl} class implements the
 * {@link FirstOrderDifferentialEquationsService} interface and provides functionality for creating a set of first-order
 * differential equations for the Pandora model. It utilizes services for transport calculation (typically related to
 * discharge) and reaction calculation.
 * <p>
 * This class uses the Spring Framework's {@code @Service} annotation to indicate that it is a service component and can
 * be injected into other components.
 * </p>
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 * @see FirstOrderDifferentialEquationsService
 * @see TransportCalculationService
 * @see ReactionCalculationService
 * @see PandoraDifferentialEquations
 */
@Service
public class FirstOrderDifferentialEquationsServiceImpl implements FirstOrderDifferentialEquationsService {
    /**
     * Service responsible for transport calculation, typically related to discharge.
     */
    @Autowired
    private TransportCalculationService dischargeCalculationService;

    /**
     * Service responsible for reaction calculation.
     */
    @Autowired
    private ReactionCalculationService reactionCalculationService;

    /**
     * Creates and returns a set of first-order differential equations for the Pandora model based on the provided
     * {@code PandoraTimestep}.
     *
     * @param pandoraTimestep The Pandora timestep containing simulation parameters.
     * @return The first-order differential equations for the Pandora model.
     */
    @Override
    public FirstOrderDifferentialEquations getPandoraDifferentialEquations(final PandoraTimestep pandoraTimestep) {
        // Create and return Pandora differential equations using the provided timestep and services.
        return new PandoraDifferentialEquations(pandoraTimestep, dischargeCalculationService,
                reactionCalculationService);
    }
}
