package com.pandora.general.objects;

import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * The {@code River} class extends {@link AbstractBaseObject} and represents a river entity characterized by a unique
 * identifier, name, and a list of independent cell sets associated with the river.
 * <p>
 * This class uses the Lombok library annotations {@link Getter}, {@link Setter}, {@link AllArgsConstructor}, and
 * {@link Builder} to automatically generate getter and setter methods, an all-args constructor, and a builder.
 * </p>
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 * @see AbstractBaseObject
 * @see Getter
 * @see Setter
 * @see AllArgsConstructor
 * @see Builder
 */
@Setter
@Getter
@AllArgsConstructor
@Builder
public class River extends AbstractBaseObject {
    /** The list of independent cell sets associated with the river. */
    private List<Set<Cell>> independentCellSets;
}
