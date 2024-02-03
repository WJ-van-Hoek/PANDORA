package com.pandora.calculation.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.pandora.calculation.config.SpecieConfiguration;

/**
 * The {@code SpecieConfigurationMemoryServiceImpl} class implements the {@link SpecieConfigurationMemoryService}
 * interface to provide CRUD (Create, Read, Update, Delete) operations for specie configurations.
 * <p>
 * This service class uses a {@link ConcurrentHashMap} to store specie configurations, ensuring thread safety and
 * efficient concurrent access.
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 * @see SpecieConfigurationMemoryService
 * @see SpecieConfiguration
 */
@Service
public class SpecieConfigurationMemoryServiceImpl implements SpecieConfigurationMemoryService {

    /**
     * The map to store specie configurations, using the name of the specie as the key.
     */
    private final Map<String, SpecieConfiguration> specieConfigurations;

    /**
     * Constructs a {@code SpecieConfigurationMemoryServiceImpl} with an empty map of specie configurations.
     */
    public SpecieConfigurationMemoryServiceImpl() {
        this.specieConfigurations = new ConcurrentHashMap<>();
    }

    /**
     * Saves a specie configuration to the in-memory map of specieConfigurations.
     *
     * @param specieConfiguration the specie configuration to save
     */
    @Override
    public final void saveSpecieConfiguration(final SpecieConfiguration specieConfiguration) {
        specieConfigurations.put(specieConfiguration.getName(), specieConfiguration);
    }

    /**
     * Finds a specie configuration by its name.
     *
     * @param name the name of the specie configuration to find
     * @return the found specie configuration, or {@code null} if not found
     */
    @Override
    public final SpecieConfiguration findSpecieConfiguration(final String name) {
        return specieConfigurations.getOrDefault(name, null);
    }

    /**
     * Finds all specie configurations.
     *
     * @return List<SpecieConfiguration>
     */
    @Override
    public List<SpecieConfiguration> findAllSpecieConfigurations() {
        return new ArrayList<>(specieConfigurations.values());
    }

}
