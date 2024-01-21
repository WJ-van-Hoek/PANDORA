package com.pandora.config.species;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.pandora.chemistry.interfaces.Carbon;
import com.pandora.chemistry.interfaces.Dissolved;
import com.pandora.chemistry.interfaces.Inorganic;
import com.pandora.config.species.abstractions.AqueousSpecie;

/**
 * The {@code DIC} class represents Dissolved Inorganic Carbon (DIC) as a bean in the PANDORA model. It is configured
 * based on properties specified in the "dic" namespace. The class implements the {@link Dissolved}, {@link Inorganic},
 * and {@link Carbon} interfaces, providing specific characteristics associated with dissolved inorganic carbon species.
 * <p>
 * The DIC bean includes properties such as name, unit of measurement, and molar mass, which are configured from the
 * corresponding properties in the "dic" namespace. The class is conditionally loaded using the
 * {@link ConditionalOnProperty} annotation with the "dic.enabled" property.
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 */
@ConditionalOnProperty(name = "dic.enabled", havingValue = "true")
@Configuration
@Order(1)
public class DIC extends AqueousSpecie implements Dissolved, Inorganic, Carbon {
    /**
     * The name of the DIC species, configured from the "dic.name" property.
     */
    @Value("${dic.name}")
    private String name;

    /**
     * The unit of measurement for DIC, configured from the "dic.unit" property.
     */
    @Value("${dic.unit}")
    private String unit;

    /**
     * The molar mass of DIC, representing the mass of one mole of the species. It is configured from the
     * "dic.molarmass" property.
     */
    @Value("${dic.molarmass}")
    private double molarMass;

    /**
     * Default constructor for creating an instance of the DIC bean. It logs a message indicating that the DIC bean is
     * being loaded.
     */
    public DIC() {
        getLog().info("DIC bean is being loaded.");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return this.name.toLowerCase();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getUnit() {
        return this.unit;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getMolarMass() {
        return this.molarMass;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return getName();
    }
}
