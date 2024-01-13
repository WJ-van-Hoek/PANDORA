package com.science.earth.biogeochemistry.freshwaters.pandora.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.science.earth.biogeochemistry.freshwaters.pandora.model.CellDBEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.interfaces.CellDBEntityCrudService;

@RestController
@RequestMapping("/api/cell")
public class CellCrudController {
    /**
     * The service responsible for performing CRUD operations on
     * {@link com.science.earth.biogeochemistry.freshwaters.pandora.model.CellDBEntity} instances. This service is
     * injected into the {@code CellCrudController} to provide the necessary functionality for handling HTTP requests
     * related to cell entities.
     *
     * @see com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.
     * implementations.CellDBEntityCrudService
     */
    private final CellDBEntityCrudService cellCrudService;

    /**
     * Constructs a new {@code CellCrudController} with the specified {@code CellDBEntityCrudService}.
     *
     * @param cellCrudServiceParam The service responsible for CRUD operations on cell entities.
     */
    public CellCrudController(final CellDBEntityCrudService cellCrudServiceParam) {
        this.cellCrudService = cellCrudServiceParam;
    }

    /**
     * Handles HTTP GET requests to find a cell by its ID.
     *
     * @param id The unique identifier (ID) of the cell to find.
     * @return A {@link org.springframework.http.ResponseEntity} containing the cell entity if found, {@code NOT_FOUND}
     * if the cell does not exist, and {@code INTERNAL_SERVER_ERROR} in case of an exception.
     */
    @GetMapping("/find/{id}")
    public final ResponseEntity<CellDBEntity> findById(@PathVariable final Long id) {
        try {
            CellDBEntity cell = cellCrudService.findById(id);

            if (cell != null) {
                return new ResponseEntity<>(cell, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
