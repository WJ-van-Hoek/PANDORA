package com.science.earth.biogeochemistry.freshwaters.pandora.config.species;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.science.earth.biogeochemistry.freshwaters.pandora.chemistry.interfaces.Carbon;
import com.science.earth.biogeochemistry.freshwaters.pandora.chemistry.interfaces.Dissolved;
import com.science.earth.biogeochemistry.freshwaters.pandora.chemistry.interfaces.Inorganic;
import com.science.earth.biogeochemistry.freshwaters.pandora.config.species.abstractions.AqueousSpecie;

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
