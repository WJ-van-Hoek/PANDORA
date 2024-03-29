package com.pandora.general.logic;

import org.springframework.stereotype.Component;

/**
 * The {@code ErosionLogicImpl} class is an implementation of the {@link ErosionLogic} interface, providing a method to
 * calculate the sediment transport coefficient based on specified parameters. It is annotated as a Spring component and
 * serves as a logic component for erosion-related calculations.
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 */
@Component
public class ErosionLogicImpl implements ErosionLogic {
    /**
     * The constant exponent used in the sediment transport coefficient calculation.
     */
    private static final double EXPONENT = -1.5;

    /**
     * {@inheritDoc}
     * <p>
     * This method calculates the sediment transport coefficient using the formula:
     *
     * <pre>
     * coefficient = alpha * Math.pow((r / 2), EXPONENT)
     * </pre>
     *
     * where:
     * <ul>
     * <li>{@code alpha} is a coefficient.</li>
     * <li>{@code r} is a parameter.</li>
     * <li>{@code EXPONENT} is a constant exponent value.</li>
     * </ul>
     *
     * @param alpha the coefficient.
     * @param r the parameter.
     * @return the calculated sediment transport coefficient.
     */
    @Override
    public final double calculateSedimentTransportCoefficient(final double alpha, final double r) {
        return alpha * Math.pow((r / 2), EXPONENT);
    }
}
