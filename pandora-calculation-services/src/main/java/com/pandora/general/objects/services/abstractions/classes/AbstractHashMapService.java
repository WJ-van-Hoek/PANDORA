package com.pandora.general.objects.services.abstractions.classes;

import java.time.LocalDateTime;
import java.util.Objects;

import com.pandora.general.objects.Cell;

/**
 * The {@code AbstractHashMapService} is an abstract class providing common functionality for services that utilize a
 * hash map to store data based on the combination of a {@link Cell} and a {@link LocalDateTime}. It includes a method
 * for generating a hash code based on the provided {@code Cell} and {@code LocalDateTime}.
 * <p>
 * This class is intended to be extended by concrete implementations that require hash map functionality.
 * </p>
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 * @see Cell
 * @see LocalDateTime
 * @see Objects#hash(Object...) The method used to generate a hash code by combining the hash codes of the provided
 * objects.
 */
public abstract class AbstractHashMapService {
    /**
     * Generates a hash code based on the provided {@code Cell} and {@code LocalDateTime}.
     *
     * <p>
     * This method utilizes the {@link Objects#hash(Object...)} method to create a hash code by combining the hash codes
     * of the given {@code cell} and {@code t}.
     * </p>
     *
     * <p>
     * The generated hash code is intended for use in hashing and indexing elements within a map or other data
     * structures where the combination of a {@code Cell} and a {@code LocalDateTime} uniquely identifies an entity.
     * </p>
     *
     * @param cell The {@code Cell} object used in the hash code computation.
     * @param t The {@code LocalDateTime} object used in the hash code computation.
     * @return A hash code computed based on the provided {@code cell} and {@code t}.
     *
     * @see Objects#hash(Object...) The method used to generate a hash code by combining the hash codes of the provided
     * objects.
     */
    protected final int hashCellAndTime(final Cell cell, final LocalDateTime t) {
        return Objects.hash(cell, t);
    }
}
