package com.pandora.controllers.requestbodies.services;

import java.util.List;

import com.pandora.controllers.requestbodies.CellCalculationRequest;
import com.pandora.general.objects.CellTimestep;

public interface CellCalculationRequestService {
    /**
     * Performs preprocessing tasks for the provided {@link CellCalculationRequest}. Preprocessing involves any
     * necessary setup or validation steps before the actual calculation of cell timesteps.
     *
     * @param request The {@link CellCalculationRequest} to be preprocessed.
     */
    void preprocess(CellCalculationRequest request);

    /**
     * Processes the provided {@link CellCalculationRequest} and returns a list of calculated {@link CellTimestep}s.
     * This method is responsible for executing the main calculation logic for the specified request.
     *
     * @param request The {@link CellCalculationRequest} to be processed.
     * @return A list of {@link CellTimestep}s representing the calculated timesteps.
     */
    List<CellTimestep> process(CellCalculationRequest request);
}
