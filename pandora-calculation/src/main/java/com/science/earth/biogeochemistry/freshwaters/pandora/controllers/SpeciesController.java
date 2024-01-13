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
    /**
     * The {@code specieBeanService} attribute in the {@link SpeciesController} class represents the service responsible
     * for managing species-related operations. It is injected during the instantiation of the controller.
     *
     * @see SpecieBeanService
     */
    private final SpecieBeanService specieBeanService;

    /**
     * The {@code speciesResponseService} attribute in the {@link SpeciesController} class represents the service
     * responsible for processing species-related responses. It is injected during the instantiation of the controller.
     *
     * @see SpeciesResponseService
     */
    private final SpeciesResponseService speciesResponseService;

    /**
     * Constructs a new {@code SpeciesController} with the specified {@link SpecieBeanService} and
     * {@link SpeciesResponseService}.
     *
     * @param specieBeanServiceParam The service responsible for managing species-related operations.
     * @param speciesResponseServiceParam The service responsible for processing species-related responses.
     * @see SpecieBeanService
     * @see SpeciesResponseService
     */
    public SpeciesController(final SpecieBeanService specieBeanServiceParam,
            final SpeciesResponseService speciesResponseServiceParam) {
        this.specieBeanService = specieBeanServiceParam;
        this.speciesResponseService = speciesResponseServiceParam;
    }

    /**
     * Handles the HTTP GET request to retrieve information about all available species. It delegates the task to
     * {@link SpecieBeanService#getAllSpecies()} and then processes the results using
     * {@link SpeciesResponseService#postprocess(Map)}.
     *
     * @return A {@link ResponseEntity} containing the response with information about all available species.
     * @see SpecieBeanService
     * @see SpeciesResponseService
     */
    @GetMapping("/getSpecies")
    public ResponseEntity<SpeciesResponse> getAllSpecies() {
        Map<String, Specie> results = specieBeanService.getAllSpecies();
        SpeciesResponse response = speciesResponseService.postprocess(results);
        return ResponseEntity.ok(response);
    }
}
