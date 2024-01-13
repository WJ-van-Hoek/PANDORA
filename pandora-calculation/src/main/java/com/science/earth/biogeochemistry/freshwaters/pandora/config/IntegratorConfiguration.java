package com.science.earth.biogeochemistry.freshwaters.pandora.config;

import org.apache.commons.math3.ode.FirstOrderIntegrator;
import org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:integrator.properties")
public class IntegratorConfiguration {
    /**
     * The method employed by the numerical integrator. It is specified as a string and read from the configuration
     * properties.
     */
    @Value("${integrator.method}")
    private String integratorMethod;

    /**
     * The minimum step size parameter for the non-stiff numerical integrator. It is read from the configuration
     * properties.
     */
    @Value("${integrator.nonstiff.params.minStep}")
    private double minStep;

    /**
     * The maximum step size parameter for the non-stiff numerical integrator. It is read from the configuration
     * properties.
     */
    @Value("${integrator.nonstiff.params.maxStep}")
    private double maxStep;

    /**
     * The absolute tolerance parameter for the non-stiff numerical integrator. It is read from the configuration
     * properties.
     */
    @Value("${integrator.nonstiff.params.absoluteTolerance}")
    private double absoluteTolerance;

    /**
     * The relative tolerance parameter for the non-stiff numerical integrator. It is read from the configuration
     * properties.
     */
    @Value("${integrator.nonstiff.params.relativeTolerance}")
    private double relativeTolerance;

    /**
     * Generates and returns a Spring Bean of type {@link FirstOrderIntegrator} based on the configured integrator
     * method. If the method is "dormand-prince," it returns an instance of {@link DormandPrince853Integrator} with the
     * specified parameters. Otherwise, it throws an {@link IllegalArgumentException}.
     *
     * @return A configured Spring Bean of type {@link FirstOrderIntegrator}.
     * @throws IllegalArgumentException If an invalid integration method is specified in the configuration.
     */
    @Bean
    public FirstOrderIntegrator integratorBean() {
        if ("dormand-prince".equalsIgnoreCase(integratorMethod)) {
            return new DormandPrince853Integrator(minStep, maxStep, absoluteTolerance, relativeTolerance);
        }
        throw new IllegalArgumentException("Invalid integration method: " + integratorMethod);
    }
}
