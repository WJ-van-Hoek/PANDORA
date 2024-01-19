package com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.interfaces;

import java.time.LocalDateTime;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.Cell;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.PandoraTimestep;

public interface UpstreamSourcesMapService extends MapService {

    /**
     * Finds the upstream sources data associated with the specified {@link Cell} and {@link LocalDateTime}.
     *
     * @param cell The {@code Cell} object representing a specific location.
     * @param t The {@code LocalDateTime} object representing a specific time.
     * @return An array of double values representing upstream sources data at the given {@code Cell} and
     * {@code LocalDateTime}, or {@code null} if not found.
     */
    double[] findAtCellAndTimestep(Cell cell, LocalDateTime t);

    /**
     * Saves the upstream sources data associated with the specified {@link Cell} and {@link LocalDateTime}.
     *
     * @param cell The {@code Cell} object representing a specific location.
     * @param t The {@code LocalDateTime} object representing a specific time.
     * @param data An array of double values representing upstream sources data to be saved.
     */
    void saveAtCellAndTimestep(Cell cell, LocalDateTime t, double[] data);

    /**
     * Saves the upstream sources data associated with the specified {@link Cell}, {@link PandoraTimestep},
     * {@link LocalDateTime}, and final state values.
     *
     * @param cell The {@code Cell} object representing a specific location.
     * @param pandoraTimestep The {@code PandoraTimestep} object representing a specific time step.
     * @param tEnd The {@code LocalDateTime} object representing the end time.
     * @param yEnd An array of double values representing the final state values.
     */
    void saveAtCellAndTimestep(Cell cell, PandoraTimestep pandoraTimestep, LocalDateTime tEnd, double[] yEnd);
}
