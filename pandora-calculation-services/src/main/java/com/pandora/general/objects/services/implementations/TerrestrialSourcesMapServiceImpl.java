package com.pandora.general.objects.services.implementations;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.pandora.general.objects.Cell;
import com.pandora.general.objects.services.abstractions.classes.AbstractHashMapService;
import com.pandora.general.objects.services.abstractions.interfaces.TerrestrialSourcesMapService;

/**
 * TerrestrialSourcesMapServiceImpl is an implementation of the {@link TerrestrialSourcesMapService} interface,
 * providing services related to managing terrestrial sources data associated with specific {@link Cell} locations and
 * {@link LocalDateTime} timestamps. It extends the {@link AbstractHashMapService} class to leverage a {@link HashMap}
 * for efficient data storage.
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 * @see TerrestrialSourcesMapService
 * @see AbstractHashMapService
 */
@Service
public class TerrestrialSourcesMapServiceImpl extends AbstractHashMapService implements TerrestrialSourcesMapService {
    /**
     * Internal {@link HashMap} to store terrestrial sources data arrays hashed by the combination of {@link Cell} and
     * {@link LocalDateTime}.
     */
    private Map<Integer, double[]> map = new HashMap<>();

    /**
     * {@inheritDoc}
     * <p>
     * This implementation resets the internal {@link HashMap}, effectively cleaning the terrestrial sources map.
     * </p>
     */
    @Override
    public void cleanMap() {
        map = new HashMap<>();
    }

    /**
     * {@inheritDoc}
     * <p>
     * Finds the terrestrial sources data associated with the specified {@link Cell} and {@link LocalDateTime}.
     * </p>
     *
     * @param cell The {@code Cell} object representing a specific location.
     * @param t The {@code LocalDateTime} object representing a specific time.
     * @return An array of double values representing terrestrial sources data at the given {@code Cell} and
     * {@code LocalDateTime}, or {@code null} if not found.
     */
    @Override
    public double[] findAtCellAndTimestep(final Cell cell, final LocalDateTime t) {
        return map.get(hashCellAndTime(cell, t));
    }

    /**
     * {@inheritDoc}
     * <p>
     * Saves the terrestrial sources data associated with the specified {@link Cell} and {@link LocalDateTime}.
     * </p>
     *
     * @param cell The {@code Cell} object representing a specific location.
     * @param tEnd The {@code LocalDateTime} object representing the end time.
     * @param yEnd An array of double values representing the final state values.
     */
    @Override
    public void saveAtCellAndTimestep(final Cell cell, final LocalDateTime tEnd, final double[] yEnd) {
        map.put(hashCellAndTime(cell, tEnd), yEnd);
    }
}
