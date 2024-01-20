/**
 * Provides abstract classes for services related to biogeochemistry and freshwaters in PANDORA. These
 * classes define abstractions for handling CRUD (Create, Read, Update, Delete) operations on objects within a map-based
 * context, as well as generating hash codes for entities based on specific properties.
 *
 * <p>
 * The package includes the following classes:
 * </p>
 * <ul>
 * <li>{@link com.pandora.general.objects.services.abstractions.classes.AbstractMapCrudService AbstractMapCrudService}:
 * <p>
 * An abstract class implementing CRUD operations using a map-based storage.</li>
 * <li>{@link com.pandora.general.objects.services.abstractions.classes.AbstractHashMapService AbstractHashMapService}:
 * <p>
 * An abstract class providing a method for generating hash codes based on a {@code Cell} and
 * {@code LocalDateTime}.</li>
 * </ul>
 *
 * <p>
 * These abstractions are designed to be extended and implemented in specific contexts within PANDORA for
 * managing and manipulating data related to biogeochemistry in freshwater environments.
 * </p>
 *
 */
package com.pandora.general.objects.services.abstractions.classes;
