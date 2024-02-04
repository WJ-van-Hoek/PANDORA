package com.pandora.calculation.logic;

/**
 * The {@code VariableLogic} interface represents the logic associated with variables in the PANDORA calculation.
 * Implementations of this interface provide methods for performing operations and computations related to variables.
 *
 * @author Wim Joost van Hoek
 * @version 0.0.1
 * @since 0.0.1
 */
public interface VariableLogic {
    /**
     * Calculates the change in the variable based on the implemented logic.
     *
     * @return The change in the variable as a double value.
     */
    double calculateChange();
}
