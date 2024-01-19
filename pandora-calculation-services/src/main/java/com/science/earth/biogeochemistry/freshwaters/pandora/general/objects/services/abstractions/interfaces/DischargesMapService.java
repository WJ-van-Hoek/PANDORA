package com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.interfaces;

import java.time.LocalDateTime;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.Cell;

public interface DischargesMapService extends MapService {

    /**
     * Finds the discharge value associated with the specified {@link Cell} and {@link LocalDateTime}.
     *
     * @param cell The {@code Cell} object representing a specific location.
     * @param t The {@code LocalDateTime} object representing a specific time.
     * @return The discharge value at the given {@code Cell} and {@code LocalDateTime}, or {@code null} if not found.
     */
    Double findAtCellAndTimestep(Cell cell, LocalDateTime t);

    /**
     * Saves the discharge value associated with the specified {@link Cell} and {@link LocalDateTime}.
     *
     * @param cell The {@code Cell} object representing a specific location.
     * @param t The {@code LocalDateTime} object representing a specific time.
     * @param discharge The discharge value to be saved.
     */
    void saveAtCellAndTimestep(Cell cell, LocalDateTime t, Double discharge);
}
