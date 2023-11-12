package com.science.earth.biogeochemistry.freshwaters.pandora.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.science.earth.biogeochemistry.freshwaters.pandora.controllers.requestbodies.CellCalculationRequest;
import com.science.earth.biogeochemistry.freshwaters.pandora.controllers.requestbodies.services.CellCalculationRequestService;
import com.science.earth.biogeochemistry.freshwaters.pandora.controllers.responsebodies.CellCalculationResponse;
import com.science.earth.biogeochemistry.freshwaters.pandora.controllers.responsebodies.services.CellCalculationResponseService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.CellTimestep;

import jakarta.xml.bind.ValidationException;

@RestController
@RequestMapping("/api/cell")
public class CellController {

    private final CellCalculationRequestService cellCalculationRequestService;

    private final CellCalculationResponseService cellCalculationResponseService;

    @Autowired
    public CellController(CellCalculationRequestService cellCalculationRequestService,
	    CellCalculationResponseService cellCalculationResponseService) {
	this.cellCalculationRequestService = cellCalculationRequestService;
	this.cellCalculationResponseService = cellCalculationResponseService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<CellCalculationResponse> calculateSeries(@RequestBody CellCalculationRequest request) {
	try {
	    validate(request);
	    cellCalculationRequestService.preprocess(request);
	    List<CellTimestep> results = cellCalculationRequestService.process(request);
	    CellCalculationResponse response = cellCalculationResponseService.postprocess(results);
	    return ResponseEntity.ok(response);
	} catch (ValidationException e) {
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	} catch (Exception e) {
	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}
    }

    private void validate(CellCalculationRequest request) throws ValidationException {
	request.validate();
    }
}
