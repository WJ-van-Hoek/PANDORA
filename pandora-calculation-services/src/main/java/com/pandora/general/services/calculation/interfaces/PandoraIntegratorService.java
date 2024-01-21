package com.pandora.general.services.calculation.interfaces;

import com.pandora.general.objects.PandoraTimestep;

/**
 * The {@code PandoraIntegratorService} interface defines a method for integrating the Pandora model simulation for a
 * given {@code PandoraTimestep}. Implementing classes are responsible for providing the integrated solution of the
 * Pandora model at the end of the specified timestep.
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 * @see PandoraTimestep
 */
public interface PandoraIntegratorService {

    /**
     * Integrates the Pandora model simulation for the given {@code PandoraTimestep}.
     *
     * @param pandoraTimestep The Pandora timestep containing simulation parameters.
     * @return The integrated solution of the Pandora model at the end of the timestep.
     */
    double[] integrate(PandoraTimestep pandoraTimestep);
}
