package com.pandora.calculation.config;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * Configuration class for defining fate reaction configurations. This class extends the {@link IndexedConfiguration}
 * class.
 *
 * @author Wim Joost van Hoek
 * @version 0.0.1
 * @since 0.0.1
 */
@Getter
@Builder
@Accessors(prefix = "_", chain = true) // Specify prefix and chain options
public final class FateReactionConfiguration extends IndexedConfiguration {
    /**
     * The name of the fate reaction configuration.
     */
    private String _name;

    /**
     * The destination of the fate reaction configuration.
     */
    private String _to;

    /**
     * The rate of the fate reaction configuration.
     */
    private double _rate;

    /**
     * The unit of associated with the configuration.
     */
    private String _unit;

    /**
     * Constructs a new FateReactionConfiguration object using the provided builder.
     *
     * @param name The name of the fate reaction configuration.
     * @param to The destination of the fate reaction configuration.
     * @param rate The rate of the fate reaction configuration.
     * @param unit The unit associated with the fate reaction configuration.
     */
    @Builder
    private FateReactionConfiguration(final String name, final String to, final double rate, final String unit) {
        _name = name;
        _to = to;
        _rate = rate;
        _unit = unit;
    }
}
