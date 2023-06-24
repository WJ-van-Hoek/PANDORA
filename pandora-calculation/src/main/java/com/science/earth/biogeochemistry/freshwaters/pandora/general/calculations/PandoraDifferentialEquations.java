package com.science.earth.biogeochemistry.freshwaters.pandora.general.calculations;

import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.interfaces.PandoraScheme;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PandoraDifferentialEquations implements FirstOrderDifferentialEquations {
    
    private PandoraScheme pandoraScheme;
    
    public int getDimension() {
        // Return the number of variables in your ODE system
        return pandoraScheme.getDimension();
    }

    public void computeDerivatives(double t, double[] y, double[] yDot) {
        // Compute the derivatives of the variables at time t
        // The 'y' array contains the values of the variables
        // The 'yDot' array should be filled with the computed derivatives
        // based on the values of 'y' at time 't'
        // Implement your equations here
	for (int i = 0; i < pandoraScheme.getDimension(); i++) {
	    yDot[i] = pandoraScheme.getSources(i) + pandoraScheme.calculateReactions(i);
	}    
    }    
}
