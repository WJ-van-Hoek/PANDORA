package com.science.earth.biogeochemistry.freshwaters.pandora.controllers.responsebodies.services;

import java.util.List;

import com.science.earth.biogeochemistry.freshwaters.pandora.controllers.responsebodies.CellCalculationResponse;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.CellTimestep;

public interface CellCalculationResponseService {
    CellCalculationResponse postprocess(List<CellTimestep> cellTimesteps);
}
