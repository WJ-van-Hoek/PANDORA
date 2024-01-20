package com.pandora.general.logic;

/**
 * The {@code ErosionLogic} interface defines a method for calculating the sediment transport coefficient based on
 * specified erosion-related parameters. Implementing classes are expected to provide concrete implementations for this
 * calculation.
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 */
public interface ErosionLogic {
    /**
     * Calculates the sediment transport coefficient using the given erosion-related parameters.
     *
     * @param alpha The erosion coefficient.
     * @param r The sediment concentration.
     * @return The calculated sediment transport coefficient.
     */
    double calculateSedimentTransportCoefficient(double alpha, double r);
}
