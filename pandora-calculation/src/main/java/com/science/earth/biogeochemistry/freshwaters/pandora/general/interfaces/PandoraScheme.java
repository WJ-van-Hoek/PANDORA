package com.science.earth.biogeochemistry.freshwaters.pandora.general.interfaces;

public interface PandoraScheme {
    public double[] getY0();
    public double getT0();
    public double getTEnd();
    public int getDimension();
    public float getTerrestrialSources(int index);
    public float getTransformations(int index);
    public float getTransport(int index);
}
