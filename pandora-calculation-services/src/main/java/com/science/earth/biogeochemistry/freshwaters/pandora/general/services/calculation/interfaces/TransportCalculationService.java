package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.PandoraTimestep;

public interface TransportCalculationService {
    /**
     * Calculates the transport of each species based on the given state variables and discharge rate.
     *
     * @param y The state variables representing species concentrations.
     * @param pandoraTimestep The Pandora timestep containing simulation parameters.
     * @return An array representing the changes in species concentrations due to transport.
     */
    double[] calculateTransport(double[] y, PandoraTimestep pandoraTimestep);
}
