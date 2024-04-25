package com.pandora.calculation;

import com.pandora.calculation.data.FixCellDataPoint;

import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * Represents a timestep in the simulation for a specific cell.
 * <p>
 * Each timestep contains information about the cell, the initial and final time, as well as the initial and final state
 * variables ({@code y0} and {@code yEnd}).
 * </p>
 * <p>
 * This class provides getters for accessing the properties of a timestep and a builder for constructing instances of
 * {@code CellTimestep}.
 * </p>
 * <p>
 * Instances of this class are immutable once constructed.
 * </p>
 *
 * @author Wim Joost van Hoek
 * @since 0.0.1
 */
@AllArgsConstructor
public final class CellTimestep {

    /** The cell associated with this timestep. */
    private final FixCellDataPoint _cell;

    /** The initial state variables of the cell. */
    private final double[] _y0;

    /** The final state variables of the cell. */
    private double[] _yEnd;

    /**
     * Constructs a new CellTimestep object with the specified cell and initial state variables.
     *
     * @param cell The cell associated with this timestep.
     * @param y0 The initial state variables of the cell.
     */
    @Builder
    public CellTimestep(final FixCellDataPoint cell, final double[] y0) {
        _cell = cell;
        _y0 = y0;
    }

    /**
     * Sets the final state variables of the cell.
     *
     * @param yEnd The final state variables of the cell.
     */
    public void setYEnd(final double[] yEnd) {
        _yEnd = yEnd;
    }

    /**
     * Retrieves the final concentrations.
     *
     * @return An array containing the final concentrations.
     */
    public double[] getYEnd() {
        return _yEnd;
    }

    /**
     * Retrieves the cell data point.
     *
     * @return The cell data point.
     */
    public FixCellDataPoint getCell() {
        return _cell;
    }

    /**
     * Retrieves the initial concentrations.
     *
     * @return An array containing the initial concentrations.
     */
    public double[] getY0() {
        return _y0;
    }

}
