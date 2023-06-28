package com.science.earth.biogeochemistry.freshwaters.pandora.general.calculations;

import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.interfaces.PandoraScheme;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class PandoraDifferentialEquations implements FirstOrderDifferentialEquations {
    
    private PandoraScheme pandoraScheme;
    
    public int getDimension() {
        // Return the number of variables in your ODE system
        return pandoraScheme.getDimension();
    }

    public void computeDerivatives(double t, double[] y, double[] dy) {
	for (int i = 0; i < pandoraScheme.getDimension(); i++) {
	    dy[i] = pandoraScheme.getTerrestrialSources(i) + pandoraScheme.getTransformations(i) + pandoraScheme.getTransport(i);
	}    
    }
}
