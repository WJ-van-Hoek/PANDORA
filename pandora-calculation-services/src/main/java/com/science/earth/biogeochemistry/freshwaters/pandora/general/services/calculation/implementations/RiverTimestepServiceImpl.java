package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.implementations;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.River;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces.CellTimestepService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces.RiverTimestepService;

@Service
public class RiverTimestepServiceImpl implements RiverTimestepService {
    /**
     * Service for calculating cell timesteps within a river simulation.
     */
    @Autowired
    private CellTimestepService cellTimestepService;

    /**
     * Calculates the next timestep for each cell in the river simulation.
     *
     * @param river The river object representing the simulation.
     * @param t0 The starting time of the current timestep.
     */
    @Override
    public void calculateNextTimestep(final River river, final LocalDateTime t0) {
        // Iterate over independent cell sets in the river.
        river.getIndependentCellSets().forEach(cellSet ->
        // Parallel stream to calculate the next timestep for each cell concurrently.
        cellSet.parallelStream().forEach(cell -> cellTimestepService.calculateNextTimestep(cell, t0)));
    }
}
