package com.pandora.general.services.calculation.implementations;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pandora.config.reactions.abstractions.ReactionConfiguration;
import com.pandora.config.services.ReactionConfigurationBeanService;
import com.pandora.general.services.calculation.interfaces.ReactionCalculationService;

/**
 * The {@code ReactionCalculationServiceImpl} class implements the {@link ReactionCalculationService} interface and
 * provides functionality for calculating reactions in the Pandora model based on the current state variables. It
 * utilizes a configuration service to retrieve details about reactions and calculates the rates of change for each
 * state variable due to these reactions.
 * <p>
 * This class uses the Spring Framework's {@code @Service} annotation to indicate that it is a service component and can
 * be injected into other components.
 * </p>
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 * @see ReactionCalculationService
 * @see ReactionConfigurationBeanService
 * @see ReactionConfiguration
 */
@Service
public class ReactionCalculationServiceImpl implements ReactionCalculationService {

    /**
     * Service providing configuration details for reactions in the Pandora model.
     */
    @Autowired
    private ReactionConfigurationBeanService reactionConfigurationBeanService;

    /**
     * Calculates the reactions based on the current state variables.
     *
     * @param y The array of state variables representing the current state of the Pandora model.
     * @return The array of reaction rates corresponding to the given state variables.
     */
    @Override
    public double[] calculateReactions(final double[] y) {
        // Array to store the rates of change for each state variable due to reactions.
        double[] reactionDY = new double[y.length];

        // Retrieve all reaction configurations from the configuration service.
        Collection<ReactionConfiguration> reactions = reactionConfigurationBeanService.getAllReactions().values();

        // Accumulate the rates of change for each state variable due to reactions.
        reactions.forEach(reaction -> accumulateReactionDy(reaction, y, reactionDY));

        // Return the array of reaction rates.
        return reactionDY;
    }

    /**
     * Accumulates the rates of change for each state variable due to a specific reaction.
     *
     * @param reaction The configuration of the reaction.
     * @param y The array of state variables representing the current state of the Pandora model.
     * @param reactionDY The array to accumulate the rates of change for each state variable.
     */
    private void accumulateReactionDy(final ReactionConfiguration reaction, final double[] y,
            final double[] reactionDY) {
        // Calculate the rates of change for the reaction.
        double[] dy = reaction.calculate(y);

        // Accumulate the rates of change for each state variable.
        for (
                int i = 0;
                    i < dy.length;
                    i++) {
            reactionDY[i] = reactionDY[i] + dy[i];
        }
    }
}
