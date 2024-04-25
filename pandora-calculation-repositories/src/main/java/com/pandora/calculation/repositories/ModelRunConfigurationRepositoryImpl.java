package com.pandora.calculation.repositories;

import org.springframework.stereotype.Repository;

import com.pandora.calculation.config.ModelRunConfiguration;

/**
 * An implementation of {@link ModelRunConfigurationRepository} that stores a single model run configuration instance.
 * This repository ensures that only one model run configuration can be stored at a time.
 */
@Repository
public final class ModelRunConfigurationRepositoryImpl implements ModelRunConfigurationRepository {

    /**
     * The stored model run configuration instance.
     */
    private ModelRunConfiguration _modelRunConfiguration;

    /**
     * Saves the provided model run configuration in the repository.
     *
     * @param modelRunConfigurationParam The model run configuration to save.
     * @throws IllegalStateException if a model run configuration is already stored in the repository.
     */
    @Override
    public void saveModelRunConfiguration(final ModelRunConfiguration modelRunConfigurationParam) {
        if (_modelRunConfiguration == null) {
            this._modelRunConfiguration = modelRunConfigurationParam;
        } else {
            throw new IllegalStateException("There is already a model run configuration stored.");
        }
    }

    @Override
    public ModelRunConfiguration getModelRunConfiguration() {
        return _modelRunConfiguration;
    }

}
