package com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs;

import java.util.HashMap;
import java.util.Map;

import com.science.earth.biogeochemistry.freshwaters.pandora.commands.AbstractBaseCommand;
import com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs.params.FloatInputParamCommand;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SchemeInputCommand extends AbstractBaseCommand {
    private Map<String, ReactionInputCommand> reactionInputCommands = new HashMap<>();
    private Map<String, SourceInputCommand> sourceInputCommands = new HashMap<>();
    private Map<String, SpecieInputCommand> specieInputCommands = new HashMap<>();
    private Map<String, FloatInputParamCommand> floatInputParamCommands = new HashMap<>();

    @Builder
    public SchemeInputCommand(Long id, String name, Map<String, ReactionInputCommand> reactionInputCommands,
	    Map<String, SourceInputCommand> sourceInputCommands, Map<String, SpecieInputCommand> specieInputCommands,
	    Map<String, FloatInputParamCommand> floatInputParamCommands) {
	super(id, name);
	this.floatInputParamCommands = floatInputParamCommands;
	this.reactionInputCommands = reactionInputCommands;
	this.sourceInputCommands = sourceInputCommands;
	this.specieInputCommands = specieInputCommands;
    }
}
