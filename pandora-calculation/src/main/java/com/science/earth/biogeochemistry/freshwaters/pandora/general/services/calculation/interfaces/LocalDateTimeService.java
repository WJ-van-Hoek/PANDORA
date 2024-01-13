package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces;

import java.time.LocalDateTime;
import java.util.List;

public interface LocalDateTimeService {
    /**
     * Calculates the ending {@code LocalDateTime} based on the starting time {@code t0} and the specified end time
     * {@code tEnd}.
     *
     * @param t0 The starting time.
     * @param tEnd The ending time relative to the starting time.
     * @return The calculated ending {@code LocalDateTime}.
     */
    LocalDateTime calculateTEndAsLocalDateTime(LocalDateTime t0, double tEnd);

    /**
     * Generates a list of {@code LocalDateTime} instances based on the starting time {@code t0} and the specified
     * number of timesteps.
     *
     * @param t0 The starting time.
     * @param numberOfTimesteps The number of timesteps to generate.
     * @return A list of generated {@code LocalDateTime} instances.
     * @throws IllegalArgumentException if the configured timestep unit is unsupported.
     */
    List<LocalDateTime> getDateTimeList(LocalDateTime t0, int numberOfTimesteps);
}
