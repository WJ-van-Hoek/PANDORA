package com.science.earth.biogeochemistry.freshwaters.pandora.config.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.config.reactions.ReactionConfiguration;

import jakarta.annotation.PostConstruct;

@Service
public class ReactionConfigurationBeanServiceImpl implements ReactionConfigurationBeanService {
    
    @Autowired
    private ApplicationContext applicationContext;
    
    private List<ReactionConfiguration> indexedReactionConfigurations = new ArrayList<>();
    
    @Override
    public Map<String, ReactionConfiguration> getAllReactions() {
	return applicationContext.getBeansOfType(ReactionConfiguration.class);
    }
    
    @Override
    public ReactionConfiguration getReactionConfiguration(String name) {
	return getAllReactions().get(name);
    }

    @Override
    public ReactionConfiguration getReactionConfiguration(int i) {
	return indexedReactionConfigurations.get(i);
    }
    
    @PostConstruct
    void initialize() {
	indexedReactionConfigurations.addAll(getAllReactions().values());
    }
}