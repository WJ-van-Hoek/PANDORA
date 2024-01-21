package com.pandora.general.objects.services.implementations;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.pandora.general.objects.Cell;
import com.pandora.general.objects.services.abstractions.classes.AbstractHashMapService;
import com.pandora.general.objects.services.abstractions.interfaces.VolumesMapService;

/**
 * VolumesMapServiceImpl is an implementation of the {@link VolumesMapService} interface, providing services related to
 * managing volume data associated with specific {@link Cell} locations and {@link LocalDateTime} timestamps. It extends
 * the {@link AbstractHashMapService} class to leverage a {@link HashMap} for efficient data storage.
 *
 * @author Wim Joost van Hoek
 * @version 0.0.1
 * @see VolumesMapService
 * @see AbstractHashMapService
 */
@Service
public class VolumesMapServiceImpl extends AbstractHashMapService implements VolumesMapService {

    /**
     * Internal {@link HashMap} to store volume values hashed by the combination of {@link Cell} and
     * {@link LocalDateTime}.
     */
    private Map<Integer, Double> map = new HashMap<>();

    /**
     * {@inheritDoc}
     * <p>
     * This implementation resets the internal {@link HashMap}, effectively cleaning the volumes map.
     * </p>
     */
    @Override
    public void cleanMap() {
        map = new HashMap<>();
    }

    /**
     * {@inheritDoc}
     * <p>
     * Finds the volume data associated with the specified {@link Cell} and {@link LocalDateTime}.
     * </p>
     *
     * @param cell The {@code Cell} object representing a specific location.
     * @param t The {@code LocalDateTime} object representing a specific time.
     * @return The volume value at the given {@code Cell} and {@code LocalDateTime}, or {@code null} if not found.
     */
    @Override
    public Double findAtCellAndTimestep(final Cell cell, final LocalDateTime t) {
        return map.get(hashCellAndTime(cell, t));
    }

    /**
     * {@inheritDoc}
     * <p>
     * Saves the volume data associated with the specified {@link Cell} and {@link LocalDateTime}.
     * </p>
     *
     * @param cell The {@code Cell} object representing a specific location.
     * @param t The {@code LocalDateTime} object representing a specific time.
     * @param volume The volume value to be saved.
     */
    @Override
    public void saveAtCellAndTimestep(final Cell cell, final LocalDateTime t, final Double volume) {
        map.put(hashCellAndTime(cell, t), volume);
    }
}
