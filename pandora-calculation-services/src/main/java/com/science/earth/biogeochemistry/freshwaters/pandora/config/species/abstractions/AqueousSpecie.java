package com.science.earth.biogeochemistry.freshwaters.pandora.config.species.abstractions;

public abstract class AqueousSpecie extends Specie {
    @Override
    public final double calculateTransport(final double amount, final double rate) {
        return rate * amount;
    }
}
