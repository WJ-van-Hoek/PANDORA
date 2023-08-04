package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.interfaces;

import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.PandoraTimestep;

public interface FirstOrderDifferentialEquationsService {
    FirstOrderDifferentialEquations getPandoraDifferentialEquations(PandoraTimestep pandoraTimestep);
}
