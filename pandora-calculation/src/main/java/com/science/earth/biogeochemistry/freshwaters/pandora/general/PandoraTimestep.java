package com.science.earth.biogeochemistry.freshwaters.pandora.general;

public interface PandoraTimestep {
    public double[] getY0();
    public double getT0();
    public double getTEnd();
    public int getDimension();
    public float getTerrestrialSources(int index);
    public float getUpstreamSources(int index);
}
