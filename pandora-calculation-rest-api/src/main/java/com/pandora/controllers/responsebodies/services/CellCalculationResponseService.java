package com.pandora.controllers.responsebodies.services;

import java.util.List;

import com.pandora.controllers.responsebodies.CellCalculationResponse;
import com.pandora.general.objects.CellTimestep;

/**
 * The {@code CellCalculationResponseService} interface defines the contract for services responsible for
 * post-processing cell calculation responses and converting them into the appropriate format represented by
 * {@link CellCalculationResponse}. Implementing classes are expected to provide the logic for post-processing cell
 * timesteps.
 *
 * @author Wim Joost van Hoek
 * @version 0.0.1
 * @see CellCalculationResponse
 */
public interface CellCalculationResponseService {
    /**
     * Postprocesses a list of {@code CellTimestep} objects and generates a {@code CellCalculationResponse} containing
     * the processed cell timesteps.
     *
     * @param cellTimesteps The list of {@code CellTimestep} objects to be processed.
     * @return A {@code CellCalculationResponse} containing the processed cell timesteps.
     */
    CellCalculationResponse postprocess(List<CellTimestep> cellTimesteps);
}
