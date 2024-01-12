package com.science.earth.biogeochemistry.freshwaters.pandora.config.services;

import java.util.Map;

import com.science.earth.biogeochemistry.freshwaters.pandora.config.reactions.abstractions.ReactionConfiguration;

public interface ReactionConfigurationBeanService {
    /**
     * Retrieves a map containing all available reaction configurations. The keys are strings representing the names of
     * the reactions, and the values are the corresponding {@link ReactionConfiguration} instances.
     *
     * @return A {@code Map} containing all available reaction configurations.
     */
    Map<String, ReactionConfiguration> getAllReactions();

    /**
     * Retrieves the {@link ReactionConfiguration} associated with the specified reaction name.
     *
     * @param name The name of the reaction for which to retrieve the configuration.
     * @return The {@link ReactionConfiguration} associated with the specified name, or {@code null} if no configuration
     * is found.
     */
    ReactionConfiguration getReactionConfiguration(String name);

    /**
     * Retrieves the {@link ReactionConfiguration} associated with the reaction at the specified index. The index is
     * used to identify the position of the reaction configuration in the underlying data structure.
     *
     * @param i The index of the reaction for which to retrieve the configuration.
     * @return The {@link ReactionConfiguration} associated with the specified index, or {@code null} if no
     * configuration is found.
     */
    ReactionConfiguration getReactionConfiguration(int i);
}
