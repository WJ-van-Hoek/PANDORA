package com.science.earth.biogeochemistry.freshwaters.pandora.config.services;

import java.util.Map;

import com.science.earth.biogeochemistry.freshwaters.pandora.config.species.SpecieConfiguration;

public interface SpecieConfigurationBeanService {
    public Map<String, SpecieConfiguration> getAllSpecies();
    public SpecieConfiguration getSpecieConfiguration(String name);
    public SpecieConfiguration getSpecieConfiguration(int i);
    int getSpecieConfigurationIndex(SpecieConfiguration specieConfiguration);
}
