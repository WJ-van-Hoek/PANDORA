package com.science.earth.biogeochemistry.freshwaters.pandora.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.Cell;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces.CellTimestepService;
import com.science.earth.biogeochemistry.freshwaters.pandora.requestbodies.CellCalculationRequest;

import jakarta.xml.bind.ValidationException;

@RestController
@RequestMapping("/api/cell")
public class CellController {

    private final CellTimestepService cellTimestepService;

    @Autowired
    public CellController(CellTimestepService cellTimestepService) {
        this.cellTimestepService = cellTimestepService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<List<double[]>> calculateSeries(@RequestBody CellCalculationRequest request) {
        try {
            validateRequest(request);

            Cell cell = request.getCell();
            LocalDateTime t0 = request.getT0();
            int numberOfTimesteps = request.getNumberOfTimesteps();

            List<double[]> results = cellTimestepService.calculateTimeSeries(cell, t0, numberOfTimesteps);
            return ResponseEntity.ok(results);
        } catch (ValidationException e) {
            // Handle validation exception and return a response with an appropriate status code
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            // Handle other exceptions and return a response with an appropriate status code
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    private void validateRequest(CellCalculationRequest request) throws ValidationException {
        // Your validation logic here
        // Throw ValidationException if validation fails
    }
}
