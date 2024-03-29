package com.pandora.general.objects;

import lombok.Builder;
import lombok.Getter;

/**
 * The {@code Cell} class extends {@link AbstractBaseObject} and represents a geographical cell with a unique
 * identifier, name, and additional properties such as center latitude, center longitude, surface area, and the
 * identifier of the next cell in the sequence.
 * <p>
 * This class uses the Lombok library annotations {@link Getter} and {@link Builder} to automatically generate getter
 * methods and a builder.
 * </p>
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 * @see AbstractBaseObject
 * @see Getter
 * @see Builder
 */
@Getter
public class Cell extends AbstractBaseObject {

    /**
     * The latitude coordinate of the center of the cell.
     */
    private Float centerLatitude;

    /**
     * The longitude coordinate of the center of the cell.
     */
    private Float centerLongitude;

    /**
     * The surface area of the cell.
     */
    private Float surfaceArea;

    /**
     * The identifier of the next cell in the sequence.
     */
    private Long nextCellId;

    /**
     * Constructs a new {@code Cell} object using the provided builder.
     *
     * @param id The unique identifier for the cell.
     * @param name The name associated with the cell.
     * @param centerLatitudeParam The latitude coordinate of the center of the cell.
     * @param centerLongitudeParam The longitude coordinate of the center of the cell.
     * @param surfaceAreaParam The surface area of the cell.
     * @param nextCellIdParam The identifier of the next cell in the sequence.
     */
    @Builder
    public Cell(final Long id, final String name, final Float centerLatitudeParam, final Float centerLongitudeParam,
            final Float surfaceAreaParam, final Long nextCellIdParam) {
        super(id, name);
        this.centerLatitude = centerLatitudeParam;
        this.centerLongitude = centerLongitudeParam;
        this.surfaceArea = surfaceAreaParam;
        this.nextCellId = nextCellIdParam;
    }
}
