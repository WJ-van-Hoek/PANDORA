package com.pandora.rest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pandora.calculation.config.SpecieConfiguration;
import com.pandora.calculation.services.SpecieConfigurationMemoryService;

/**
 * The {@code SpecieConfigurationController} class is a REST controller responsible for handling HTTP requests related
 * to specie configurations.
 * <p>
 * This controller provides endpoints for saving and retrieving specie configurations.
 * <p>
 * Endpoint mappings:
 * <ul>
 * <li>POST /specie-configurations: Saves a new specie configuration.</li>
 * <li>GET /specie-configurations/{name}: Retrieves a specie configuration by its name.</li>
 * </ul>
 * <p>
 * Responses:
 * <ul>
 * <li>For successful POST requests, returns HTTP status 201 (Created).</li>
 * <li>For successful GET requests, returns HTTP status 200 (OK) along with the retrieved specie configuration.</li>
 * <li>If no specie configuration is found for the given name, returns HTTP status 404 (Not Found).</li>
 * </ul>
 *
 * @version 0.0.1
 * @since 0.0.1
 * @author Wim Joost van Hoek
 * @see SpecieConfigurationMemoryService
 * @see SpecieConfiguration
 */
@RestController
@RequestMapping("/specie-configurations")
public class SpecieConfigurationController {

    /**
     * The {@code specieConfigurationService} field represents the service responsible for managing specie
     * configurations.
     */
    private final SpecieConfigurationMemoryService _specieConfigurationService;

    /**
     * Constructs a {@code SpecieConfigurationController} with the specified {@code SpecieConfigurationMemoryService}.
     *
     * @param specieConfigurationService the service responsible for managing specie configurations
     */
    public SpecieConfigurationController(final SpecieConfigurationMemoryService specieConfigurationService) {
        _specieConfigurationService = specieConfigurationService;
    }

    /**
     * Handles HTTP POST requests to save a new specie configuration.
     *
     * @param specieConfiguration the specie configuration to save
     * @return HTTP status 201 (Created) if the specie configuration is successfully saved
     */
    @PostMapping
    public ResponseEntity<Void> saveSpecieConfiguration(final @RequestBody SpecieConfiguration specieConfiguration) {
        _specieConfigurationService.saveSpecieConfiguration(specieConfiguration);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Handles HTTP GET requests to retrieve a specie configuration by its name.
     *
     * @param name the name of the specie configuration to retrieve
     * @return HTTP status 200 (OK) along with the retrieved specie configuration if found, or HTTP status 404 (Not
     * Found) if no specie configuration is found for the given name
     */
    @GetMapping("/{name}")
    public ResponseEntity<SpecieConfiguration> findSpecieConfiguration(final @PathVariable String name) {
        SpecieConfiguration foundSpecieConfiguration = _specieConfigurationService.findSpecieConfiguration(name);
        if (foundSpecieConfiguration != null) {
            return new ResponseEntity<>(foundSpecieConfiguration, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
