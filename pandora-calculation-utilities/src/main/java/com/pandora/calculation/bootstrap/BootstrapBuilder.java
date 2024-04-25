package com.pandora.calculation.bootstrap;

import java.util.List;

import com.pandora.calculation.config.SpecieConfiguration;
import com.pandora.calculation.data.BootstrapDataContainer;

import lombok.extern.slf4j.Slf4j;

/**
 * Builder class for constructing {@link Bootstrap} instances.
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 */
@Slf4j
public class BootstrapBuilder {

    /**
     * The list of specie configurations to be included in the {@link BootstrapBuilder}.
     */
    private List<SpecieConfiguration> specieConfigurations;

    /**
     * The bootstrap data to be included in the {@link BootstrapBuilder}.
     */
    private BootstrapDataContainer bootstrapData;

    /**
     * Sets the list of specie configurations for the builder.
     *
     * @param specieConfigurationsParam The list of specie configurations to be included in the {@link Bootstrap}.
     * @return The {@code BootstrapParamsBuilder} instance with the specified specie configurations.
     */
    public final BootstrapBuilder specieConfigurations(final List<SpecieConfiguration> specieConfigurationsParam) {
        this.specieConfigurations = specieConfigurationsParam;
        log.debug("Specie configurations set for the builder: {}", specieConfigurationsParam);
        return this;
    }

    /**
     * Sets the bootstrap data for the builder.
     *
     * @param bootstrapDataParam The bootstrap that should be included in the {@link Bootstrap}.
     * @return The {@code BootstrapParamsBuilder} instance with the specified bootstrap data.
     */
    public final BootstrapBuilder bootstrapData(final BootstrapDataContainer bootstrapDataParam) {
        this.bootstrapData = bootstrapDataParam;
        log.debug("BootstrapData set for the builder: {}", bootstrapDataParam);
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
     * Retrieves the bootstrap data.
     *
     * @return The bootstrap data included in the builder.
     */
    public BootstrapDataContainer getBootstrapData() {
        return bootstrapData;
    }

    /**
     * Constructs a new {@link Bootstrap} instance using the configured parameters.
     *
     * @return A new {@link Bootstrap} instance constructed with the builder's parameters.
     */
    public Bootstrap build() {
        return new Bootstrap(this);
    }
}
