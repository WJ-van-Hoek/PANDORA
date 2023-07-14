package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.interfaces;

import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;

public interface FirstOrderDifferentialEquationsService {
    FirstOrderDifferentialEquations getPandoraDifferentialEquations();
}
