package com.pandora.calculation.config;

import java.util.List;

import com.pandora.calculation.config.builders.SpecieConfigurationBuilder;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * The SpecieConfiguration class represents the configuration associated with a chemical species. It extends the
 * VariableConfiguration class and adds additional properties specific to chemical species.
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 */
@SuppressWarnings("serial")
@Getter
@NoArgsConstructor
public class SpecieConfiguration extends Configuration {
    /**
     * The name of the chemical species.
     */
    private String name;

    /**
     * The molar mass of the chemical species.
     */
    private double molarMass;

    /**
     * The configuration of sources of the chemical species.
     */
    private List<SourceReactionConfiguration> sourceReactionConfigurations;

    /**
     * The configuration of fates of the chemical species.
     */
    private List<FateReactionConfiguration> fateReactiononfigurations;

    /**
     * Constructs a new SpecieConfiguration using the provided builder.
     *
     * @param builder the builder containing the configuration parameters
     */
    public SpecieConfiguration(final SpecieConfigurationBuilder builder) {
        super(builder);
        this.name = builder.getName();
        this.molarMass = builder.getMolarMass();
        this.sourceReactionConfigurations = builder.getSourceReactionConfigurations();
        this.fateReactiononfigurations = builder.getFateReactionConfigurations();
    }

    /**
     * Returns a new builder for {@link SpecieConfiguration}.
     * <p>
     * This static factory method creates and returns a new instance of {@link SpecieConfigurationBuilder}, allowing for
     * the construction of {@link SpecieConfiguration} instances with configured parameters.
     *
     * @return A new {@link SpecieConfigurationBuilder} instance ready for configuring {@link SpecieConfiguration}.
     */
    public static SpecieConfigurationBuilder builder() {
        return new SpecieConfigurationBuilder();
    }

}
