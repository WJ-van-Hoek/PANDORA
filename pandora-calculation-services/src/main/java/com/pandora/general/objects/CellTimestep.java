package com.pandora.general.objects;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * The {@code CellTimestep} class extends {@link AbstractBaseObject} and represents a specific time step associated with
 * a geographical cell. It includes properties such as the initial and final state variable values, start and end times,
 * and the geographical cell itself.
 * <p>
 * This class uses the Lombok library annotations {@link Getter}, {@link Builder}, and {@link AllArgsConstructor} to
 * automatically generate getter methods, a builder, and an all-args constructor.
 * </p>
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 * @see AbstractBaseObject
 * @see Getter
 * @see Builder
 * @see AllArgsConstructor
 */
@Getter
@AllArgsConstructor
public class CellTimestep extends AbstractBaseObject {

    /**
     * The geographical cell associated with this time step.
     */
    private Cell cell;

    /**
     * The initial state variable values at the beginning of the time step.
     */
    private double[] y0;

    /**
     * The time at the start of the time step.
     */
    private LocalDateTime t0;

    /**
     * The time at the end of the time step.
     */
    private LocalDateTime tEnd;

    /**
     * The final state variable values at the end of the time step.
     */
    private double[] yEnd;

    /**
     * Constructs a new {@code CellTimestep} object using the provided builder.
     *
     * @param cellParam The geographical cell associated with the time step.
     * @param y0Param The initial state variable values at the beginning of the time step.
     * @param t0Param The time at the start of the time step.
     * @param tEndParam The time at the end of the time step.
     */
    @Builder
    public CellTimestep(final Cell cellParam, final double[] y0Param, final LocalDateTime t0Param,
            final LocalDateTime tEndParam) {
        this.cell = cellParam;
        this.y0 = y0Param;
        this.t0 = t0Param;
        this.tEnd = tEndParam;
    }

    /**
     * Sets the final state variable values at the end of the time step.
     *
     * @param yEndParam The final state variable values to be set.
     */
    public void setYEnd(final double[] yEndParam) {
        this.yEnd = yEndParam;
    }
}
