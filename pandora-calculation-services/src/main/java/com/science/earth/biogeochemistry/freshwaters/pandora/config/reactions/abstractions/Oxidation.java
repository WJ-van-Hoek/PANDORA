package com.science.earth.biogeochemistry.freshwaters.pandora.config.reactions.abstractions;

import org.springframework.beans.factory.annotation.Autowired;

import com.science.earth.biogeochemistry.freshwaters.pandora.chemistry.interfaces.Organic;

public abstract class Oxidation<T extends Organic> extends Reaction implements OxidationConfiguration {

    /**
     * The {@code organicCompound} field in the {@link Oxidation} class represents the organic chemical entity involved
     * in the oxidation reaction. It is autowired to a bean of type {@code T}, where {@code T} extends the
     * {@link com.science.earth.biogeochemistry.freshwaters.pandora.chemistry .interfaces.Organic Organic} interface.
     * <p>
     * This field is essential for calculating the rate of oxidation in the associated reaction. The {@code getRate}
     * method, which calculates the oxidation rate, relies on this field to retrieve the specific oxidation rate
     * associated with the {@code organicCompound}.
     * <p>
     * Developers implementing or extending the {@code Oxidation} class should ensure that a suitable bean of type
     * {@code T} is available in the Spring context during runtime. Additionally, the {@code Organic} interface
     * implemented by {@code T} must provide a concrete implementation for the
     * {@link com.science.earth.biogeochemistry.freshwaters.pandora.chemistry .interfaces.Organic#getOxidationRate()
     * getOxidationRate()} method.
     *
     * @param <T> The type representing the organic chemical entity, extending the
     * {@link com.science.earth.biogeochemistry.freshwaters.pandora .chemistry.interfaces.Organic Organic} interface.
     * @see Oxidation
     * @see Organic
     */
    @Autowired
    private T organicCompound;

    /**
     * Calculates and returns the rate of oxidation for the associated {@code organicCompound}. This method is
     * overridden from the {@link Reaction#getRate(double[])} method and is specific to oxidation reactions.
     * <p>
     * The oxidation rate is determined by invoking the
     * {@link com.science.earth.biogeochemistry.freshwaters.pandora.chemistry .interfaces.Organic#getOxidationRate()
     * getOxidationRate()} method on the {@code organicCompound}. It relies on the implementation provided by the class
     * representing the organic chemical entity.
     * <p>
     * Developers implementing or extending the {@code Oxidation} class should ensure that the associated
     * {@code organicCompound} is properly initialized and provides a meaningful implementation of the
     * {@code getOxidationRate()} method.
     *
     * @param y An array representing the concentrations of chemical species involved in the reaction.
     * @return The calculated rate of oxidation for the associated {@code organicCompound}.
     * @see Reaction#getRate(double[])
     * @see com.science.earth.biogeochemistry.freshwaters.pandora.chemistry.interfaces .Organic#getOxidationRate()
     * @see Organic
     * @see Oxidation
     */
    @Override
    public final double getRate(final double[] y) {
        return organicCompound.getOxidationRate();
    }
}
