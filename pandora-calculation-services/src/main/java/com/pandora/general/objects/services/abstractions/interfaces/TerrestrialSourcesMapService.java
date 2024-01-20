package com.pandora.general.objects.services.abstractions.interfaces;

import java.time.LocalDateTime;

import com.pandora.general.objects.Cell;

/**
 * The {@code TerrestrialSourcesMapService} interface extends the {@link MapService} interface and defines methods for
 * managing terrestrial sources data associated with specific {@link Cell} locations and {@link LocalDateTime}
 * timestamps. Implementations of this interface are expected to provide functionality for finding and saving
 * terrestrial sources data.
 * <p>
 * This interface is part of the abstraction layer for services related to managing terrestrial sources data.
 * </p>
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 * @see MapService
 */
public interface TerrestrialSourcesMapService extends MapService {
    /**
     * Finds the terrestrial sources data associated with the specified {@link Cell} and {@link LocalDateTime}.
     *
     * @param cell The {@code Cell} object representing a specific location.
     * @param t The {@code LocalDateTime} object representing a specific time.
     * @return An array of double values representing terrestrial sources data at the given {@code Cell} and
     * {@code LocalDateTime}, or {@code null} if not found.
     */
    double[] findAtCellAndTimestep(Cell cell, LocalDateTime t);

    /**
     * Saves the terrestrial sources data associated with the specified {@link Cell} and {@link LocalDateTime}.
     *
     * @param cell The {@code Cell} object representing a specific location.
     * @param t The {@code LocalDateTime} object representing a specific time.
     * @param data An array of double values representing terrestrial sources data to be saved.
     */
    void saveAtCellAndTimestep(Cell cell, LocalDateTime t, double[] data);
}
