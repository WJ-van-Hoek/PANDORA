package com.pandora.calculation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pandora.calculation.config.SpecieConfiguration;

/**
 * A service implementation for calculating reactions. This service interacts with a
 * {@link SpecieConfigurationMemoryService} to retrieve specie configurations.
 */
@Service
public final class ReactionCalculationServiceImpl implements ReactionCalculationService {

    /**
     * A service for managing specie configurations in memory.
     */
    @Autowired
    private SpecieConfigurationMemoryService _specieConfigurationMemoryService;

    /**
     * Calculates reactions based on the provided vector.
     *
     * @param vector The input vector.
     * @return An array containing the calculated reactions.
     */
    @Override
    public double[] calculateReactions(final double[] vector) {
        double[] reactions = new double[vector.length];

        int index = 0;
        for (double y : vector) {
            SpecieConfiguration specie = _specieConfigurationMemoryService.findSpecieConfiguration(index);
            double fateReactionDy = specie.getFateReactionConfigurations().stream()
                    .mapToDouble(reaction -> -reaction.getRate() * y).sum();
            double sourceReactionDy = specie.getSourceReactionConfigurations().stream()
                    .mapToDouble(reaction -> _specieConfigurationMemoryService
                            .findSpecieConfiguration(reaction.getFrom()).getFateReactionConfigurations().stream()
                            .filter(c -> c.getTo().equals(specie.getName())).findFirst().get().getRate() * y)
                    .sum();
            reactions[index] = fateReactionDy + sourceReactionDy;
            index++;
        }

        return reactions;
    }

}
