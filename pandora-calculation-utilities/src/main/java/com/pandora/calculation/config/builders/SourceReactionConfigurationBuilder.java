package com.pandora.calculation.config.builders;

import com.pandora.calculation.config.SourceReactionConfiguration;

import lombok.Getter;

/**
 * Builder class for constructing {@link SourceReactionConfiguration} instances. This builder extends
 * {@link ConfigurationBuilder} and allows for configuring the source from which the reaction configuration originates.
 *
 * @author Wim Joost van Hoek
 * @version 0.0.1
 * @since 0.0.1
 */
@Getter
public class SourceReactionConfigurationBuilder extends ConfigurationBuilder<SourceReactionConfigurationBuilder> {

    /**
     * The source from which the reaction configuration originates.
     */
    private String from;

    /**
     * Sets the source from which the reaction configuration originates.
     *
     * @param fromParam The source of the reaction configuration.
     * @return This builder instance for method chaining.
     */
    public final SourceReactionConfigurationBuilder from(final String fromParam) {
        this.from = fromParam;
        return self();
    }

    /**
     * Constructs a new {@link SourceReactionConfiguration} instance using the current state of this builder.
     *
     * @return A new {@link SourceReactionConfiguration} instance.
     */
    public final SourceReactionConfiguration build() {
        return new SourceReactionConfiguration(this);
    }

    /**
     * Returns a reference to this builder instance.
     *
     * @return This builder instance.
     */
    @Override
    protected final SourceReactionConfigurationBuilder self() {
        return this;
    }

}
