package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces;

import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.PandoraTimestep;

public interface FirstOrderDifferentialEquationsService {
    FirstOrderDifferentialEquations getPandoraDifferentialEquations(PandoraTimestep pandoraTimestep);
}
