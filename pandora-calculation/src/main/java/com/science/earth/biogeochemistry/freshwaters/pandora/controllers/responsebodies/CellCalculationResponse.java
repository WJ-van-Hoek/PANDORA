package com.science.earth.biogeochemistry.freshwaters.pandora.controllers.responsebodies;

import java.util.List;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.CellTimestep;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CellCalculationResponse {
    /**
     * A list of {@code CellTimestep} objects representing the computed timesteps for a specific cell.
     */
    private List<CellTimestep> cellTimesteps;
}
