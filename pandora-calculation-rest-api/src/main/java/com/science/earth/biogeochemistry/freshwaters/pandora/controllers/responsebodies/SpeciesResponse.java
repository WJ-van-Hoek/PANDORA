package com.science.earth.biogeochemistry.freshwaters.pandora.controllers.responsebodies;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SpeciesResponse {
    /**
     * A list of {@code String} objects representing the contents in json of biogeochemical species.
     */
    private List<String> species;
}
