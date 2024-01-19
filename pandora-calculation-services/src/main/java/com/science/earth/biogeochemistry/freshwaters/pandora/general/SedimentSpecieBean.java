package com.science.earth.biogeochemistry.freshwaters.pandora.general;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.logic.ErosionLogic;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.logic.ShearStressLogic;

@Component
@PropertySource("classpath:physics-constraints.properties")
public abstract class SedimentSpecieBean implements Sediment {
    /**
     * Acceleration due to gravity.
     */
    @Value("${gravity.acceleration}")
    private double g;

    /**
     * von Karmann constant.
     */
    @Value("${karmann.constant}")
    private double kappa;

    /**
     * Mathematical constant Pi.
     */
    @Value("${pi}")
    private double pi;

    /**
     * Density of the fluid (water).
     */
    @Value("${water.density}")
    private double rhoF;

    /**
     * Dynamic viscosity of the fluid (water).
     */
    @Value("${water.dynamic.viscosity}")
    private double mu;

    /**
     * Erosion logic component for sediment.
     */
    @Autowired
    private ErosionLogic erosionLogic;

    /**
     * Shear stress logic component for sediment.
     */
    @Autowired
    private ShearStressLogic shearStressLogic;

    /**
     * Calculates the erosion rate of the sediment based on shear stress and sediment properties.
     *
     * @param v The velocity of the fluid as a {@code double} (kg/m^2/s).
     * @return The erosion rate of the sediment as a {@code double}.
     */
    double getErosionRate(final double v) {
        // shear stress
        double tau = shearStressLogic.calculateShearStress(mu, kappa);
        // shields parameter
        double theta = shearStressLogic.calculateShieldsParameter(tau, getParticleDensity(), g, getParticleRadius());
        // critical shear stress
        double tauCritical = shearStressLogic.calculateCriticalShearStress(getParticleDensity(), g, getParticleRadius(),
                theta, getThetaCritical());
        // sediment transport coefficient
        double coef = erosionLogic.calculateSedimentTransportCoefficient(getAlpha(), getParticleRadius());
        // exponent that accounts for the non-linear relationship between shear stress and erosion rate
        double n = getN();

        return coef * (Math.pow(tau - tauCritical, n));
    }
}
