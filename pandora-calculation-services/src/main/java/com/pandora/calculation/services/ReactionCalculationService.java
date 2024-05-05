package com.pandora.calculation.services;

/**
 * An interface representing a service for calculating reactions based on an array of values.
 */
public interface ReactionCalculationService {

    /**
     * Calculates reactions based on the provided array of values.
     *
     * @param y The array of values representing the state of the system.
     * @return An array of reactions calculated based on the input values.
     */
    double[] calculateReactions(double[] y);
}
