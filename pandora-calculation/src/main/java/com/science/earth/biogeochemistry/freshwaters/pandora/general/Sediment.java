package com.science.earth.biogeochemistry.freshwaters.pandora.general;

public interface Sediment {
    double getParticleRadius();
    double getParticleDensity();
//    For non-cohesive sediments (e.g., sands):
//        α can range from about 0.01 to 10.
//
//    For cohesive sediments (e.g., silts, clays):
//        α can range from about 0.001 to 1.
    double getAlpha();
//    For non-cohesive sediments (e.g., sands):
//        θ_c typically ranges from about 0.02 to 0.05.
//
//    For cohesive sediments (e.g., silts, clays):
//        θ_c is generally lower and can range from about 0.005 to 0.02.    
    double getThetaCritical();
//    For non-cohesive sediments, "n" is typically around 1 to 2.
//    For cohesive sediments, "n" can be in the range of 2 to 4.
    double getN();
}
