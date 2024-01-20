package com.pandora.controllers.responsebodies.services;

import java.util.List;

import com.pandora.controllers.responsebodies.CellCalculationResponse;
import com.pandora.general.objects.CellTimestep;

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
