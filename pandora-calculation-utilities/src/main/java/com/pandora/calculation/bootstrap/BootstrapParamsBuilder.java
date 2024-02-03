package com.pandora.calculation.bootstrap;

import java.util.List;

import com.pandora.calculation.config.SpecieConfiguration;

import lombok.extern.slf4j.Slf4j;

/**
 * Builder class for constructing {@link BootstrapParams} instances.
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 */
@Slf4j
public class BootstrapParamsBuilder {

    /**
     * The list of specie configurations to be included in the {@link BootstrapParams}.
     */
    private List<SpecieConfiguration> specieConfigurations;

    /**
     * Sets the list of specie configurations for the builder.
     *
     * @param specieConfigurationsParam The list of specie configurations to be included in the {@link BootstrapParams}.
     * @return The {@code BootstrapParamsBuilder} instance with the specified specie configurations.
     */
    public BootstrapParamsBuilder specieConfigurations(final List<SpecieConfiguration> specieConfigurationsParam) {
        this.specieConfigurations = specieConfigurationsParam;
        log.debug("Specie configurations set for the builder: {}", specieConfigurationsParam);
        return this;
    }

    /**
     * Retrieves the list of specie configurations.
     *
     * @return The list of specie configurations included in the builder.
     */
    public List<SpecieConfiguration> getSpecieConfigurations() {
        return specieConfigurations;
    }

    /**
     * Constructs a new {@link BootstrapParams} instance using the configured parameters.
     *
     * @return A new {@link BootstrapParams} instance constructed with the builder's parameters.
     */
    public BootstrapParams build() {
        log.debug("Building BootstrapParams instance with specie configurations: {}", specieConfigurations);
        return new BootstrapParams(this);
    }
}
