package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.implementations;

import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.PandoraDifferentialEquations;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.PandoraTimestep;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces.FirstOrderDifferentialEquationsService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces.ReactionCalculationService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces.TransportCalculationService;

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
