package com.pandora.calculation.services;

import java.time.LocalDateTime;

/**
 * Interface for calculating upstream inputs.
 */
public interface UpstreamInputCalculationService {

    /**
     * Calculates the upstream inputs for the specified local date and time and cell ID.
     *
     * @param localDateTime The local date and time.
     * @param cellId        The cell ID.
     * @return An array containing the calculated upstream inputs.
     */
    double[] calculate(LocalDateTime localDateTime, long cellId);
}
