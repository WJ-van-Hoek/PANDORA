package com.science.earth.biogeochemistry.freshwaters.pandora.general;

import lombok.Builder;

public class PandoraTimestepImpl implements PandoraTimestep {

    private double[] y0;
    private double t0;
    private double tEnd;
    private int dimension;
    private double[] terrestrialSources;
    private double[] upstreamSources;

    @Builder
    public PandoraTimestepImpl(double[] y0, double t0, double tEnd, int dimension, double[] terrestrialSources,
	    double[] upstreamSources) {
	this.y0 = y0;
	this.t0 = t0;
	this.tEnd= tEnd;
	this.dimension = dimension;
	this.terrestrialSources = terrestrialSources;
	this.upstreamSources = upstreamSources;
    }

    @Override
    public double[] getY0() {
	return this.y0;
    }

    @Override
    public double getT0() {
	return this.t0;
    }

    @Override
    public double getTEnd() {
	return this.tEnd;
    }

    @Override
    public int getDimension() {
	return this.dimension;
    }

    @Override
    public double getTerrestrialSources(int index) {
	return this.terrestrialSources[index];
    }

    @Override
    public double getUpstreamSources(int index) {
	return this.upstreamSources[index];
    }

}
