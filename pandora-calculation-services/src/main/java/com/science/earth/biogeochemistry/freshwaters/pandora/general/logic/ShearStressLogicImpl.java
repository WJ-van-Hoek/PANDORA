package com.science.earth.biogeochemistry.freshwaters.pandora.general.logic;

import org.springframework.stereotype.Component;

@Component
public class ShearStressLogicImpl implements ShearStressLogic {
    /**
     * The shear stress constant used in shear stress calculations. This constant is a numerical factor applied to a
     * calculated value to determine shear stress.
     */
    private static final int SHEAR_STRESS_CONSTANT = 10;

    /**
     * Calculates the shear stress based on the given dynamic viscosity and von Kármán constant.
     *
     * @param mu the dynamic viscosity of the fluid.
     * @param kappa the von Kármán constant.
     * @return the calculated shear stress.
     * @implNote The shear stress is computed using the formula: mu * (1 / kappa) * 10.
     */
    @Override
    public double calculateShearStress(final double mu, final double kappa) {
        double dudy = (1.0 / kappa) * SHEAR_STRESS_CONSTANT;
        return mu * dudy;
    }

    /**
     * Calculates the critical shear stress for sediment transport based on the given parameters.
     *
     * @param rhoP the density of the sediment particles.
     * @param g the acceleration due to gravity.
     * @param r the particle radius.
     * @param theta the angle of repose of the sediment.
     * @param thetaC the critical angle of repose.
     * @return the calculated critical shear stress.
     * @implNote The critical shear stress is computed using the formula: rhoP * g * 2 * r * (theta - thetaC).
     */
    @Override
    public double calculateCriticalShearStress(final double rhoP, final double g, final double r, final double theta,
            final double thetaC) {
        return rhoP * g * 2 * r * (theta - thetaC);
    }

    /**
     * Calculates the Shields parameter, a dimensionless parameter used in sediment transport analysis.
     *
     * @param tau the shear stress.
     * @param rhoP the density of the sediment particles.
     * @param g the acceleration due to gravity.
     * @param r the particle radius.
     * @return the calculated Shields parameter.
     * @implNote The Shields parameter is computed using the formula: tau / (rhoP * g * 2 * r).
     */
    @Override
    public double calculateShieldsParameter(final double tau, final double rhoP, final double g, final double r) {
        return tau / (rhoP * g * 2 * r);
    }
}
