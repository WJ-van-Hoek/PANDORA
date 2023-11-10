package com.science.earth.biogeochemistry.freshwaters.pandora.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
    // services
    private final CellDBEntityCrudService cellCrudService;

    /**
     * @param cellCrudService
     */
    @Autowired
    public CellCrudController(CellDBEntityCrudService cellCrudService) {
	this.cellCrudService = cellCrudService;
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity<CellDBEntity> findById(@PathVariable Long id) {
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
