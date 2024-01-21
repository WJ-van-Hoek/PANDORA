package com.pandora.general.objects.services.abstractions.interfaces;

import java.time.LocalDateTime;

import com.pandora.general.objects.Cell;

/**
 * The {@code VolumesMapService} interface extends the {@link MapService} interface and defines methods for managing
 * volume data associated with specific {@link Cell} locations and {@link LocalDateTime} timestamps. Implementations of
 * this interface are expected to provide functionality for finding and saving volume data.
 * <p>
 * This interface is part of the abstraction layer for services related to managing volume data.
 * </p>
 *
 * @author Wim Joost van Hoek
 * @version 0.0.1
 * @see MapService
 */
public interface VolumesMapService extends MapService {
    /**
     * Finds the volume data associated with the specified {@link Cell} and {@link LocalDateTime}.
     *
     * @param cell The {@code Cell} object representing a specific location.
     * @param t The {@code LocalDateTime} object representing a specific time.
     * @return The volume value at the given {@code Cell} and {@code LocalDateTime}, or {@code null} if not found.
     */
    Double findAtCellAndTimestep(Cell cell, LocalDateTime t);

    /**
     * Saves the volume data associated with the specified {@link Cell} and {@link LocalDateTime}.
     *
     * @param cell The {@code Cell} object representing a specific location.
     * @param t The {@code LocalDateTime} object representing a specific time.
     * @param volume The volume value to be saved.
     */
    void saveAtCellAndTimestep(Cell cell, LocalDateTime t, Double volume);
}
