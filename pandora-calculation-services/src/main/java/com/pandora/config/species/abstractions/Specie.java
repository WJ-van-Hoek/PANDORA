package com.pandora.config.species.abstractions;

import com.pandora.config.Variable;

/**
 * The {@code Specie} abstract class extends the {@link Variable} class and implements both the
 * {@link SpecieConfiguration} and {@link SpecieLogic} interfaces. It serves as a base class for concrete
 * implementations of biogeochemical species, providing a common structure for species configuration, logic, and
 * variable behavior.
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 * @see Variable
 * @see SpecieConfiguration
 * @see SpecieLogic
 */
public abstract class Specie extends Variable implements SpecieConfiguration, SpecieLogic {

}
