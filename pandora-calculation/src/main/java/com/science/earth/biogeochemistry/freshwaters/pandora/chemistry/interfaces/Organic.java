package com.science.earth.biogeochemistry.freshwaters.pandora.chemistry.interfaces;

public interface Organic {
    /**
     * The {@code Organic} interface represents an organic chemical entity in PANDORA chemistry, and it defines a method
     * to retrieve the oxidation rate associated with this organic species.
     * <p>
     * Organic species may undergo oxidation processes, and the {@code getOxidationRate()} method allows querying the
     * specific oxidation rate for a particular organic entity.
     * <p>
     * Implementing classes should provide a meaningful implementation of this method, returning the oxidation rate as a
     * {@code double} value.
     * <p>
     * Example usage:
     *
     * <pre>
     * {@code
     * Assuming 'organicSpecies' is an instance of a class implementing Organic
     * double oxidationRate = organicSpecies.getOxidationRate();
     * }
     * </pre>
     *
     * @return The oxidation rate associated with the organic chemical entity.
     */
    double getOxidationRate();
}
