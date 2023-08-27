package com.science.earth.biogeochemistry.freshwaters.pandora.config.services;

import java.util.Map;

import com.science.earth.biogeochemistry.freshwaters.pandora.config.reactions.ReactionConfiguration;

public interface ReactionConfigurationBeanService {
    public Map<String, ReactionConfiguration> getAllReactions();
    public ReactionConfiguration getReactionConfiguration(String name);
    public ReactionConfiguration getReactionConfiguration(int i);
}
