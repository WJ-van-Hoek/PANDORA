package com.pandora.general;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * The {@code ParticulateSpecieBean} class is an abstract class representing a particulate species with properties
 * related to particle physics. It implements the {@link Particle} interface and provides a method to calculate the
 * deposition rate of the particle based on Stokes' law.
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 */
@Component
@PropertySource("classpath:physics-constraints.properties")
public abstract class ParticulateSpecieBean implements Particle {
    /**
     * The {@code STOKES_LAW_CONSTANT} represents the constant factor used in Stokes' law for calculating the deposition
     * rate of a particle in a viscous fluid under the influence of gravity.
     * <p>
     * In the context of Stokes' law formula, the constant is calculated as \( \frac{2}{9} \).
     * </p>
     * s
     */
    private static final double STOKES_LAW_CONSTANT = 2.0 / 9.0;

    /**
     * Acceleration due to gravity.
     */
    @Value("${gravity.acceleration}")
    private double g;

    /**
     * Density of the fluid (water).
     */
    @Value("${water.density}")
    private double rhoF;

    /**
     * Dynamic viscosity of the fluid (water).
     */
    @Value("${water.dynamic.viscosity}")
    private double eta;

    /**
     * Calculates the deposition rate of the particle based on Stokes' law.
     *
     * @return The deposition rate as a {@code double}.
     */
    double getDepositionRate() {
        double r = getParticleRadius();
        double rhoP = getParticleDensity();
        return (Math.pow(r, 2) * g * (rhoP - rhoF)) * STOKES_LAW_CONSTANT / eta;
    }
}
