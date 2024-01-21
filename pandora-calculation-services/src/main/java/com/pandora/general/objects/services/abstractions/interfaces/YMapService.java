package com.pandora.general.objects.services.abstractions.interfaces;

import java.time.LocalDateTime;

import com.pandora.general.objects.Cell;

/**
 * The {@code YMapService} interface extends the {@link MapService} interface and defines methods for managing state
 * variable data associated with specific {@link Cell} locations and {@link LocalDateTime} timestamps. Implementations
 * of this interface are expected to provide functionality for finding and saving state variable data.
 * <p>
 * This interface is part of the abstraction layer for services related to managing state variable data.
 * </p>
 *
 * @author Wim Joost van Hoek
 * @version 0.0.1
 * @see MapService
 */
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
