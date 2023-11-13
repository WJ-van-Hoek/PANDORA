package com.science.earth.biogeochemistry.freshwaters.pandora.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.science.earth.biogeochemistry.freshwaters.pandora.config.services.SpecieBeanService;
import com.science.earth.biogeochemistry.freshwaters.pandora.config.species.abstractions.Specie;
import com.science.earth.biogeochemistry.freshwaters.pandora.controllers.responsebodies.SpeciesResponse;
import com.science.earth.biogeochemistry.freshwaters.pandora.controllers.responsebodies.services.SpeciesResponseService;

@RestController
@RequestMapping("/api")
public class SpeciesController {

    SpecieBeanService specieBeanService;

    SpeciesResponseService speciesResponseService;

    public SpeciesController(SpecieBeanService specieBeanService, SpeciesResponseService speciesResponseService) {
	this.specieBeanService = specieBeanService;
	this.speciesResponseService = speciesResponseService;
    }

    @GetMapping("/getSpecies")
    public ResponseEntity<SpeciesResponse> getAllSpecies() {
	Map<String, Specie> results = specieBeanService.getAllSpecies();
	SpeciesResponse response = speciesResponseService.postprocess(results);
	return ResponseEntity.ok(response);
    }

}
