package com.science.earth.biogeochemistry.freshwaters.PANDORA.services;

import com.science.earth.biogeochemistry.freshwaters.PANDORA.model.Specie;

import lombok.Builder;

public class ConcreteSpecie extends Specie {

    private static final long serialVersionUID = -7479103675199452499L;
    
    @Builder
    public ConcreteSpecie(Long id, String name, String unit, int molarMass) {
	super(id, name, unit, molarMass);
    }
}
