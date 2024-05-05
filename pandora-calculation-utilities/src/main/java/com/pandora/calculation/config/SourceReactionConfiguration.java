package com.pandora.calculation.config;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * Configuration class for defining source reaction configurations. This class extends the {@link IndexedConfiguration}
 * class.
 *
 * @author Wim Joost van Hoek
 * @version 0.0.1
 * @since 0.0.1
 */
@Getter
@Builder
@Accessors(prefix = "_", chain = true) // Specify prefix and chain options
public final class SourceReactionConfiguration extends IndexedConfiguration {
    /**
     * The name of the source reaction configuration.
     */
    private String _name;

    /**
     * The source from which the reaction configuration originates.
     */
    private String _from;

    /**
     * The unit of associated with the configuration.
     */
    private String _unit;

    /**
     * Constructs a new SourceReactionConfiguration object using the provided builder.
     *
     * <p>
     * This constructor initializes a source reaction configuration with the specified name, source from which it
     * originates, and unit associated with the configuration.
     *
     * @param name The name of the source reaction configuration.
     * @param from The source from which the reaction originates.
     * @param unit The unit associated with the source reaction configuration.
     */
    @Builder
    private SourceReactionConfiguration(final String name, final String from, final String unit) {
        _name = name;
        _from = from;
        _unit = unit;
    }

}
