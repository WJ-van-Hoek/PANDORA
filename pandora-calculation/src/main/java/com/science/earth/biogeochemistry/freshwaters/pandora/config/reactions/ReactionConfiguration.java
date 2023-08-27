package com.science.earth.biogeochemistry.freshwaters.pandora.config.reactions;

import java.util.Map;

import com.science.earth.biogeochemistry.freshwaters.pandora.config.species.SpecieConfiguration;

public interface ReactionConfiguration {
    void initialize();

    Map<SpecieConfiguration, Integer> getProducedSpecies();

    Map<SpecieConfiguration, Integer> getRemovedSpecies();

    double[] calculate(double[] y);
}
