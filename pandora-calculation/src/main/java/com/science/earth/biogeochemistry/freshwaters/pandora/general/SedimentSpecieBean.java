package com.science.earth.biogeochemistry.freshwaters.pandora.general;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.calculations.ErosionLogic;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.calculations.ShearStressLogic;

@Component
@PropertySource("classpath:physics-constraints.properties")
public abstract class SedimentSpecieBean implements Sediment {
    @Value("${gravity.acceleration}")
    private double g; // acceleration due to gravity

    @Value("${karmann.constant}")
    private double kappa; // von Karmann constant

    @Value("${pi}")
    private double pi;

    @Value("${water.density}")
    private double rhoF; // density of the fluid (water)

    @Value("${water.dynamic.viscosity}")
    private double mu; // dynamic viscosity of the fluid (water)

    @Autowired
    ErosionLogic erosionLogic;

    @Autowired
    ShearStressLogic shearStressLogic;

    // kg/m2/s
    double getErosionRate(double v) {
	// shear stress
	double tau = shearStressLogic.calculateShearStress(mu, kappa);
	// shields parameter
	double theta = shearStressLogic.calculateShieldsParameter(tau, getParticleDensity(), g, getParticleRadius());
	// critical shear stress
	double tauCritical = shearStressLogic.calculateCriticalShearStress(
		getParticleDensity(), g, getParticleRadius(), theta, getThetaCritical());
	// sediment transport coefficient
	double C = erosionLogic.calculateSedimentTransportCoefficient(getAlpha(), getParticleRadius());
	// exponent that accounts for the non-linear relationship between shear stress and erosion rate
	double n = getN();

	return C * (Math.pow(tau - tauCritical, n));
    }
}
