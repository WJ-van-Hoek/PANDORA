package com.pandora.calculation.services;

import java.util.Collection;
import java.util.List;

import com.pandora.calculation.config.SpecieConfiguration;

/**
 * The {@code SpecieConfigurationMemoryService} interface provides methods for storage operations on specie
 * configurations. SpecieConfigurations are considered final, updates are not allowed.
 * <p>
 * Implementing classes are expected to provide concrete implementations for these methods to interact with a repository
 * to manage specie configurations.
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 */
public interface SpecieConfigurationMemoryService {

    /**
     * Saves a new specie configuration.
     *
     * @param specieConfiguration the specie configuration to add
     */
    void saveSpecieConfiguration(SpecieConfiguration specieConfiguration);

    /**
     * Saves a collection of specie configuration.
     *
     * @param specieConfigurations the specie configuration collection to add
     */
    void saveSpecieConfigurations(Collection<SpecieConfiguration> specieConfigurations);

    /**
     * Finds a specie configuration by its name.
     *
     * @param name the identifier of the specie configuration to find
     *
     * @return SpecieConfiguration
     */
    SpecieConfiguration findSpecieConfiguration(String name);

    /**
     * Finds a specie configuration by its index.
     *
     * @param index the identifier of the specie configuration to find
     *
     * @return SpecieConfiguration
     */
    SpecieConfiguration findSpecieConfiguration(int index);

    /**
     * Finds all specie configurations.
     *
     * @return List<SpecieConfiguration>
     */
    List<SpecieConfiguration> findAllSpecieConfigurations();

    /**
     * Find number of species.
     *
     * @return int
     */
    int getNumberOfSpecies();
}
