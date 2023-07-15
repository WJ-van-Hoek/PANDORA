package com.science.earth.biogeochemistry.freshwaters.pandora.general.calculations;

public interface ShearStressLogic {
    double calculateShearStress(double mu, double kappa);
    double calculateCriticalShearStress(double rhoP, double g, double r, double theta, double thetaC);
    double calculateShieldsParameter(double tau, double rhoP, double g, double r);
}
