package com.science.earth.biogeochemistry.freshwaters.pandora.config.species.abstractions;

import com.science.earth.biogeochemistry.freshwaters.pandora.config.Variable;

public abstract class Specie extends Variable implements SpecieConfiguration, SpecieLogic {
    @Override
    public double calculateTransport(double amount, double discharge) {
	return 0d;
    }
}
