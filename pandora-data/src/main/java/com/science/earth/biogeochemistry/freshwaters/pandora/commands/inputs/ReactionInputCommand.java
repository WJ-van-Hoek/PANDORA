package com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs;

import java.util.HashMap;
import java.util.Map;

import com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs.params.FloatInputParamCommand;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.AbstractBaseObject;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ReactionInputCommand extends AbstractBaseObject {
    private Map<String, FloatInputParamCommand> floatInputParamCommands = new HashMap<>();
    
    @Builder
    public ReactionInputCommand(Long id, String name,
	    Map<String, FloatInputParamCommand> floatInputParamCommands) {
	super(id, name);
	this.floatInputParamCommands = floatInputParamCommands != null ? floatInputParamCommands : new HashMap<>();
    }
}
