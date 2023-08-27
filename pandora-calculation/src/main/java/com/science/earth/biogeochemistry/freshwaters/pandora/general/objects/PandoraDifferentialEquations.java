package com.science.earth.biogeochemistry.freshwaters.pandora.general.objects;

import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;
import org.springframework.beans.factory.annotation.Autowired;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces.ReactionCalculationService;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class PandoraDifferentialEquations implements FirstOrderDifferentialEquations {

    private PandoraTimestep pandoraTimestep;

    @Autowired
    ReactionCalculationService reactionCalculationService;
    
    public int getDimension() {
	// Return the number of variables in your ODE system
	return pandoraTimestep.getDimension();
    }

    public void computeDerivatives(double t, double[] y, double[] dy) {
	double[] reactionDY = reactionCalculationService.calculateReactions(y);
	for (int i = 0; i < pandoraTimestep.getDimension(); i++) {
	    dy[i] = pandoraTimestep.getTerrestrialSources(i) + pandoraTimestep.getUpstreamSources(i)
		    + reactionDY[i];
	}
    }
}
