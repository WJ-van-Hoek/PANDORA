package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces;

import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.PandoraTimestep;

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
