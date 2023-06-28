package com.science.earth.biogeochemistry.freshwaters.pandora.carbon.calculations;

import java.util.List;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.interfaces.PandoraScheme;

public class PandoraCarbonScheme implements PandoraScheme {

    double[] y0;
    double t0;
    double tEnd;
    List<Float> terrestrialSources;
    List<Float> transformations;
    List<Float> transports;

    public PandoraCarbonScheme(double[] y0, double t0, double tEnd, List<Float> terrestrialSources,
	    List<Float> transformations, List<Float> transports) {
	this.y0 = y0;
	this.t0 = t0;
	this.tEnd = tEnd;
	this.terrestrialSources = terrestrialSources;
	this.transformations = transformations;
	this.transports = transports;
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
	return y0.length;
    }

    @Override
    public float getTerrestrialSources(int index) {
	return this.terrestrialSources.get(index);
    }

    @Override
    public float getTransformations(int index) {
	return this.transformations.get(index);
    }

    @Override
    public float getTransport(int index) {
	return this.transports.get(index);
    }

}
