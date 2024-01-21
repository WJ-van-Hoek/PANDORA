package com.pandora.general.objects.services.abstractions.interfaces;

import java.time.LocalDateTime;

import com.pandora.general.objects.Cell;

/**
 * The {@code DischargesMapService} interface extends the {@link MapService} interface and defines methods for managing
 * discharge values associated with specific {@link Cell} locations and {@link LocalDateTime} timestamps.
 * Implementations of this interface are expected to provide functionality for finding and saving discharge values.
 * <p>
 * This interface is part of the abstraction layer for services related to managing discharge values.
 * </p>
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 * @see MapService
 */
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
