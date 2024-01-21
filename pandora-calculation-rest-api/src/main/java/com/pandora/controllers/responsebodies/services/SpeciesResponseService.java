package com.pandora.controllers.responsebodies.services;

import java.util.Map;

import com.pandora.config.species.abstractions.Specie;
import com.pandora.controllers.responsebodies.SpeciesResponse;

/**
 * The {@code SpeciesResponseService} interface defines the contract for services responsible for post-processing
 * species-related responses and converting them into the appropriate format represented by {@link SpeciesResponse}.
 * Implementing classes are expected to provide the logic for post-processing specie information.
 *
 * @author Wim Joost van Hoek
 * @version 0.0.1
 * @see SpeciesResponse
 */
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
