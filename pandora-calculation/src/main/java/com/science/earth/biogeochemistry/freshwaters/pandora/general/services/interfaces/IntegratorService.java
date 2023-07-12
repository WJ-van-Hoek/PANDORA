package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.interfaces;

import org.apache.commons.math3.ode.FirstOrderIntegrator;

public interface IntegratorService {
    FirstOrderIntegrator getAppliedFirstOrderIntegrator();
}
