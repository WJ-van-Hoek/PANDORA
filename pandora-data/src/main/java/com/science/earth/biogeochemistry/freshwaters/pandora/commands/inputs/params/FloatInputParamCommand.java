package com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs.params;

import com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs.AbstractInputCommand;

import lombok.Builder;

public class FloatInputParamCommand<I extends AbstractInputCommand> extends AbstractInputParamCommand<I, Float> {

    @Builder
    public FloatInputParamCommand(Long id, String name, I inputCommand, Float value) {
	super(id, name, inputCommand, value);
    }
    
}
