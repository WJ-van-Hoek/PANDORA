package com.science.earth.biogeochemistry.freshwaters.pandora.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.CellTimestep;
import com.science.earth.biogeochemistry.freshwaters.pandora.requestbodies.CellCalculationRequest;
import com.science.earth.biogeochemistry.freshwaters.pandora.requestbodies.services.CellCalculationRequestService;

import jakarta.xml.bind.ValidationException;

@RestController
@RequestMapping("/api/cell")
public class CellController {

    private final CellCalculationRequestService cellCalculationRequestService;

    @Autowired
    public CellController(CellCalculationRequestService cellCalculationRequestService) {
	this.cellCalculationRequestService = cellCalculationRequestService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<List<CellTimestep>> calculateSeries(@RequestBody CellCalculationRequest request) {
	try {
	    validate(request);
	    cellCalculationRequestService.preprocess(request);

	    List<CellTimestep> results = cellCalculationRequestService.process(request);

	    return ResponseEntity.ok(results);
	} catch (ValidationException e) {
	    // Handle validation exception and return a response with an appropriate status
	    // code
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	} catch (Exception e) {
	    // Handle other exceptions and return a response with an appropriate status code
	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}
    }

    private void validate(CellCalculationRequest request) throws ValidationException {
	// Your validation logic here
	// Throw ValidationException if validation fails
    }
}
