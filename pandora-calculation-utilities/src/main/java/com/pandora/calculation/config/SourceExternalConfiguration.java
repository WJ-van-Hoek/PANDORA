package com.pandora.calculation.config;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.pandora.calculation.config.builders.SourceExternalConfigurationBuilder;

import lombok.Getter;

/**
 * Represents an external configuration for a source. This class extends {@link Configuration} and provides a map of
 * data associated with {@link LocalDateTime}.
 *
 * @author Wim Joost van Hoek
 * @version 0.0.1
 * @since 0.0.1
 */
@SuppressWarnings("serial")
@Getter
public class SourceExternalConfiguration extends Configuration {

    /**
     * A map storing data associated with {@link LocalDateTime}.
     */
    private Map<LocalDateTime, Double> data = new ConcurrentHashMap<>();

    /**
     * Constructs a new {@link SourceExternalConfiguration} instance using the provided builder.
     *
     * @param builder The builder used to construct this configuration.
     */
    public SourceExternalConfiguration(final SourceExternalConfigurationBuilder builder) {
        super(builder);
        this.data = builder.getData();
    }

    /**
     * Returns a new {@link SourceExternalConfigurationBuilder} instance to build {@link SourceExternalConfiguration}.
     *
     * @return A new instance of {@link SourceExternalConfigurationBuilder}.
     */
    public static SourceExternalConfigurationBuilder builder() {
        return new SourceExternalConfigurationBuilder();
    }
}
