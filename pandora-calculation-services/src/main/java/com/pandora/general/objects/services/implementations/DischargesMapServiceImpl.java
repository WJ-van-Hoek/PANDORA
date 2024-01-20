package com.pandora.general.objects.services.implementations;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.pandora.general.objects.Cell;
import com.pandora.general.objects.services.abstractions.classes.AbstractHashMapService;
import com.pandora.general.objects.services.abstractions.interfaces.DischargesMapService;

/**
 * DischargesMapServiceImpl is an implementation of the {@link DischargesMapService} interface, providing services
 * related to managing discharge values associated with specific {@link Cell} locations and {@link LocalDateTime}
 * timestamps. It extends the {@link AbstractHashMapService} class to leverage a {@link HashMap} for efficient data
 * storage.
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 * @see AbstractHashMapService
 * @see DischargesMapService
 * @see Service
 */
@Service
public class DischargesMapServiceImpl extends AbstractHashMapService implements DischargesMapService {
    /**
     * Internal {@link HashMap} to store discharge values hashed by the combination of {@link Cell} and
     * {@link LocalDateTime}.
     */
    private Map<Integer, Double> map = new HashMap<>();

    /**
     * {@inheritDoc}
     * <p>
     * This implementation resets the internal {@link HashMap}, effectively cleaning the discharge map.
     * </p>
     */
    @Override
    public void cleanMap() {
        map = new HashMap<>();
    }

    /**
     * {@inheritDoc}
     * <p>
     * Finds the discharge value associated with the specified {@link Cell} and {@link LocalDateTime}.
     * </p>
     *
     * @param cell The {@code Cell} object representing a specific location.
     * @param t The {@code LocalDateTime} object representing a specific time.
     * @return The discharge value at the given {@code Cell} and {@code LocalDateTime}, or {@code null} if not found.
     */
    @Override
    public Double findAtCellAndTimestep(final Cell cell, final LocalDateTime t) {
        return map.get(hashCellAndTime(cell, t));
    }

    /**
     * {@inheritDoc}
     * <p>
     * Saves the discharge value associated with the specified {@link Cell} and {@link LocalDateTime}.
     * </p>
     *
     * @param cell The {@code Cell} object representing a specific location.
     * @param t The {@code LocalDateTime} object representing a specific time.
     * @param discharge The discharge value to be saved.
     */
    @Override
    public void saveAtCellAndTimestep(final Cell cell, final LocalDateTime t, final Double discharge) {
        map.put(hashCellAndTime(cell, t), discharge);
    }
}
