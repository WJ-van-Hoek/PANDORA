package com.science.earth.biogeochemistry.freshwaters.pandora.controllers.responsebodies;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SpeciesResponse {
    List<String> species;
}
