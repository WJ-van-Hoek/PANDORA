package com.pandora.calculation.config.builders;

import com.pandora.calculation.config.FateReactionConfiguration;

import lombok.Getter;

/**
 * Builder class for constructing {@link FateReactionConfiguration} instances. This builder extends
 * {@link ConfigurationBuilder} and allows for configuring the destination and rate of a fate reaction configuration.
 *
 * @author Wim Joost van Hoek
 * @version 0.0.1
 * @since 0.0.1
 */
@Getter
public class FateReactionConfigurationBuilder extends ConfigurationBuilder<FateReactionConfigurationBuilder> {

    /**
     * The destination of the fate reaction configuration.
     */
    private String to;

    /**
     * The rate of the fate reaction configuration.
     */
    private double rate;

    /**
     * Sets the destination of the fate reaction configuration.
     *
     * @param toParam The destination of the fate reaction configuration.
     * @return This builder instance for method chaining.
     */
    public final FateReactionConfigurationBuilder to(final String toParam) {
        this.to = toParam;
        return self();
    }

    /**
     * Sets the rate of the fate reaction configuration.
     *
     * @param rateParam The rate of the fate reaction configuration.
     * @return This builder instance for method chaining.
     */
    public final FateReactionConfigurationBuilder rate(final double rateParam) {
        this.rate = rateParam;
        return self();
    }

    /**
     * Constructs a new {@link FateReactionConfiguration} instance using the current state of this builder.
     *
     * @return A new {@link FateReactionConfiguration} instance.
     */
    public final FateReactionConfiguration build() {
        return new FateReactionConfiguration(this);
    }

    /**
     * Returns a reference to this builder instance.
     *
     * @return This builder instance.
     */
    protected final FateReactionConfigurationBuilder self() {
        return this;
    }

}
