package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.implementations;

import org.apache.commons.math3.ode.FirstOrderIntegrator;
import org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.interfaces.FirstOrderIntegratorService;

@Service
public class FirstOrderIntegratorServiceImpl implements FirstOrderIntegratorService {
    @Value("${integrator.method}")
    private String integratorMethod;
    
    @Value("${integrator.nonstiff.params.minStep}")
    private double minStep;
    
    @Value("${integrator.nonstiff.params.maxStep}")
    private double maxStep;
    
    @Value("${integrator.nonstiff.params.absoluteTolerance}")
    private double absoluteTolerance;
    
    @Value("${integrator.nonstiff.params.relativeTolerance}")
    private double relativeTolerance;

    @Override
    public FirstOrderIntegrator getFirstOrderIntegrator() {
	if ("dormand-prince".equalsIgnoreCase(integratorMethod)) {
	    return new DormandPrince853Integrator(minStep, maxStep, absoluteTolerance, relativeTolerance);
	}
	throw new IllegalArgumentException("Invalid integration method: " + integratorMethod);
    }

}
