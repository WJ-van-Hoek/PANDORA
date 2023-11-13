package com.science.earth.biogeochemistry.freshwaters.pandora.controllers.responsebodies.services;

import java.util.Map;

import com.science.earth.biogeochemistry.freshwaters.pandora.config.species.abstractions.Specie;
import com.science.earth.biogeochemistry.freshwaters.pandora.controllers.responsebodies.SpeciesResponse;

public interface SpeciesResponseService {
    SpeciesResponse postprocess(Map<String, Specie> specieBeanMap);
}
