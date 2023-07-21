package com.science.earth.biogeochemistry.freshwaters.pandora.general.calculations;

import org.springframework.stereotype.Component;

@Component
public class ShearStressLogicImpl implements ShearStressLogic {
    public double calculateShearStress(double mu, double kappa) {
	double dudy = (1/kappa) * 10;
	return mu * dudy;
    }
    
    public double calculateCriticalShearStress(double rhoP, double g, double r, double theta, double thetaC) {
	return rhoP * g * 2 * r * (theta - thetaC);
    }
    
    public double calculateShieldsParameter(double tau, double rhoP, double g, double r) {
	return tau / (rhoP * g * 2 * r);
    }
}