package com.science.earth.biogeochemistry.freshwaters.pandora.services;

import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.ReactionInputEntity;

import lombok.Builder;

public class ConcreteReaction extends ReactionInputEntity {

    private static final long serialVersionUID = -8227752233932352679L;
    
    @Builder
    public ConcreteReaction(Long id, String name, float rate) {
	super(id, name, rate);
    }

}
