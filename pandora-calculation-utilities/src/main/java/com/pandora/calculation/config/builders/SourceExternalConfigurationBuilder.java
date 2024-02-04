package com.pandora.calculation.config.builders;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.pandora.calculation.config.SourceExternalConfiguration;

import lombok.Getter;

/**
 * Builder class for constructing instances of {@link SourceExternalConfiguration}. This builder allows configuring a
 * map of data associated with {@link LocalDateTime}.
 *
 * @author Wim Joost van Hoek
 * @version 0.0.1
 * @since 0.0.1
 */
@Getter
public class SourceExternalConfigurationBuilder extends ConfigurationBuilder<SourceExternalConfigurationBuilder> {

    /**
     * A map storing data associated with {@link LocalDateTime}.
     */
    private Map<LocalDateTime, Double> data = new ConcurrentHashMap<>();

    /**
     * Sets the data for this builder.
     *
     * @param dataParam The map of data to set.
     * @return The builder instance.
     */
    public final SourceExternalConfigurationBuilder data(final Map<LocalDateTime, Double> dataParam) {
        this.data = dataParam;
        return this;
    }

    /**
     * Constructs a new {@link SourceExternalConfiguration} instance using the current state of the builder.
     *
     * @return A new instance of {@link SourceExternalConfiguration}.
     */
    public final SourceExternalConfiguration build() {
        return new SourceExternalConfiguration(this);
    }

    /**
     * Provides a reference to this builder instance.
     *
     * @return A reference to this builder instance.
     */
    protected final SourceExternalConfigurationBuilder self() {
        return this;
    }

}
