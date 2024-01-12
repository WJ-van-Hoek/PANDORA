package com.science.earth.biogeochemistry.freshwaters.pandora.general.objects;

import java.util.Objects;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.builders.PandoraTimestepBuilder;

public class PandoraTimestep {

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
     * Returns a new instance of {@code PandoraTimestepBuilder} to facilitate the construction of
     * {@code PandoraTimestep} instances using the Builder pattern.
     * <p>
     * Example usage:
     *
     * <pre>{@code
     * PandoraTimestep timestep = PandoraTimestep.builder().y0(initialValues).t0(startTime).tEnd(endTime)
     *         .dimension(simulationDimension).discharge(dischargeValue).volume(volumeValue)
     *         .terrestrialSources(terrestrialSourcesArray).upstreamSources(upstreamSourcesArray).build();
     * }</pre>
     * </p>
     *
     * @return A new instance of {@code PandoraTimestepBuilder}.
     */
    public static PandoraTimestepBuilder builder() {
        return new PandoraTimestepBuilder();
    }

    /**
     * Constructor for building instances using the Builder pattern.
     *
     * @param builder The {@code PandoraTimestepBuilder} instance used to construct this {@code PandoraTimestep}.
     */
    public PandoraTimestep(final PandoraTimestepBuilder builder) {
        this.y0 = builder.getY0();
        this.t0 = builder.getT0();
        this.tEnd = builder.getTEnd();
        this.dimension = builder.getDimension();
        this.discharge = builder.getDischarge();
        this.volume = builder.getVolume();
        this.terrestrialSources = builder.getTerrestrialSources();
        this.upstreamSources = builder.getUpstreamSources();
    }

    /**
     * Gets the initial values for the simulation.
     *
     * @return The initial values.
     */
    public double[] getY0() {
        return this.y0;
    }

    /**
     * Gets the starting time of the time step.
     *
     * @return The starting time.
     */
    public double getT0() {
        return this.t0;
    }

    /**
     * Gets the ending time of the time step.
     *
     * @return The ending time.
     */
    public double getTEnd() {
        return this.tEnd;
    }

    /**
     * Gets the dimensionality of the simulation.
     *
     * @return The dimensionality.
     */
    public int getDimension() {
        return this.dimension;
    }

    /**
     * Gets the discharge for the time step.
     *
     * @return The discharge value.
     */
    public double getDischarge() {
        return this.discharge;
    }

    /**
     * Gets the volume for the time step.
     *
     * @return The volume value.
     */
    public double getVolume() {
        return this.volume;
    }

    /**
     * Calculates and gets the discharge rate for the current time step. The discharge rate is computed as the ratio of
     * discharge to volume.
     *
     * @return The discharge rate for the current time step.
     */
    public double getDischargeRate() {
        return this.volume == 0 ? 0 : this.discharge / this.volume;
    }

    /**
     * Gets the value of a terrestrial source at the specified index.
     *
     * @param index The index of the terrestrial source.
     * @return The value of the terrestrial source at the specified index.
     */
    public double getTerrestrialSources(final int index) {
        return this.terrestrialSources[index];
    }

    /**
     * Gets the value of an upstream source at the specified index.
     *
     * @param index The index of the upstream source.
     * @return The value of the upstream source at the specified index.
     */
    public double getUpstreamSources(final int index) {
        return this.upstreamSources[index];
    }

    /**
     * Gets the array of terrestrial sources for the simulation.
     *
     * @return The array of terrestrial sources.
     */
    public double[] getTerrestrialSources() {
        return this.terrestrialSources;
    }

    /**
     * Gets the array of upstream sources for the simulation.
     *
     * @return The array of upstream sources.
     */
    public double[] getUpstreamSources() {
        return this.upstreamSources;
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
        return Objects.hash(y0, t0, tEnd, dimension, discharge, terrestrialSources, upstreamSources);
    }
}
