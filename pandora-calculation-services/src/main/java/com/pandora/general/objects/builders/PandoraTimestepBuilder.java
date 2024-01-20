package com.pandora.general.objects.builders;

import com.pandora.general.objects.PandoraTimestep;

import lombok.Getter;

/**
 * The {@code PandoraTimestepBuilder} class is a builder for creating instances of {@link PandoraTimestep}. It provides
 * methods to set various parameters such as initial values, time step duration, dimensionality, discharge, volume, and
 * arrays of terrestrial and upstream sources. It follows the builder pattern, allowing for a flexible and readable way
 * to construct instances of {@code PandoraTimestep}.
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 */
@Getter
public class PandoraTimestepBuilder {
    /** The initial values for the simulation. */
    private double[] y0;

    /** The starting time of the time step. */
    private double t0;

    /** The ending time of the time step. */
    private double tEnd;

    /** The dimensionality of the simulation. */
    private int dimension;

    /** The discharge for the time step. */
    private double discharge;

    /** The volume for the time step. */
    private double volume;

    /** The array of terrestrial sources for the simulation. */
    private double[] terrestrialSources;

    /** The array of upstream sources for the simulation. */
    private double[] upstreamSources;

    /**
     * Sets the initial values for the simulation.
     *
     * @param y0Param The initial values.
     * @return This {@code PandoraTimestepBuilder} instance for method chaining.
     */
    public PandoraTimestepBuilder y0(final double[] y0Param) {
        this.y0 = y0Param;
        return this;
    }

    /**
     * Sets the starting time of the time step.
     *
     * @param t0Param The starting time.
     * @return This {@code PandoraTimestepBuilder} instance for method chaining.
     */
    public PandoraTimestepBuilder t0(final double t0Param) {
        this.t0 = t0Param;
        return this;
    }

    /**
     * Sets the ending time of the time step.
     *
     * @param tEndParam The ending time.
     * @return This {@code PandoraTimestepBuilder} instance for method chaining.
     */
    public PandoraTimestepBuilder tEnd(final double tEndParam) {
        this.tEnd = tEndParam;
        return this;
    }

    /**
     * Sets the dimensionality of the simulation.
     *
     * @param dimensionParam The dimensionality.
     * @return This {@code PandoraTimestepBuilder} instance for method chaining.
     */
    public PandoraTimestepBuilder dimension(final int dimensionParam) {
        this.dimension = dimensionParam;
        return this;
    }

    /**
     * Sets the discharge for the time step.
     *
     * @param dischargeParam The discharge value.
     * @return This {@code PandoraTimestepBuilder} instance for method chaining.
     */
    public PandoraTimestepBuilder discharge(final double dischargeParam) {
        this.discharge = dischargeParam;
        return this;
    }

    /**
     * Sets the volume for the time step.
     *
     * @param volumeParam The volume value.
     * @return This {@code PandoraTimestepBuilder} instance for method chaining.
     */
    public PandoraTimestepBuilder volume(final double volumeParam) {
        this.volume = volumeParam;
        return this;
    }

    /**
     * Sets the array of terrestrial sources for the simulation.
     *
     * @param terrestrialSourcesParam The array of terrestrial sources.
     * @return This {@code Builder} instance for method chaining.
     */
    public PandoraTimestepBuilder terrestrialSources(final double[] terrestrialSourcesParam) {
        this.terrestrialSources = terrestrialSourcesParam;
        return this;
    }

    /**
     * Sets the array of upstream sources for the simulation.
     *
     * @param upstreamSourcesParam The array of upstream sources.
     * @return This {@code PandoraTimestepBuilder} instance for method chaining.
     */
    public PandoraTimestepBuilder upstreamSources(final double[] upstreamSourcesParam) {
        this.upstreamSources = upstreamSourcesParam;
        return this;
    }

    /**
     * Constructs and returns an instance of {@code PandoraTimestep} with the configured parameters.
     *
     * @return An instance of {@code PandoraTimestep}.
     */
    public PandoraTimestep build() {
        return new PandoraTimestep(this);
    }
}
