package com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs;

import java.util.HashMap;
import java.util.Map;

import com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs.params.FloatInputParamCommand;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.AbstractBaseObject;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SchemeInputCommand extends AbstractBaseObject {
    private Map<String, ReactionInputCommand> reactionInputCommands = new HashMap<>();
    private Map<String, SourceInputCommand> sourceInputCommands = new HashMap<>();
    private Map<String, SpecieInputCommand> specieInputCommands = new HashMap<>();
    private Map<String, FloatInputParamCommand> floatInputParamCommands = new HashMap<>();

    @Builder
    public SchemeInputCommand(Long id, String name, Map<String, ReactionInputCommand> reactionInputCommands,
	    Map<String, SourceInputCommand> sourceInputCommands, Map<String, SpecieInputCommand> specieInputCommands,
	    Map<String, FloatInputParamCommand> floatInputParamCommands) {
	super(id, name);
	this.floatInputParamCommands = floatInputParamCommands != null ? floatInputParamCommands : new HashMap<>();
	this.reactionInputCommands = reactionInputCommands != null ? reactionInputCommands : new HashMap<>();
	this.sourceInputCommands = sourceInputCommands != null ? sourceInputCommands : new HashMap<>();
	this.specieInputCommands = specieInputCommands != null ? specieInputCommands : new HashMap<>();
    }
}
