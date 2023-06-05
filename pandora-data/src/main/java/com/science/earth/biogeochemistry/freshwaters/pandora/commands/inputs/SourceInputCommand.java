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
public class SourceInputCommand extends AbstractBaseCommand {
    private Map<String, FloatInputParamCommand> floatInputParamCommands = new HashMap<>();
    
    @Builder
    public SourceInputCommand(Long id, String name,
	    Map<String, FloatInputParamCommand> floatInputParamCommands, String unit, int molarMass) {
	super(id, name);
	this.floatInputParamCommands = floatInputParamCommands != null ? floatInputParamCommands : new HashMap<>();
    }
}
