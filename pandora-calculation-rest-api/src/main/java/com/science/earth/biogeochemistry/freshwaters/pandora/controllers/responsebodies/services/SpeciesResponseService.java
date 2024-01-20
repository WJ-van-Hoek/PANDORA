package com.pandora.controllers.responsebodies.services;

import java.util.Map;

import com.pandora.config.species.abstractions.Specie;
import com.pandora.controllers.responsebodies.SpeciesResponse;

public interface SpeciesResponseService {
    /**
     * Postprocesses a mapping of specie bean names to {@code Specie} objects and generates a {@code SpeciesResponse}
     * containing the processed specie information.
     *
     * @param specieBeanMap The mapping of specie bean names to {@code Specie} objects to be processed.
     * @return A {@code SpeciesResponse} containing the processed specie information.
     */
    SpeciesResponse postprocess(Map<String, Specie> specieBeanMap);
}
