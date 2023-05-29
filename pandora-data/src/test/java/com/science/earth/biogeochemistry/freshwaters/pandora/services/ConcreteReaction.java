package com.science.earth.biogeochemistry.freshwaters.pandora.services;

import java.util.Set;

import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.ReactionInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.params.FloatInputParam;

import lombok.Builder;

public class ConcreteReaction extends ReactionInputEntity {

    private static final long serialVersionUID = -8227752233932352679L;
    
    @Builder
    public ConcreteReaction(Long id, String name, Set<FloatInputParam> floatInputParams) {
	super(id, name, floatInputParams);
    }

}
