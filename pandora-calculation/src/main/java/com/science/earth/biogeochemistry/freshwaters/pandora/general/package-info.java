/**
 * This package contains classes and interfaces related to general particle and sediment properties in the context of
 * freshwater biogeochemistry studies. The components here are designed to model and analyze various aspects of particle
 * behavior and sediment dynamics in fluid environments.
 * <p>
 * The package includes the following components:
 * <ul>
 * <li>{@link com.science.earth.biogeochemistry.freshwaters.pandora.general.Particle}: An interface defining methods for
 * obtaining properties of individual particles, such as radius and density.</li>
 * <li>{@link com.science.earth.biogeochemistry.freshwaters.pandora.general.ParticulateSpecieBean}: An abstract class
 * implementing the {@link com.science.earth.biogeochemistry.freshwaters.pandora.general.Particle} interface, providing
 * properties and methods related to particle deposition rate based on Stokes' law.</li>
 * <li>{@link com.science.earth.biogeochemistry.freshwaters.pandora.general.Sediment}: An interface defining methods for
 * obtaining properties of sediment particles, including radius, density, and characteristics relevant to sediment
 * transport.</li>
 * <li>{@link com.science.earth.biogeochemistry.freshwaters.pandora.general.SedimentSpecieBean}: An abstract class
 * implementing the {@link com.science.earth.biogeochemistry.freshwaters.pandora.general.Sediment} interface, providing
 * properties and methods for calculating the erosion rate of sediment based on shear stress.</li>
 * </ul>
 * The components in this package are intended to be used as building blocks for more specific implementations in the
 * field of freshwater biogeochemistry research.
 * </p>
 *
 * <p>
 * Additionally, the classes in this package utilize configuration properties defined in the
 * "physics-constraints.properties" file located on the classpath, providing flexibility and configurability for various
 * physical constants and parameters used in the calculations.
 * </p>
 *
 */
package com.science.earth.biogeochemistry.freshwaters.pandora.general;
