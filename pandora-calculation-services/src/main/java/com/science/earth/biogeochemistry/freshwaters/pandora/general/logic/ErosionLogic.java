package com.science.earth.biogeochemistry.freshwaters.pandora.general.logic;

public interface ErosionLogic {
    /**
     * Calculates the sediment transport coefficient using the given erosion-related parameters.
     *
     * @param alpha The erosion coefficient.
     * @param r     The sediment concentration.
     * @return The calculated sediment transport coefficient.
     */
    double calculateSedimentTransportCoefficient(double alpha, double r);
}
