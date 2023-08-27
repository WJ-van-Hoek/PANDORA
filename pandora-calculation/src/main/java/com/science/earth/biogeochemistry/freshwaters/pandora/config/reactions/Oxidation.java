package com.science.earth.biogeochemistry.freshwaters.pandora.config.reactions;

import org.springframework.beans.factory.annotation.Autowired;

import com.science.earth.biogeochemistry.freshwaters.pandora.chemistry.interfaces.Organic;

public abstract class Oxidation<T extends Organic> extends Reaction implements OxidationConfiguration {
    
    @Autowired
    T organicCompound;
    
    @Override
    public double getRate(double[] y) {
	return organicCompound.getOxidationRate();
    }
}