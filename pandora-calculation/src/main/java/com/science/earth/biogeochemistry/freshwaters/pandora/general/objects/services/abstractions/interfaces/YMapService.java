package com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.interfaces;

import java.time.LocalDateTime;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.Cell;

public interface YMapService extends MapService {
    /**
     * Finds the state variable data associated with the specified {@link Cell} and {@link LocalDateTime}.
     *
     * @param cell The {@code Cell} object representing a specific location.
     * @param t The {@code LocalDateTime} object representing a specific time.
     * @return An array of double values representing state variable data at the given {@code Cell} and
     * {@code LocalDateTime}, or {@code null} if not found.
     */
    double[] findAtCellAndTimestep(Cell cell, LocalDateTime t);

    /**
     * Saves the state variable data associated with the specified {@link Cell} and {@link LocalDateTime}.
     *
     * @param cell The {@code Cell} object representing a specific location.
     * @param t The {@code LocalDateTime} object representing a specific time.
     * @param y An array of double values representing state variable data to be saved.
     */
    void saveAtCellAndTimestep(Cell cell, LocalDateTime t, double[] y);
}
