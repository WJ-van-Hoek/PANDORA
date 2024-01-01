/**
 * The
 * {@code com.science.earth.biogeochemistry.freshwaters.pandora.config.species.abstractions}
 * package contains abstractions for representing biogeochemical species in a
 * freshwater context. These abstractions define common characteristics and
 * behaviors shared among different types of species, including aqueous and
 * sedimentary species.
 * <p>
 * The package includes the following classes and interfaces:
 * <ul>
 * <li>{@link Specie}: An abstract class that serves as the base for
 * biogeochemical species, implementing both {@link SpecieConfiguration} and
 * {@link SpecieLogic} interfaces.</li>
 * <li>{@link SpecieConfiguration}: An interface providing methods to retrieve
 * configuration parameters for a biogeochemical species, including the molar
 * mass.</li>
 * <li>{@link SpecieLogic}: An interface defining the logic for calculating the
 * transport of a biogeochemical species based on given parameters such as
 * amount and discharge.</li>
 * <li>{@link AqueousSpecie}: An abstract class extending {@link Specie} and
 * providing a specific implementation of the {@code calculateTransport} method
 * for aqueous species.</li>
 * <li>{@link SedimentarySpecie}: An abstract class extending {@link Specie} and
 * providing a specific implementation of the {@code calculateTransport} method
 * for sedimentary species.</li>
 * </ul>
 * <p>
 * Developers extending or implementing these abstractions should refer to the
 * documentation of individual classes and interfaces for detailed information
 * on their purposes and methods.
 *
 * @see Specie
 * @see SpecieConfiguration
 * @see SpecieLogic
 * @see AqueousSpecie
 * @see SedimentarySpecie
 */
package com.science.earth.biogeochemistry.freshwaters.pandora.config.species.abstractions;
