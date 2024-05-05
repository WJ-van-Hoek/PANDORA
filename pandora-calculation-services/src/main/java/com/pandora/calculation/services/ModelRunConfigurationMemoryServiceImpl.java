package com.pandora.calculation.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pandora.calculation.config.ModelRunConfiguration;
import com.pandora.calculation.repositories.ModelRunConfigurationRepository;

/**
 * A service implementation for managing model run configurations in memory.
 * This service interacts with a {@link ModelRunConfigurationRepository} to save model run configurations.
 */
@Service
public final class ModelRunConfigurationMemoryServiceImpl implements ModelRunConfigurationMemoryService {

    /**
     * A repository for storing the model run configuration.
     */
    @Autowired
    private ModelRunConfigurationRepository _modelRunConfigurationRepository;

    /**
     * Saves the provided model run configuration using the injected repository.
     *
     * @param modelRunConfiguration The model run configuration to save.
     */
    @Override
    public void saveModelRunConfiguration(final ModelRunConfiguration modelRunConfiguration) {
        _modelRunConfigurationRepository.saveModelRunConfiguration(modelRunConfiguration);
    }

    /**
     * Retrieves the start date and time from the stored model run configuration.
     *
     * @return The start date and time.
     */
    @Override
    public LocalDateTime getStartDateTime() {
        return _modelRunConfigurationRepository.getModelRunConfiguration().getStartDateTime();
    }

    /**
     * Retrieves the end date and time from the stored model run configuration.
     *
     * @return The end date and time.
     */
    @Override
    public LocalDateTime getEndDateTime() {
        return _modelRunConfigurationRepository.getModelRunConfiguration().getEndDateTime();
    }

    /**
     * Retrieves the timestep from the stored model run configuration.
     *
     * @return The timestep.
     */
    @Override
    public int getTimestep() {
        return _modelRunConfigurationRepository.getModelRunConfiguration().getTimestep();
    }
}
