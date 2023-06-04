package com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs.params;

import lombok.Builder;

public class FloatInputParamCommand extends AbstractInputParamCommand<Float> {

    @Builder
    public FloatInputParamCommand(Long id, String name, Float value) {
	super(id, name, value);
    }
    
}
