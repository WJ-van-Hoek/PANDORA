package com.science.earth.biogeochemistry.freshwaters.pandora.config.species.abstractions;

public interface SpecieLogic {
    double calculateTransport(double amount, double discharge);
}
