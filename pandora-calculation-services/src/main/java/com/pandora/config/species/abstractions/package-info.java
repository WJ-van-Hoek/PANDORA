/**
 * The {@code com.pandora.config.species.abstractions} package contains abstractions for representing biogeochemical
 * species in a freshwater context. These abstractions define common characteristics and behaviors shared among
 * different types of species, including aqueous and sedimentary species.
 * <p>
 * The package includes the following classes and interfaces:
 * <ul>
 * <li>{@link com.pandora.config.species.abstractions.SpecieConfiguration SpecieConfiguration}: An interface providing
 * methods to retrieve configuration parameters for a biogeochemical species.</li>
 * <li>{@link com.pandora.config.species.abstractions.SpecieLogic SpecieLogic}: An interface defining the logic for
 * calculating the transport of a biogeochemical species based on given parameters such as amount and discharge.</li>
 * <li>{@link com.pandora.config.species.abstractions.Specie Specie}: An abstract class that serves as the base for
 * biogeochemical species, implementing both {@link com.pandora.config.species.abstractions.SpecieConfiguration
 * SpecieConfiguration} and {@link com.pandora.config.species.abstractions.SpecieLogic SpecieLogic} interfaces.</li>
 * <li>{@link com.pandora.config.species.abstractions.AqueousSpecie AqueousSpecie}: An abstract class extending
 * {@link com.pandora.config.species.abstractions.Specie Specie} and providing a specific implementation of the
 * {@code calculateTransport} method for aqueous species.</li>
 * <li>{@link com.pandora.config.species.abstractions.SedimentarySpecie SedimentarySpecie}: An abstract class extending
 * {@link com.pandora.config.species.abstractions.Specie Specie} and providing a specific implementation of the
 * {@code calculateTransport} method for sedimentary species.</li>
 * </ul>
 * <p>
 * Developers extending or implementing these abstractions should refer to the documentation of individual classes and
 * interfaces for detailed information on their purposes and methods.
 *
 */
package com.pandora.config.species.abstractions;
