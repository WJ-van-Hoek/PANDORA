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
	@Value("${dic.name}")
	private String name;

	@Value("${dic.unit}")
	private String unit;

	@Value("${dic.molarmass}")
	private double molarMass;

	public DIC() {
		getLog().info("DIC bean is being loaded.");
	}

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
	public String toString() {
		return getName();
	}
}
