package com.pandora.calculation.config;

import com.pandora.calculation.config.builders.FateReactionConfigurationBuilder;

import lombok.Getter;

/**
 * Configuration class for defining fate reaction configurations.
 * This class extends the {@link Configuration} class.
 *
 * @author Wim Joost van Hoek
 * @version 1.0
 * @since 1.0
 */
@SuppressWarnings("serial")
@Getter
public class FateReactionConfiguration extends Configuration {

    /**
     * The destination of the fate reaction configuration.
     */
    private String to;

    /**
     * The rate of the fate reaction configuration.
     */
    private double rate;

    /**
     * Constructs a new FateReactionConfiguration instance.
     *
     * @param builder The builder used to construct this configuration.
     */
    public FateReactionConfiguration(final FateReactionConfigurationBuilder<?> builder) {
        super(builder);
        this.to = builder.getTo();
        this.rate = builder.getRate();
    }

    /**
     * Returns a new builder for constructing FateReactionConfiguration instances.
     *
     * @return A new {@link FateReactionConfigurationBuilder} instance.
     */
    public static FateReactionConfigurationBuilder<?> builder() {
        return new FateReactionConfigurationBuilder<>();
    }
}

