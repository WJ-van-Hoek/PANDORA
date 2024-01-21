package com.pandora.general.objects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * The {@code AbstractBaseObject} is an abstract class providing a base structure for objects with a unique identifier
 * ({@code id}) and a name. It includes standard getter and setter methods for accessing and modifying the identifier
 * and name.
 * <p>
 * This class uses the Lombok library annotations {@link Getter}, {@link Setter}, {@link NoArgsConstructor}, and
 * {@link SuperBuilder} to automatically generate getter and setter methods, a no-args constructor, and a builder.
 * </p>
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 * @see Getter
 * @see Setter
 * @see NoArgsConstructor
 * @see SuperBuilder
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public abstract class AbstractBaseObject {
    /**
     * The unique identifier for this object.
     */
    private Long id;

    /**
     * The name associated with this object.
     */
    private String name;

    /**
     * Constructs a new {@code AbstractBaseObject} with the specified identifier and name.
     *
     * @param idParam The unique identifier for the object.
     * @param nameParam The name associated with the object.
     */
    protected AbstractBaseObject(final Long idParam, final String nameParam) {
        this.id = idParam;
        this.name = nameParam;
    }
}
