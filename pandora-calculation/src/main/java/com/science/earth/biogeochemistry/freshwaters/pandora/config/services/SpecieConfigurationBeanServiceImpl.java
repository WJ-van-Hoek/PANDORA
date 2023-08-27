package com.science.earth.biogeochemistry.freshwaters.pandora.config.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.config.species.SpecieConfiguration;

import jakarta.annotation.PostConstruct;

@Service
public class SpecieConfigurationBeanServiceImpl implements SpecieConfigurationBeanService {
    
    @Autowired
    private ApplicationContext applicationContext;
    
    private List<SpecieConfiguration> indexedSpecieConfigurations = new ArrayList<>();
    
    @Override
    public Map<String, SpecieConfiguration> getAllSpecies() {
	Map<String, SpecieConfiguration> original = applicationContext.getBeansOfType(SpecieConfiguration.class);
	Map<String, SpecieConfiguration> lowercasedKeys = new HashMap<>();
	original.forEach((key, value) -> {
            String lowercaseKey = key.toLowerCase();
            lowercasedKeys.put(lowercaseKey, value);
        });
	return lowercasedKeys;
    }
    
    @Override
    public SpecieConfiguration getSpecieConfiguration(String name) {
	return getAllSpecies().get(name.toLowerCase());
    }

    @Override
    public SpecieConfiguration getSpecieConfiguration(int i) {
	return indexedSpecieConfigurations.get(i);
    }
    
    @Override
    public int getSpecieConfigurationIndex(SpecieConfiguration specieConfiguration) {
	return indexedSpecieConfigurations.indexOf(specieConfiguration);
    }
    
    @PostConstruct
    void postConstruct() {
	indexedSpecieConfigurations.addAll(getAllSpecies().values());
    }
}