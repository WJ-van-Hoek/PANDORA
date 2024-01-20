package com.pandora.config.species;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.pandora.chemistry.interfaces.Carbon;
import com.pandora.chemistry.interfaces.Dissolved;
import com.pandora.chemistry.interfaces.Organic;
import com.pandora.config.species.abstractions.AqueousSpecie;

/**
 * The {@code DOC} class represents Dissolved Organic Carbon (DOC) as a bean in the PANDORA model. It is configured
 * based on properties specified in the "doc" namespace. The class implements the {@link Dissolved}, {@link Organic},
 * and {@link Carbon} interfaces, providing specific characteristics associated with dissolved organic carbon species.
 * <p>
 * The DOC bean includes properties such as name, unit of measurement, molar mass, and oxidation rate, which are
 * configured from the corresponding properties in the "doc" namespace. The class is conditionally loaded using the
 * {@link ConditionalOnProperty} annotation with the "doc.enabled" property.
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 */
@ConditionalOnProperty(name = "doc.enabled", havingValue = "true")
@Configuration
@Order(1)
public class DOC extends AqueousSpecie implements Dissolved, Organic, Carbon {
    /**
     * The name of the DOC species, configured from the "doc.name" property.
     */
    @Value("${doc.name}")
    private String name;

    /**
     * The unit of measurement for DOC, configured from the "doc.unit" property.
     */
    @Value("${doc.unit}")
    private String unit;

    /**
     * The molar mass of DOC, representing the mass of one mole of the species. It is configured from the
     * "doc.molarmass" property.
     */
    @Value("${doc.molarmass}")
    private double molarMass;

    /**
     * The oxidation rate of DOC, configured from the "doc.oxidation.rate" property.
     */
    @Value("${doc.oxidation.rate}")
    private double oxidationRate;

    /**
     * Default constructor for creating an instance of the DOC bean. It logs a message indicating that the DOC bean is
     * being loaded.
     */
    public DOC() {
        getLog().info("DOC bean is being loaded.");
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
    public double getOxidationRate() {
        return this.oxidationRate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return getName();
    }
}
