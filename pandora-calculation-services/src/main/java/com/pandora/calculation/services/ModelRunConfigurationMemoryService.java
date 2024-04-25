package com.pandora.calculation.services;

import java.time.LocalDateTime;

import com.pandora.calculation.config.ModelRunConfiguration;

/**
 * An interface representing a service for managing model run configurations in memory.
 */
public interface ModelRunConfigurationMemoryService {

    /**
     * Saves the provided model run configuration in memory.
     *
     * @param modelRunConfiguration The model run configuration to save.
     */
    void saveModelRunConfiguration(ModelRunConfiguration modelRunConfiguration);

    /**
     * Obtain the start date time of the model run.
     *
     * @return LocalDateTime the start date time of the model run
     */
    LocalDateTime getStartDateTime();

    /**
     * Obtain the end date time of the model run.
     *
     * @return LocalDateTime the end date time of the model run
     */
    LocalDateTime getEndDateTime();

    /**
     * Obtain the timestep length in years of the model run.
     *
     * @return int the timestep length in years of the model run
     */
    int getTimestep();
}
