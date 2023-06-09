package com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs;

import java.util.HashMap;
import java.util.Map;

import com.science.earth.biogeochemistry.freshwaters.pandora.commands.AbstractBaseCommand;
import com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs.params.FloatInputParamCommand;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ReactionInputCommand extends AbstractBaseCommand {
    private Map<String, FloatInputParamCommand> floatInputParamCommands = new HashMap<>();
    
    @Builder
    public ReactionInputCommand(Long id, String name,
	    Map<String, FloatInputParamCommand> floatInputParamCommands) {
	super(id, name);
	this.floatInputParamCommands = floatInputParamCommands != null ? floatInputParamCommands : new HashMap<>();
    }
}
