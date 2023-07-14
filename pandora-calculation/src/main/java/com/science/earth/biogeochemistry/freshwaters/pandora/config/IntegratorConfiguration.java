package com.science.earth.biogeochemistry.freshwaters.pandora.config;

import org.apache.commons.math3.ode.FirstOrderIntegrator;
import org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IntegratorConfiguration {
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

    @Bean
    public FirstOrderIntegrator integratorBean() {
	if ("dormand-prince".equalsIgnoreCase(integratorMethod)) {
	    return new DormandPrince853Integrator(minStep, maxStep, absoluteTolerance, relativeTolerance);
	}
	throw new IllegalArgumentException("Invalid integration method: " + integratorMethod);
    }
}
