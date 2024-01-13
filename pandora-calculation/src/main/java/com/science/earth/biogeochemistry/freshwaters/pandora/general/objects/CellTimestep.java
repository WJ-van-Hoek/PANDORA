package com.science.earth.biogeochemistry.freshwaters.pandora.general.objects;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

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
