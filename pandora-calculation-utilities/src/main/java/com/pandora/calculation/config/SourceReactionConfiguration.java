package com.pandora.calculation.config;

import com.pandora.calculation.config.builders.SourceReactionConfigurationBuilder;

import lombok.Getter;

/**
 * Configuration class for defining source reaction configurations.
 * This class extends the {@link Configuration} class.
 *
 * @author Wim Joost van Hoek
 * @version 1.0
 * @since 1.0
 */
@SuppressWarnings("serial")
@Getter
public class SourceReactionConfiguration extends Configuration {

    /**
     * The source from which the reaction configuration originates.
     */
    private String from;

    /**
     * Constructs a new SourceReactionConfiguration instance.
     *
     * @param builder The builder used to construct this configuration.
     */
    public SourceReactionConfiguration(final SourceReactionConfigurationBuilder<?> builder) {
        super(builder);
        this.from = builder.getFrom();
    }

    /**
     * Returns a new builder for constructing SourceReactionConfiguration instances.
     *
     * @return A new {@link SourceReactionConfigurationBuilder} instance.
     */
    public static SourceReactionConfigurationBuilder<?> builder() {
        return new SourceReactionConfigurationBuilder<>();
    }
}
