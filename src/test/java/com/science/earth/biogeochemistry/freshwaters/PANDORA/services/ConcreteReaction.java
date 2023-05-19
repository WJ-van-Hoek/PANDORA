package com.science.earth.biogeochemistry.freshwaters.PANDORA.services;

import com.science.earth.biogeochemistry.freshwaters.PANDORA.model.Reaction;

import lombok.Builder;

public class ConcreteReaction extends Reaction {

    private static final long serialVersionUID = -8227752233932352679L;
    
    @Builder
    public ConcreteReaction(Long id, String name, float rate) {
	super(id, name, rate);
    }

}
