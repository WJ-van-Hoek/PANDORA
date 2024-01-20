package com.pandora.general.objects.services.implementations;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pandora.general.objects.Cell;
import com.pandora.general.objects.PandoraTimestep;
import com.pandora.general.objects.services.abstractions.classes.AbstractHashMapService;
import com.pandora.general.objects.services.abstractions.interfaces.UpstreamSourcesMapService;
import com.pandora.general.services.calculation.interfaces.TransportCalculationService;

/**
 * UpstreamSourcesMapServiceImpl is an implementation of the {@link UpstreamSourcesMapService} interface, providing
 * services related to managing upstream sources data associated with specific {@link Cell} locations and
 * {@link LocalDateTime} timestamps. It extends the {@link AbstractHashMapService} class to leverage a {@link HashMap}
 * for efficient data storage.
 * <p>
 * This implementation uses an autowired {@link TransportCalculationService} for calculating upstream transport sources.
 * </p>
 *
 * @author Wim Joost van Hoek
 * @version 0.0.1
 * @see UpstreamSourcesMapService
 * @see AbstractHashMapService
 * @see TransportCalculationService
 */
@Service
public class UpstreamSourcesMapServiceImpl extends AbstractHashMapService implements UpstreamSourcesMapService {

    /**
     * Autowired service for calculating upstream transport sources.
     */
    @Autowired
    private TransportCalculationService transportCalculationService;

    /**
     * Internal {@link HashMap} to store upstream sources data arrays hashed by the combination of {@link Cell} and
     * {@link LocalDateTime}.
     */
    private Map<Integer, double[]> map = new HashMap<>();

    /**
     * {@inheritDoc}
     * <p>
     * This implementation resets the internal {@link HashMap}, effectively cleaning the upstream sources map.
     * </p>
     */
    @Override
    public void cleanMap() {
        map = new HashMap<>();
    }

    /**
     * {@inheritDoc}
     * <p>
     * Finds the upstream sources data associated with the specified {@link Cell} and {@link LocalDateTime}.
     * </p>
     *
     * @param cell The {@code Cell} object representing a specific location.
     * @param t The {@code LocalDateTime} object representing a specific time.
     * @return An array of double values representing upstream sources data at the given {@code Cell} and
     * {@code LocalDateTime}, or {@code null} if not found.
     */
    @Override
    public double[] findAtCellAndTimestep(final Cell cell, final LocalDateTime t) {
        return map.get(hashCellAndTime(cell, t));
    }

    /**
     * {@inheritDoc}
     * <p>
     * Saves the upstream sources data associated with the specified {@link Cell} and {@link LocalDateTime}.
     * </p>
     *
     * @param cell The {@code Cell} object representing a specific location.
     * @param t The {@code LocalDateTime} object representing a specific time.
     * @param upstreamSources An array of double values representing upstream sources data to be saved.
     */
    @Override
    public void saveAtCellAndTimestep(final Cell cell, final LocalDateTime t, final double[] upstreamSources) {
        map.put(hashCellAndTime(cell, t), upstreamSources);
    }

    /**
     * {@inheritDoc}
     * <p>
     * Saves the upstream sources data associated with the specified {@link Cell}, {@link PandoraTimestep},
     * {@link LocalDateTime}, and final state values. The upstream sources are calculated using the injected
     * {@link TransportCalculationService}.
     * </p>
     *
     * @param cell The {@code Cell} object representing a specific location.
     * @param pandoraTimestep The {@code PandoraTimestep} object representing a specific time step.
     * @param tEnd The {@code LocalDateTime} object representing the end time.
     * @param yEnd An array of double values representing the final state values.
     */
    @Override
    public void saveAtCellAndTimestep(final Cell cell, final PandoraTimestep pandoraTimestep, final LocalDateTime tEnd,
            final double[] yEnd) {
        double[] upstreamSources = transportCalculationService.calculateTransport(yEnd, pandoraTimestep);
        map.put(hashCellAndTime(cell, tEnd), upstreamSources);
    }
}
