package com.pandora.calculation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pandora.calculation.bootstrap.Bootstrap;

/**
 * Implementation of the {@link BootstrapService} interface for initializing service parameters.
 *
 * @author Wim Joost van Hoek
 * @version 0.0.1
 * @since 0.0.1
 */
@Service
public class BootstrapServiceImpl implements BootstrapService {
    /**
     * Service for managing specie configurations in memory.
     */
    @Autowired
    private SpecieConfigurationMemoryService specieConfigurationMemoryService;

    /**
     * Initializes the service parameters based on the provided {@link Bootstrap}.
     *
     * @param params The {@link Bootstrap} containing the parameters to initialize the service.
     */
    @Override
    public final void initializeCalculationParams(final Bootstrap params) {
        saveSpecieConfigurations(params);
    }

    /**
     * Saves the specie configurations provided in the {@link Bootstrap}.
     *
     * @param params The {@link Bootstrap} containing the specie configurations to save.
     */
    private void saveSpecieConfigurations(final Bootstrap params) {
        params.getSpecieConfigurations().stream().forEach(specieConfiguration -> {
            specieConfigurationMemoryService.saveSpecieConfiguration(specieConfiguration);
        });
    }
}
