package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.implementations;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.config.reactions.abstractions.ReactionConfiguration;
import com.science.earth.biogeochemistry.freshwaters.pandora.config.services.ReactionConfigurationBeanService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces.ReactionCalculationService;

@Service
public class ReactionCalculationServiceImpl implements ReactionCalculationService {
    
    @Autowired
    ReactionConfigurationBeanService reactionConfigurationBeanService;
    
    @Override
    public double[] calculateReactions(double[] y) {
	double[] reactionDY = new double[y.length];
	Collection<ReactionConfiguration> reactions = reactionConfigurationBeanService.getAllReactions().values();
	reactions.forEach(reaction -> accumulateReactionDy(reaction, y, reactionDY));
	return reactionDY;
    }

    private void accumulateReactionDy(ReactionConfiguration reaction, double[] y, double[] reactionDY) {
	double[] dy = reaction.calculate(y);
	for (int i = 0; i < dy.length; i++) {
	    reactionDY[i] = reactionDY[i]+dy[i];
	}
    }
}
