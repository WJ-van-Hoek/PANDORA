package com.science.earth.biogeochemistry.freshwaters.PANDORA.services;

import java.util.Set;

import com.science.earth.biogeochemistry.freshwaters.PANDORA.model.Source;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.model.SourceFraction;

import lombok.Builder;

public class ConcreteSource extends Source {
    
    private static final long serialVersionUID = 2974499245955572207L;

    @Builder
    public ConcreteSource(Long id, String name, Set<SourceFraction> fractionals) {
	super(id, name, fractionals);
    }
}
