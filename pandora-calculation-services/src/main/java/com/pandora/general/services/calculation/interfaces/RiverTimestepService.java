package com.pandora.general.services.calculation.interfaces;

import java.time.LocalDateTime;

import com.pandora.general.objects.River;

/**
 * The {@code RiverTimestepService} interface defines a method for calculating the next timestep for each cell in the
 * river simulation. Implementing classes are responsible for performing calculations based on the river object and the
 * starting time of the current timestep.
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 */
public interface RiverTimestepService {
    /**
     * Calculates the next timestep for each cell in the river simulation.
     *
     * @param river The river object representing the simulation.
     * @param t0 The starting time of the current timestep.
     */
    void calculateNextTimestep(River river, LocalDateTime t0);
}
