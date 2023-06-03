package com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs;

import java.util.HashSet;
import java.util.Set;

import com.science.earth.biogeochemistry.freshwaters.pandora.commands.AbstractBaseCommand;
import com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs.params.FloatInputParamCommand;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class AbstractInputCommand extends AbstractBaseCommand {

    private Set<FloatInputParamCommand<? extends AbstractInputCommand>> floatInputParamCommands = new HashSet<>();

    protected AbstractInputCommand(Long id, String name,
	    Set<FloatInputParamCommand<? extends AbstractInputCommand>> floatInputParamCommands) {
	super(id, name);
	this.floatInputParamCommands = floatInputParamCommands;
    }
}
