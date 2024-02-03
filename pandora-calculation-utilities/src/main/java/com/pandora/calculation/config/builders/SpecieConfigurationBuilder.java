package com.pandora.calculation.config.builders;

import java.util.List;

import com.pandora.calculation.config.FateReactionConfiguration;
import com.pandora.calculation.config.SourceReactionConfiguration;
import com.pandora.calculation.config.SpecieConfiguration;

import lombok.Getter;

/**
 * The SpecieConfigurationBuilder class serves as a builder for creating instances of SpecieConfiguration or its
 * subclasses. It is parameterized by the type of builder itself.
 * <p>
 * This builder allows for the construction of configurations for chemical species, including properties such as name,
 * molar mass, and aqueous state. Additionally, it provides methods for setting taxonomy, phase, and zone configurations
 * for more detailed specifications.
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 */
@Getter
public class SpecieConfigurationBuilder extends ConfigurationBuilder<SpecieConfigurationBuilder> {


    /**
     * The molar mass of the chemical species.
     */
    private double molarMass;

    /**
     * The list of configurations representing the configured reaction sources of the chemical species.
     */
    private List<SourceReactionConfiguration> sourceReactionConfigurations;

    /**
     * The list of configurations representing the configured reaction fates of the chemical species.
     */
    private List<FateReactionConfiguration> fateReactionConfigurations;

    /**
     * Sets the molar mass of the chemical species.
     *
     * @param molarMassParam the molar mass of the chemical species
     * @return the SpecieConfigurationBuilder instance
     */
    public final SpecieConfigurationBuilder molarMass(final double molarMassParam) {
        this.molarMass = molarMassParam;
        return self();
    }

    /**
     * Sets the sourceReactionConfigurations of the chemical species.
     *
     * @param sourceReactionConfigurationsParam the sourceReactionConfigurations of the chemical species
     * @return the SpecieConfigurationBuilder instance
     */
    public final SpecieConfigurationBuilder sourceReactionConfigurations(
            final List<SourceReactionConfiguration> sourceReactionConfigurationsParam) {
        this.sourceReactionConfigurations = sourceReactionConfigurationsParam;
        return self();
    }

    /**
     * Sets the fateReactionConfigurations of the chemical species.
     *
     * @param fateReactionConfigurationsParam the fateReactionConfigurations of the chemical species
     * @return the SpecieConfigurationBuilder instance
     */
    public final SpecieConfigurationBuilder fateReactionConfigurations(
            final List<FateReactionConfiguration> fateReactionConfigurationsParam) {
        this.fateReactionConfigurations = fateReactionConfigurationsParam;
        return self();
    }

    /**
     * Constructs a new {@link SpecieConfiguration} instance using the configured parameters.
     *
     * @return A new {@link SpecieConfiguration} instance constructed with the builder's parameters.
     */
    public final SpecieConfiguration build() {
        return new SpecieConfiguration(this);
    }

    @Override
    protected final SpecieConfigurationBuilder self() {
        return this;
    }
}
