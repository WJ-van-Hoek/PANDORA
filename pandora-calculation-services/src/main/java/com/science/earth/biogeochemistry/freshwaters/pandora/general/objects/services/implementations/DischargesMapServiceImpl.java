package com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.implementations;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.Cell;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.classes.AbstractHashMapService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.interfaces.DischargesMapService;

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
