package com.science.earth.biogeochemistry.freshwaters.pandora.config.species;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.science.earth.biogeochemistry.freshwaters.pandora.chemistry.interfaces.Carbon;
import com.science.earth.biogeochemistry.freshwaters.pandora.chemistry.interfaces.Dissolved;
import com.science.earth.biogeochemistry.freshwaters.pandora.chemistry.interfaces.Organic;
import com.science.earth.biogeochemistry.freshwaters.pandora.config.species.abstractions.AqueousSpecie;

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
