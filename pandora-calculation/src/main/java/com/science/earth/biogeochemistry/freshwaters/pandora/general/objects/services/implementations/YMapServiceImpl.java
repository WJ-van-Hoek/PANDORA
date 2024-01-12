package com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.implementations;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.Cell;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.classes.AbstractHashMapService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.interfaces.YMapService;

@Service
public class YMapServiceImpl extends AbstractHashMapService implements YMapService {
    /**
     * Internal {@link HashMap} to store state variable arrays hashed by the combination of {@link Cell} and
     * {@link LocalDateTime}.
     */
    private Map<Integer, double[]> map = new HashMap<>();

    /**
     * {@inheritDoc}
     * <p>
     * This implementation resets the internal {@link HashMap}, effectively cleaning the state variable map.
     * </p>
     */
    @Override
    public void cleanMap() {
        map = new HashMap<>();
    }

    /**
     * {@inheritDoc}
     * <p>
     * Finds the state variable data associated with the specified {@link Cell} and {@link LocalDateTime}.
     * </p>
     *
     * @param cell The {@code Cell} object representing a specific location.
     * @param t The {@code LocalDateTime} object representing a specific time.
     * @return An array of double values representing state variable data at the given {@code Cell} and
     * {@code LocalDateTime}, or {@code null} if not found.
     */
    @Override
    public double[] findAtCellAndTimestep(final Cell cell, final LocalDateTime t) {
        return map.get(hashCellAndTime(cell, t));
    }

    /**
     * {@inheritDoc}
     * <p>
     * Saves the state variable data associated with the specified {@link Cell} and {@link LocalDateTime}.
     * </p>
     *
     * @param cell The {@code Cell} object representing a specific location.
     * @param t The {@code LocalDateTime} object representing a specific time.
     * @param y An array of double values representing state variable data to be saved.
     */
    @Override
    public void saveAtCellAndTimestep(final Cell cell, final LocalDateTime t, final double[] y) {
        map.put(hashCellAndTime(cell, t), y);
    }
}
