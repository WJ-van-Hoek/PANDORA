package com.pandora.controllers.responsebodies.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pandora.controllers.responsebodies.CellCalculationResponse;
import com.pandora.general.objects.CellTimestep;

/**
 * The {@code CellCalculationReponseServiceImpl} class implements the {@link CellCalculationResponseService} interface.
 * It is a service responsible for post-processing cell calculation responses and converting them into the appropriate
 * format represented by {@link CellCalculationResponse}. It is annotated with {@link Service}.
 *
 * @author Wim Joost van Hoek
 * @version 0.0.1
 * @see CellCalculationResponseService
 */
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
