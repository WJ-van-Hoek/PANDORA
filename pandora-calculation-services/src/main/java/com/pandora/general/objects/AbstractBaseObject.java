package com.pandora.general.objects;

import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * The {@code AbstractBaseObject} is an abstract class providing a base structure for objects with a unique identifier
 * ({@code id}) and a name. It includes standard getter and setter methods for accessing and modifying the identifier
 * and name.
 * <p>
 * This class uses the Lombok library annotations {@link NoArgsConstructor}, and
 * {@link SuperBuilder} to automatically generate getter and setter methods, a no-args constructor, and a builder.
 * </p>
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 * @see NoArgsConstructor
 * @see SuperBuilder
 */
@NoArgsConstructor
@SuperBuilder
public abstract class AbstractBaseObject {
    /**
     * The unique identifier for this object.
     */
    private Long _id;

    /**
     * The name associated with this object.
     */
    private String _name;

    /**
     * Constructs a new {@code AbstractBaseObject} with the specified identifier and name.
     *
     * @param id The unique identifier for the object.
     * @param name The name associated with the object.
     */
    protected AbstractBaseObject(final Long id, final String name) {
        _id = id;
        _name = name;
    }
}
