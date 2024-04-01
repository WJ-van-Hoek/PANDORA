package com.pandora.calculation.bootstrap;

import java.util.List;

import com.pandora.calculation.config.SpecieConfiguration;

import lombok.extern.slf4j.Slf4j;

/**
 * Builder class for constructing {@link Bootstrap} instances.
 *
 * @author Wim Joost van Hoek
 * @version 0.0.1
 * @since 0.0.1
 */
@Slf4j
public class BootstrapParamsBuilder {

    /**
     * The list of specie configurations to be included in the {@link Bootstrap}.
     */
    private List<SpecieConfiguration> specieConfigurations;

    /**
     * Sets the list of specie configurations for the builder.
     *
     * @param specieConfigurationsParam The list of specie configurations to be included in the {@link Bootstrap}.
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
     * Constructs a new {@link Bootstrap} instance using the configured parameters.
     *
     * @return A new {@link Bootstrap} instance constructed with the builder's parameters.
     */
    public Bootstrap build() {
        log.debug("Building BootstrapParams instance with specie configurations: {}", specieConfigurations);
        return new Bootstrap(this);
    }
}
