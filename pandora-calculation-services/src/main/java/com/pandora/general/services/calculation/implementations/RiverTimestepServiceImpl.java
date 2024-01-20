package com.pandora.general.services.calculation.implementations;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pandora.general.objects.River;
import com.pandora.general.services.calculation.interfaces.CellTimestepService;
import com.pandora.general.services.calculation.interfaces.RiverTimestepService;

/**
 * The {@code RiverTimestepServiceImpl} class implements the {@link RiverTimestepService} interface and provides
 * functionality for calculating the next timestep for each cell within a river simulation. It utilizes a
 * {@code CellTimestepService} to calculate the next timestep for each cell concurrently, taking into account the
 * independence of cell sets in the river.
 * <p>
 * This class uses the Spring Framework's {@code @Service} annotation to indicate that it is a service component and can
 * be injected into other components.
 * </p>
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 * @see RiverTimestepService
 * @see CellTimestepService
 * @see River
 * @see LocalDateTime
 */
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
