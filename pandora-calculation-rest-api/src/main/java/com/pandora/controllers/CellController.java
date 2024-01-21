package com.pandora.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pandora.controllers.requestbodies.CellCalculationRequest;
import com.pandora.controllers.requestbodies.services.CellCalculationRequestService;
import com.pandora.controllers.responsebodies.CellCalculationResponse;
import com.pandora.controllers.responsebodies.services.CellCalculationResponseService;
import com.pandora.general.objects.CellTimestep;

import jakarta.validation.ValidationException;

/**
 * The {@code CellController} class serves as a Spring MVC controller handling HTTP requests related to cell
 * calculations. It is responsible for initiating and processing cell calculation requests. It is annotated with
 * {@link RestController} and is mapped to the "/api/cell" base path.
 *
 * @author Wim Joost van Hoek
 * @version 0.0.1
 * @see CellCalculationRequestService
 * @see CellCalculationResponseService
 */
@RestController
@RequestMapping("/api/cell")
public class CellController {
    /**
     * The {@code cellCalculationRequestService} attribute in the {@link CellController} class represents the service
     * responsible for handling cell calculation requests. It is injected during the instantiation of the controller and
     * used to delegate the processing of cell calculation requests.
     *
     * @see CellCalculationRequestService
     */
    private final CellCalculationRequestService cellCalculationRequestService;

    /**
     * The {@code cellCalculationResponseService} attribute in the {@link CellController} class represents the service
     * responsible for handling cell calculation responses. It is injected during the instantiation of the controller
     * and used to delegate the postprocessing of cell calculation results into appropriate response formats.
     *
     * @see CellCalculationResponseService
     */
    private final CellCalculationResponseService cellCalculationResponseService;

    /**
     * Constructs a {@code CellController} with the specified services for handling cell calculation requests and
     * responses.
     *
     * @param cellCalculationRequestServiceParam The service for handling cell calculation requests.
     * @param cellCalculationResponseServiceParam The service for handling cell calculation responses.
     */
    @Autowired
    public CellController(final CellCalculationRequestService cellCalculationRequestServiceParam,
            final CellCalculationResponseService cellCalculationResponseServiceParam) {
        this.cellCalculationRequestService = cellCalculationRequestServiceParam;
        this.cellCalculationResponseService = cellCalculationResponseServiceParam;
    }

    /**
     * Handles the {@code POST /api/cell/calculate} endpoint, initiating the cell calculation and returning the
     * calculation results as a {@code ResponseEntity<CellCalculationResponse>}.
     *
     * @param request The {@link com.pandora.controllers.requestbodies.CellCalculationRequest} containing information
     * about the cell and the calculation to be performed.
     * @return A {@link org.springframework.http.ResponseEntity} containing the results of the cell calculation.
     */
    @PostMapping("/calculate")
    public ResponseEntity<CellCalculationResponse> calculateSeries(final @RequestBody CellCalculationRequest request) {
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

    /**
     * Validates the input {@link com.pandora.controllers.requestbodies.CellCalculationRequest} for the cell
     * calculation. Throws a {@link jakarta.xml.bind.ValidationException} if validation fails.
     *
     * @param request The {@link com.pandora.controllers.requestbodies.CellCalculationRequest} to be validated.
     * @throws jakarta.xml.bind.ValidationException If the validation of the request fails.
     */
    private void validate(final CellCalculationRequest request) throws ValidationException {
        request.validate();
    }
}
