package com.pandora.calculation.config;

import java.io.Serializable;

import org.slf4j.Logger;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pandora.calculation.config.builders.ConfigurationBuilder;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * The Configuration class represents the configuration associated with a calculation component in PANDORA. It provides
 * methods to retrieve information such as the index, unit, and logger of the calculation component.
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 */
@SuppressWarnings("serial")
@Getter
@NoArgsConstructor
public abstract class Configuration implements Logged, Serializable {

    /**
     * The logger used for logging messages and events related to the configuration. This field is marked with
     * {@code @JsonIgnore} to exclude it from serialization and deserialization processes, as it is transient and should
     * not be persisted.
     */
    @JsonIgnore
    private static transient Logger log;

    /**
     * The index associated with the configuration.
     */
    private int index;

    /**
     * Flag to track whether the index has been initialized.
     */
    private boolean indexed = false;

    /**
     * The unit of associated with the configuration.
     */
    private String unit;

    /**
     * Retrieves the logger associated with the configuration. The logger is used for logging messages and events
     * related to the configuration.
     *
     * @return The logger for the configuration.
     */
    @Override
    public final Logger getLog() {
        return log;
    }

    /**
     * Sets the index for the configuration. This method should only be called once to initialize the index.
     *
     * @param indexParam the index to set
     * @throws IllegalStateException if the index has already been initialized
     */
    public final void setIndex(final int indexParam) {
        if (!indexed) {
            this.index = indexParam;
            indexed = true;
        } else {
            // Throw an IllegalStateException or handle the case where index is already set
            throw new IllegalStateException("Index has already been set.");
        }
    }

    /**
     * Constructs a new Configuration using the provided builder.
     *
     * @param builder the builder containing the configuration parameters
     */
    protected Configuration(final ConfigurationBuilder<?> builder) {
        this.unit = builder.getUnit();
    }
}
