package com.pandora.calculation.services;

import org.springframework.stereotype.Service;

import com.pandora.calculation.bootstrap.BootstrapParams;

/**
 * Implementation of the {@link BootstrapService} interface for initializing service parameters.
 */
@Service
public class BootstrapServiceImpl implements BootstrapService {
    /**
     * Service for managing specie configurations in memory.
     */
    private SpecieConfigurationMemoryService specieConfigurationMemoryService;

    /**
     * Initializes the service parameters based on the provided {@link BootstrapParams}.
     *
     * @param params The {@link BootstrapParams} containing the parameters to initialize the service.
     */
    @Override
    public final void initializeServiceParams(final BootstrapParams params) {
        saveSpecieConfigurations(params);
    }

    /**
     * Saves the specie configurations provided in the {@link BootstrapParams}.
     *
     * @param params The {@link BootstrapParams} containing the specie configurations to save.
     */
    private void saveSpecieConfigurations(final BootstrapParams params) {
        params.getSpecieConfigurations().stream().forEach(specieConfiguration -> {
            specieConfigurationMemoryService.saveSpecieConfiguration(specieConfiguration);
        });
    }
}

