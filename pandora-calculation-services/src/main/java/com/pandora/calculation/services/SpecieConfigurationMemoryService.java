package com.pandora.calculation.services;

import java.util.List;

import com.pandora.calculation.config.SpecieConfiguration;

/**
 * The {@code SpecieConfigurationCrdService} interface provides methods for storage operations on specie configurations.
 * SpecieConfigurations are considered final, updates are not allowed.
 * <p>
 * Implementing classes are expected to provide concrete implementations for these methods to interact with a repository
 * to manage specie configurations.
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 */
public interface SpecieConfigurationMemoryService {
    /**
     * Saves a new specie configuration to repository.
     *
     * @param specieConfiguration the specie configuration to add
     */
    void saveSpecieConfiguration(SpecieConfiguration specieConfiguration);

    /**
     * Finds a specie configuration by its name.
     *
     * @param name the identifier of the specie configuration to find
     *
     * @return SpecieConfiguration
     */
    SpecieConfiguration findSpecieConfiguration(String name);

    /**
     * Finds all specie configurations.
     *
     * @return List<SpecieConfiguration>
     */
    List<SpecieConfiguration> findAllSpecieConfigurations();

}
