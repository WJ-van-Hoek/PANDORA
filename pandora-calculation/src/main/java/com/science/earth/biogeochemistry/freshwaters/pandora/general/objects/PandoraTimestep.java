package com.science.earth.biogeochemistry.freshwaters.pandora.general.objects;

import java.util.Objects;

import lombok.Builder;

public class PandoraTimestep {

    private double[] y0;
    private double t0;
    private double tEnd;
    private int dimension;
    private double discharge;
    private double volume;
    private double[] terrestrialSources;
    private double[] upstreamSources;

    @Builder
    public PandoraTimestep(double[] y0, double t0, double tEnd, int dimension, double discharge, double volume, double[] terrestrialSources,
	    double[] upstreamSources) {
	this.y0 = y0;
	this.t0 = t0;
	this.tEnd = tEnd;
	this.dimension = dimension;
	this.discharge = discharge;
	this.volume = volume;
	this.terrestrialSources = terrestrialSources;
	this.upstreamSources = upstreamSources;
    }

    public double[] getY0() {
	return this.y0;
    }

    public double getT0() {
	return this.t0;
    }

    public double getTEnd() {
	return this.tEnd;
    }

    public int getDimension() {
	return this.dimension;
    }

    public double getDischarge() {
	return this.discharge;
    }
    
    public double getVolume() {
	return this.volume;
    }
    
    public double getDischargeRate() {
	return this.volume == 0 ? 0 : this.discharge/this.volume;
    }
    
    public double getTerrestrialSources(int index) {
	return this.terrestrialSources[index];
    }

    public double getUpstreamSources(int index) {
	return this.upstreamSources[index];
    }

    public double[] getTerrestrialSources() {
	return this.terrestrialSources;
    }

    public double[] getUpstreamSources() {
	return this.upstreamSources;
    }

    @Override
    public boolean equals(Object obj) {
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

    @Override
    public int hashCode() {
	return Objects.hash(y0, t0, tEnd, dimension, discharge, terrestrialSources, upstreamSources);
    }
}
