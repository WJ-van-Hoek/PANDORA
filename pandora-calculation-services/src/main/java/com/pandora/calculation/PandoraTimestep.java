package com.pandora.calculation;

import java.util.Objects;

import lombok.Builder;

/**
 * The {@code PandoraTimestep} class represents a specific time step in the Pandora model, characterized by initial
 * values, start and end times, dimensionality, discharge, volume, terrestrial and upstream sources, and other
 * properties.
 * <p>
 * This class includes a builder method ({@link #builder()}) for constructing instances using the Builder pattern.
 * </p>
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 * @see PandoraTimestepBuilder
 */
public class PandoraTimestep {

    /** The initial values for the simulation. */
    private double[] _y0;

    /** The starting time of the time step. */
    private double _t0;

    /** The ending time of the time step. */
    private double _tEnd;

    /** The dimensionality of the simulation. */
    private int _dimension;

    /** The discharge for the time step. */
    private double _discharge;

    /** The volume for the time step. */
    private double _volume;

    /** The array of terrestrial sources for the simulation. */
    private double[] _terrestrialSources;

    /** The array of upstream sources for the simulation. */
    private double[] _upstreamSources;

    /**
     * Builder for constructing PandoraTimestep objects.
     *
     * @param y0 The initial concentrations.
     * @param t0 The initial time.
     * @param tEnd The end time.
     * @param dimension The dimension.
     * @param discharge The discharge.
     * @param volume The volume.
     * @param terrestrialSources The terrestrial sources.
     * @param upstreamSources The upstream sources.
     */
    @Builder
    public PandoraTimestep(final double[] y0, final double t0, final double tEnd, final int dimension,
            final double discharge, final double volume, final double[] terrestrialSources,
            final double[] upstreamSources) {
        _y0 = y0;
        _t0 = t0;
        _tEnd = tEnd;
        _dimension = dimension;
        _discharge = discharge;
        _volume = volume;
        _terrestrialSources = terrestrialSources;
        _upstreamSources = upstreamSources;
    }

    /**
     * Gets the initial values for the simulation.
     *
     * @return The initial values.
     */
    public double[] getY0() {
        return _y0;
    }

    /**
     * Gets the starting time of the time step.
     *
     * @return The starting time.
     */
    public double getT0() {
        return _t0;
    }

    /**
     * Gets the ending time of the time step.
     *
     * @return The ending time.
     */
    public double getTEnd() {
        return _tEnd;
    }

    /**
     * Gets the dimensionality of the simulation.
     *
     * @return The dimensionality.
     */
    public int getDimension() {
        return _dimension;
    }

    /**
     * Gets the discharge for the time step.
     *
     * @return The discharge value.
     */
    public double getDischarge() {
        return _discharge;
    }

    /**
     * Gets the volume for the time step.
     *
     * @return The volume value.
     */
    public double getVolume() {
        return _volume;
    }

    /**
     * Calculates and gets the discharge rate for the current time step. The discharge rate is computed as the ratio of
     * discharge to volume.
     *
     * @return The discharge rate for the current time step.
     */
    public double getDischargeRate() {
        return _volume == 0 ? 0 : _discharge / _volume;
    }

    /**
     * Gets the value of a terrestrial source at the specified index.
     *
     * @param index The index of the terrestrial source.
     * @return The value of the terrestrial source at the specified index.
     */
    public double getTerrestrialSources(final int index) {
        return _terrestrialSources[index];
    }

    /**
     * Gets the value of an upstream source at the specified index.
     *
     * @param index The index of the upstream source.
     * @return The value of the upstream source at the specified index.
     */
    public double getUpstreamSources(final int index) {
        return _upstreamSources[index];
    }

    /**
     * Gets the array of terrestrial sources for the simulation.
     *
     * @return The array of terrestrial sources.
     */
    public double[] getTerrestrialSources() {
        return _terrestrialSources;
    }

    /**
     * Gets the array of upstream sources for the simulation.
     *
     * @return The array of upstream sources.
     */
    public double[] getUpstreamSources() {
        return _upstreamSources;
    }

    /**
     * Compares this {@code PandoraTimestep} with another object for equality.
     *
     * @param obj The object to compare.
     * @return {@code true} if the objects are equal, {@code false} otherwise.
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        PandoraTimestep other = (PandoraTimestep) obj;
        return Objects.equals(this.getY0(), other.getY0()) && Objects.equals(this.getT0(), other.getT0())
                && Objects.equals(this.getTEnd(), other.getTEnd())
                && Objects.equals(this.getDimension(), other.getDimension())
                && Objects.equals(this.getDischarge(), other.getDischarge())
                && Objects.equals(this.getTerrestrialSources(), other.getTerrestrialSources())
                && Objects.equals(this.getUpstreamSources(), other.getUpstreamSources());
    }

    /**
     * Generates a hash code for this {@code PandoraTimestep} instance.
     *
     * @return The hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(_y0, _t0, _tEnd, _dimension, _discharge, _terrestrialSources, _upstreamSources);
    }
}
