package com.pandora.controllers.responsebodies;

import java.util.List;

import com.pandora.general.objects.CellTimestep;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The {@code CellCalculationResponse} class represents the response body for cell calculation-related HTTP requests. It
 * contains a list of {@code CellTimestep} objects representing the computed timesteps for a specific cell.
 *
 * @author Wim Joost van Hoek
 * @version 0.0.1
 */
@Getter
@AllArgsConstructor
public class CellCalculationResponse {
    /**
     * A list of {@code CellTimestep} objects representing the computed timesteps for a specific cell.
     */
    private List<CellTimestep> cellTimesteps;
}
