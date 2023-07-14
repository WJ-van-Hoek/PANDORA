package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.interfaces;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.PandoraTimestep;

public interface PandoraIntegratorService {
    double[] integrate(PandoraTimestep pandoraTimestep);
}
