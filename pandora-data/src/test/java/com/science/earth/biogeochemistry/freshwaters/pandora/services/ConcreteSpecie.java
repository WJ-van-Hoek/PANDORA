package com.science.earth.biogeochemistry.freshwaters.pandora.services;

import java.util.Set;

import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.SpecieInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.params.FloatInputParam;

import lombok.Builder;

public class ConcreteSpecie extends SpecieInputEntity {

    private static final long serialVersionUID = -7479103675199452499L;
    
    @Builder
    public ConcreteSpecie(Long id, String name, String unit, int molarMass, Set<FloatInputParam> floatInputParams) {
	super(id, name, unit, molarMass, floatInputParams);
    }
}
