package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.PandoraTimestep;

public interface PandoraIntegratorService {

    /**
     * Integrates the Pandora model simulation for the given {@code PandoraTimestep}.
     *
     * @param pandoraTimestep The Pandora timestep containing simulation parameters.
     * @return The integrated solution of the Pandora model at the end of the timestep.
     */
    double[] integrate(PandoraTimestep pandoraTimestep);
}
