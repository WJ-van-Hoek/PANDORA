package com.science.earth.biogeochemistry.freshwaters.pandora.config.species.abstractions;

public abstract class AqueousSpecie extends Specie {
    @Override
    public double calculateTransport(double amount, double rate) {
	return rate * amount;
    }
}
