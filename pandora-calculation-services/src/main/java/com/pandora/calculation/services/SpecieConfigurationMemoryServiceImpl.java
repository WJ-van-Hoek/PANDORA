package com.pandora.calculation.services;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pandora.calculation.config.SpecieConfiguration;
import com.pandora.calculation.repositories.SpecieConfigurationRepository;

/**
 * A service implementation for managing specie configurations in memory.
 * This service interacts with a {@link SpecieConfigurationRepository} to save and retrieve specie configurations.
 */
@Service
public final class SpecieConfigurationMemoryServiceImpl implements SpecieConfigurationMemoryService {

    /**
     * A repository for storing and retrieving specie configurations.
     */
    @Autowired
    private SpecieConfigurationRepository _specieConfigurationRepository;

    /**
     * Saves a specie configuration to the in-memory map of specie configurations.
     *
     * @param specieConfiguration The specie configuration to save.
     */
    @Override
    public void saveSpecieConfiguration(final SpecieConfiguration specieConfiguration) {
        _specieConfigurationRepository.saveSpecieConfiguration(specieConfiguration);
    }

    /**
     * Saves a collection of specie configurations.
     *
     * @param specieConfigurations The collection of specie configurations to save.
     */
    @Override
    public void saveSpecieConfigurations(final Collection<SpecieConfiguration> specieConfigurations) {
        _specieConfigurationRepository.saveSpecieConfigurations(specieConfigurations);
    }

    /**
     * Finds a specie configuration by its name.
     *
     * @param name The name of the specie configuration to find.
     * @return The found specie configuration, or {@code null} if not found.
     */
    @Override
    public SpecieConfiguration findSpecieConfiguration(final String name) {
        return _specieConfigurationRepository.findSpecieConfiguration(name);
    }

    /**
     * Finds a specie configuration by its index.
     *
     * @param index The index of the specie configuration to find.
     * @return The found specie configuration.
     */
    @Override
    public SpecieConfiguration findSpecieConfiguration(final int index) {
        return _specieConfigurationRepository.findSpecieConfiguration(index);
    }

    /**
     * Retrieves all specie configurations.
     *
     * @return A list of all specie configurations.
     */
    @Override
    public List<SpecieConfiguration> findAllSpecieConfigurations() {
        return _specieConfigurationRepository.findAllSpecieConfigurations();
    }

    /**
     * Retrieves the number of specie configurations.
     *
     * @return The number of specie configurations.
     */
    @Override
    public int getNumberOfSpecies() {
        return findAllSpecieConfigurations().size();
    }
}
