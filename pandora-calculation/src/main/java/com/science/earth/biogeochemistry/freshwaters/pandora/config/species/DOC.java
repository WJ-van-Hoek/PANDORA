package com.science.earth.biogeochemistry.freshwaters.pandora.config.species;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;

import com.science.earth.biogeochemistry.freshwaters.pandora.chemistry.interfaces.Carbon;
import com.science.earth.biogeochemistry.freshwaters.pandora.chemistry.interfaces.Dissolved;
import com.science.earth.biogeochemistry.freshwaters.pandora.chemistry.interfaces.Organic;
import com.science.earth.biogeochemistry.freshwaters.pandora.config.species.abstractions.AqueousSpecie;

@Configuration
@PropertySource("classpath:species.properties")
@Order(1)
public class DOC extends AqueousSpecie implements Dissolved, Organic, Carbon {
    @Value("${doc.name}")
    private String name;
    
    @Value("${doc.unit}")
    private String unit;

    @Value("${doc.molarmass}")
    private double molarMass;

    @Value("${doc.oxidation.rate}")
    private double oxidationRate;
    
    @Override
    public String getName() {
	return this.name.toLowerCase();
    }

    @Override
    public String getUnit() {
	return this.unit;
    }
    
    @Override
    public double getMolarMass() {
	return this.molarMass;
    }
    
    @Override
    public double getOxidationRate() {
	return this.oxidationRate;
    }
    
    @Override
    public String toString() {
	return getName();
    }
  
}
