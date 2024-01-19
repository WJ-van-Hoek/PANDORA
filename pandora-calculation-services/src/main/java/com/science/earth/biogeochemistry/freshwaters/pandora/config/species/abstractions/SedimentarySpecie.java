package com.science.earth.biogeochemistry.freshwaters.pandora.config.species.abstractions;

public abstract class SedimentarySpecie extends Specie {
    @Override
    public final double calculateTransport(final double amount, final double discharge) {
        return 0d;
    }
}
