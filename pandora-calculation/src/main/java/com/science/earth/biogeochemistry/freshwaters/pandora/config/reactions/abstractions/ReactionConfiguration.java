package com.science.earth.biogeochemistry.freshwaters.pandora.config.reactions.abstractions;

import java.util.Map;

import com.science.earth.biogeochemistry.freshwaters.pandora.config.species.abstractions.Specie;

public interface ReactionConfiguration {
    void initialize();

    Map<Specie, Integer> getProducedSpecies();

    Map<Specie, Integer> getRemovedSpecies();

    double[] calculate(double[] y);
}
