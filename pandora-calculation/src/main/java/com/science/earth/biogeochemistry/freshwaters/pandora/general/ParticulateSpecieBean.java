package com.science.earth.biogeochemistry.freshwaters.pandora.general;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:physics-constraints.properties")
public abstract class ParticulateSpecieBean implements Particle {
    @Value("${gravity.acceleration}")
    private double g; // acceleration due to gravity
    
    @Value("${water.density}")
    private double rhoF; // density of the fluid (water)
    
    @Value("${water.dynamic.viscosity}")
    private double eta; // dynamic viscosity of the fluid (water)
    
    // Stokes law
    double getDepositionRate() {
	double r = getParticleRadius();
	double rhoP = getParticleDensity();
	return (Math.pow(r,2) * g * (rhoP - rhoF)) * (2/9) / eta;
    }
}
