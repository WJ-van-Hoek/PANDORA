package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.PandoraTimestep;

public interface TransportCalculationService {
    double[] calculateTransport(double[] y, PandoraTimestep pandoraTimestep);
}
