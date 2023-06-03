package com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs.params;

import com.science.earth.biogeochemistry.freshwaters.pandora.commands.AbstractBaseCommand;
import com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs.AbstractInputCommand;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@NoArgsConstructor
@SuperBuilder
public abstract class AbstractInputParamCommand<I extends AbstractInputCommand, T extends Number> extends AbstractBaseCommand {
    
    private I inputCommand;  
    private T value;
    
    protected AbstractInputParamCommand(Long id, String name, I inputCommand, T value) {
	super(id, name);
	this.inputCommand = inputCommand;
	this.value = value;
    }
    
}