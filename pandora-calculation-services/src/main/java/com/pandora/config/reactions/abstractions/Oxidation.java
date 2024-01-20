package com.pandora.config.reactions.abstractions;

import org.springframework.beans.factory.annotation.Autowired;

import com.pandora.chemistry.interfaces.Organic;

/**
 * The {@code Oxidation} class represents an abstract implementation of the {@link OxidationConfiguration} interface,
 * providing common functionality for configuring oxidation reactions in freshwater systems.
 * <p>
 * This class extends the {@link Reaction} class and introduces a generic type parameter {@code T} representing the
 * specific organic chemical entity involved in the oxidation reaction. The {@code organicCompound} field is autowired
 * to a bean of type {@code T}, ensuring that the oxidation rate can be calculated based on the specific implementation
 * of the {@link Organic#getOxidationRate()} method in the associated organic compound.
 *
 * @param <T> The type representing the organic chemical entity, extending the
 * {@link com.pandora.chemistry.interfaces.Organic Organic} interface.
 * @version 0.0.1
 * @author Wim Joost van Hoek
 * @see Reaction
 * @see OxidationConfiguration
 * @see Organic
 */
public abstract class Oxidation<T extends Organic> extends Reaction implements OxidationConfiguration {

    /**
     * The {@code organicCompound} field in the {@link Oxidation} class represents the organic chemical entity involved
     * in the oxidation reaction. It is autowired to a bean of type {@code T}, where {@code T} extends the
     * {@link com.pandora.chemistry.interfaces.Organic Organic} interface.
     * <p>
     * This field is essential for calculating the rate of oxidation in the associated reaction. The {@code getRate}
     * method, which calculates the oxidation rate, relies on this field to retrieve the specific oxidation rate
     * associated with the {@code organicCompound}.
     * <p>
     */
    @Autowired
    private T organicCompound;

    /**
     * Calculates and returns the rate of oxidation for the associated {@code organicCompound}. This method is
     * overridden from the {@link Reaction#getRate(double[])} method and is specific to oxidation reactions.
     * <p>
     * The oxidation rate is determined by invoking the
     * {@link com.pandora.chemistry.interfaces.Organic#getOxidationRate() getOxidationRate()} method on the
     * {@code organicCompound}. It relies on the implementation provided by the class representing the organic chemical
     * entity.
     *
     * @param y An array representing the concentrations of chemical species involved in the reaction.
     * @return The calculated rate of oxidation for the associated {@code organicCompound}.
     * @see Reaction#getRate(double[])
     * @see com.pandora.chemistry.interfaces.Organic#getOxidationRate()
     * @see Organic
     * @see Oxidation
     */
    @Override
    public final double getRate(final double[] y) {
        return organicCompound.getOxidationRate();
    }
}
