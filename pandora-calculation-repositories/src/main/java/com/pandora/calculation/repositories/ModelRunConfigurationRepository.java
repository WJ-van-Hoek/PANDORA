package com.pandora.calculation.repositories;

import com.pandora.calculation.config.ModelRunConfiguration;

/**
 * An interface representing a repository for storing model run configurations. Implementations of this interface are
 * responsible for persisting model run configurations.
 */
public interface ModelRunConfigurationRepository {

    /**
     * Saves the provided model run configuration.
     *
     * @param modelRunConfiguration The model run configuration to save.
     */
    void saveModelRunConfiguration(ModelRunConfiguration modelRunConfiguration);

    /**
     * Retrieves the model run configuration.
     *
     * @return modelRunConfiguration The model run configuration to retrieve
     */
    ModelRunConfiguration getModelRunConfiguration();
}
