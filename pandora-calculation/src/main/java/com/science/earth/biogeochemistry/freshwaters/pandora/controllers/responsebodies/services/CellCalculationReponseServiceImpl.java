package com.science.earth.biogeochemistry.freshwaters.pandora.controllers.responsebodies.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.controllers.responsebodies.CellCalculationResponse;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.CellTimestep;

@Service
public class CellCalculationReponseServiceImpl implements CellCalculationResponseService {

    /**
     * {@inheritDoc}
     */
    @Override
    public CellCalculationResponse postprocess(final List<CellTimestep> cellTimesteps) {
        return new CellCalculationResponse(cellTimesteps);
    }

}
