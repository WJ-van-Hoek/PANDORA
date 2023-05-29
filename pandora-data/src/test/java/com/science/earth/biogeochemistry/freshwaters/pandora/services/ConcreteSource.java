package com.science.earth.biogeochemistry.freshwaters.pandora.services;

import java.util.Set;

import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.SourceInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.params.FloatInputParam;

import lombok.Builder;

public class ConcreteSource extends SourceInputEntity {
    
    private static final long serialVersionUID = 2974499245955572207L;

    @Builder
    public ConcreteSource(Long id, String name, Set<FloatInputParam> floatInputParams) {
	super(id, name, floatInputParams);
    }
}
