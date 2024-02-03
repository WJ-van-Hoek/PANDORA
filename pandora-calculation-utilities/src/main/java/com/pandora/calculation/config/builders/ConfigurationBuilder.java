package com.pandora.calculation.config.builders;

import lombok.Getter;

/**
 * The ConfigurationBuilder class serves as a base abstraction for building instances of Configuration or its
 * subclasses.
 *
 * @param <T> the type of ConfigurationBuilder or its subclass, enabling fluent method chaining and ensuring type
 * safety.
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 */
@Getter
public abstract class ConfigurationBuilder<T extends ConfigurationBuilder<T>> {

    /**
     * The unit of measurement associated with the configuration.
     */
    private String unit;

    /**
     * The name of the configuration.
     */
    private String name;

    /**
     * Sets the unit of measurement for the configuration.
     *
     * @param unitParam the unit of measurement to set
     * @return a subclass of the ConfigurationBuilder instance
     */
    public final T unit(final String unitParam) {
        this.unit = unitParam;
        return self();
    }

    /**
     * Sets the name for the configuration.
     *
     * @param nameParam the name of the configuration
     * @return a subclass of the ConfigurationBuilder instance
     */
    public final T name(final String nameParam) {
        this.name = nameParam;
        return self();
    }

    /**
     * This method returns an instance of the subclass.
     *
     * @return an instance of the subclass
     */
    protected abstract T self();
}
