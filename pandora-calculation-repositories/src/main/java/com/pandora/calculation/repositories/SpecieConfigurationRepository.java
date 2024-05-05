package com.pandora.calculation.repositories;

import java.util.Collection;
import java.util.List;

import com.pandora.calculation.config.SpecieConfiguration;

/**
 * An interface representing a repository for saving species configuration. Implementations of this interface are
 * responsible for saving SpecieConfiguration objects, which represent configuration information for a species.
 */
public interface SpecieConfigurationRepository {

    /**
     * Saves the provided SpecieConfiguration object.
     *
     * @param specieConfiguration The SpecieConfiguration object to be saved.
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
     * @param name the name of the specie configuration to find
     * @return the found specie configuration, or {@code null} if not found
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
}
