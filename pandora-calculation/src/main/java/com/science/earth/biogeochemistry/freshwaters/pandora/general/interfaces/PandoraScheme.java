package com.science.earth.biogeochemistry.freshwaters.pandora.general.interfaces;

public interface PandoraScheme {
    public double[] getY0();
    public double getT0();
    public double getTEnd();
    public float calculateReactions(int index);
    public float getSources(int index);
    public int getDimension();
}
