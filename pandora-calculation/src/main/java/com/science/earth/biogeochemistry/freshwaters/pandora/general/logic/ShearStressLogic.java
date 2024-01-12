package com.science.earth.biogeochemistry.freshwaters.pandora.general.logic;

public interface ShearStressLogic {
    /**
     * Calculates the shear stress based on the given parameters.
     *
     * @param mu the dynamic viscosity of the fluid.
     * @param kappa the von Kármán constant.
     * @return the calculated shear stress.
     */
    double calculateShearStress(double mu, double kappa);

    /**
     * Calculates the critical shear stress for sediment transport.
     *
     * @param rhoP the density of the sediment particles.
     * @param g the acceleration due to gravity.
     * @param r the particle radius.
     * @param theta the angle of repose of the sediment.
     * @param thetaC the critical angle of repose.
     * @return the calculated critical shear stress.
     */
    double calculateCriticalShearStress(double rhoP, double g, double r, double theta, double thetaC);

    /**
     * Calculates the Shields parameter, a dimensionless parameter used in sediment transport analysis.
     *
     * @param tau the shear stress.
     * @param rhoP the density of the sediment particles.
     * @param g the acceleration due to gravity.
     * @param r the particle radius.
     * @return the calculated Shields parameter.
     */
    double calculateShieldsParameter(double tau, double rhoP, double g, double r);
}
