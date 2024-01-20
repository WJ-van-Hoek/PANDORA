package com.pandora.config.species.abstractions;

/**
 * The {@code SedimentarySpecie} abstract class extends the {@link Specie} class and provides a concrete implementation
 * of the {@link SpecieLogic} interface by overriding the {@link #calculateTransport(double, double)} method. It serves
 * as a base class for biogeochemical species with sedimentary behavior, providing a default transport calculation.
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 * @see Specie
 * @see SpecieLogic
 */
public abstract class SedimentarySpecie extends Specie {
    @Override
    public final double calculateTransport(final double amount, final double discharge) {
        return 0d;
    }
}
