package com.pandora.controllers.responsebodies;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The {@code SpeciesResponse} class represents the response body for species-related HTTP requests. It contains a list
 * of {@code String} objects representing the contents in JSON format of biogeochemical species.
 *
 * @author Wim Joost van Hoek
 * @version 0.0.1
 */
@Getter
@AllArgsConstructor
public class SpeciesResponse {
    /**
     * A list of {@code String} objects representing the contents in json of biogeochemical species.
     */
    private List<String> species;
}
