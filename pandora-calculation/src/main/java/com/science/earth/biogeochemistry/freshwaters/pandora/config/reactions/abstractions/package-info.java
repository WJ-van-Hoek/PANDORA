/**
 * This package provides abstractions for configuring and modeling chemical reactions in the context of biogeochemistry.
 * The abstractions include base classes and interfaces for oxidation reactions and general reaction configurations.
 * <p>
 * Key components in this package include:
 * <ul>
 * <li>{@link com.science.earth.biogeochemistry.freshwaters.pandora.config .reactions.abstractions.Oxidation Oxidation}
 * - An abstract class representing the concept of oxidation reactions. Subclasses define specific oxidation reactions
 * and provide methods for calculating reaction rates.</li>
 *
 * <li>{@link com.science.earth.biogeochemistry.freshwaters.pandora.config
 * .reactions.abstractions.OxidationConfiguration OxidationConfiguration} - An interface extending
 * {@link com.science.earth.biogeochemistry.freshwaters .pandora.config.reactions.abstractions.ReactionConfiguration
 * ReactionConfiguration}. It serves as a marker interface for classes representing oxidation reaction
 * configurations.</li>
 *
 * <li>{@link com.science.earth.biogeochemistry.freshwaters.pandora.config .reactions.abstractions.Reaction Reaction} -
 * An abstract class providing common functionality for handling produced and removed species in chemical reactions. It
 * also includes methods for initializing species maps from configuration properties.</li>
 *
 * <li>{@link com.science.earth.biogeochemistry.freshwaters.pandora.config .reactions.abstractions.ReactionConfiguration
 * ReactionConfiguration} - An interface defining methods for initializing, accessing produced and removed species, and
 * calculating changes in species concentrations based on reaction rates.</li>
 * </ul>
 * <p>
 * These abstractions aim to facilitate the modeling and configuration of chemical reactions within the biogeochemistry
 * domain. Developers can implement and extend these classes and interfaces to create specific reaction configurations
 * for their biogeochemical simulations.
 */
package com.science.earth.biogeochemistry.freshwaters.pandora.config.reactions.abstractions;
