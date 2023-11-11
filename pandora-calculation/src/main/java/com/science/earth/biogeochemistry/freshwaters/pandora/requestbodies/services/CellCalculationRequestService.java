package com.science.earth.biogeochemistry.freshwaters.pandora.requestbodies.services;

import java.util.List;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.CellTimestep;
import com.science.earth.biogeochemistry.freshwaters.pandora.requestbodies.CellCalculationRequest;

public interface CellCalculationRequestService {

    void preprocess(CellCalculationRequest request);
    List<CellTimestep> process(CellCalculationRequest request);
}
