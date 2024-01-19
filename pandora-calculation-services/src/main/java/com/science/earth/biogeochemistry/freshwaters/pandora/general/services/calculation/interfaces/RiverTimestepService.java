package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces;

import java.time.LocalDateTime;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.River;

public interface RiverTimestepService {
    /**
     * Calculates the next timestep for each cell in the river simulation.
     *
     * @param river The river object representing the simulation.
     * @param t0 The starting time of the current timestep.
     */
    void calculateNextTimestep(River river, LocalDateTime t0);
}
