package com.science.earth.biogeochemistry.freshwaters.pandora.controllers.responsebodies.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.controllers.responsebodies.CellCalculationResponse;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.CellTimestep;

@Service
public class CellCalculationReponseServiceImpl implements CellCalculationResponseService {

    @Override
    public CellCalculationResponse postprocess(List<CellTimestep> cellTimesteps) {
	return new CellCalculationResponse(cellTimesteps);

    }

}
