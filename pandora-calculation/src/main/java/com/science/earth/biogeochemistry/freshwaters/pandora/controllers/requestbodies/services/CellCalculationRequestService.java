package com.science.earth.biogeochemistry.freshwaters.pandora.controllers.requestbodies.services;

import java.util.List;

import com.science.earth.biogeochemistry.freshwaters.pandora.controllers.requestbodies.CellCalculationRequest;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.CellTimestep;

public interface CellCalculationRequestService {

    void preprocess(CellCalculationRequest request);
    List<CellTimestep> process(CellCalculationRequest request);
}
