package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.PandoraTimestep;

public interface PandoraIntegratorService {
    double[] integrate(PandoraTimestep pandoraTimestep);
}
