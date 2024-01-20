package com.pandora.general.services.calculation.interfaces;

/**
 * The {@code ReactionCalculationService} interface defines a method for calculating reactions in the Pandora model
 * based on the current state variables. Implementing classes are responsible for calculating the reaction rates
 * corresponding to the given state variables.
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 */
public interface ReactionCalculationService {
    /**
     * Calculates the reactions based on the current state variables.
     *
     * @param y The array of state variables representing the current state of the Pandora model.
     * @return The array of reaction rates corresponding to the given state variables.
     */
    double[] calculateReactions(double[] y);
}
