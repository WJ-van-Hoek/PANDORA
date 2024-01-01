package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces;

public interface ReactionCalculationService {
    /**
     * Calculates the reactions based on the current state variables.
     *
     * @param y The array of state variables representing the current state of the Pandora model.
     * @return The array of reaction rates corresponding to the given state variables.
     */
    double[] calculateReactions(double[] y);
}
