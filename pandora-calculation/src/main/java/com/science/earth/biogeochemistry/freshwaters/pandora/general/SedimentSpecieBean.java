package com.science.earth.biogeochemistry.freshwaters.pandora.general;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:physics-constraints.properties")
public abstract class SedimentSpecieBean implements Sediment {
    @Value("${gravity.acceleration}")
    private double g; // acceleration due to gravity
    
    @Value("${water.density}")
    private double rhoF; // density of the fluid (water)
    
    @Value("${water.dynamic.viscosity}")
    private double eta; // dynamic viscosity of the fluid (water)
    
    @Value("${pi}")
    private double pi;
    
    double getErosionRate(double v) {
	double r = getParticleRadius();
	double rhoP = getParticleDensity();
	double vP =  (4/3) * pi * Math.pow(r, 3);
	double aF = Math.pow(getParticleRadius(),2)*pi; //getProjectedArea();
	double reynolds = (rhoF * v * 2 * r) / eta;
	double cD = reynolds / 24;
	double fD = 0.5 * rhoF * cD * aF * Math.pow(v, 2);

	return (fD - (rhoF - rhoP) * vP * g) / rhoP;
    }
}
