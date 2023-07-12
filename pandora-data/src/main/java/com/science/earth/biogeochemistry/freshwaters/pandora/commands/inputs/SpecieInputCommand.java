package com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs;

import java.util.HashMap;
import java.util.Map;

import com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs.params.FloatInputParamCommand;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.AbstractBaseObject;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class SpecieInputCommand extends AbstractBaseObject {
    private String unit;
    private int molarMass;
    private Map<String, FloatInputParamCommand> floatInputParamCommands = new HashMap<>();
    
    @Builder
    public SpecieInputCommand(Long id, String name,
	    Map<String, FloatInputParamCommand> floatInputParamCommands, String unit, int molarMass) {
	super(id, name);
	this.floatInputParamCommands = floatInputParamCommands != null ? floatInputParamCommands : new HashMap<>();
	this.unit = unit;
	this.molarMass = molarMass;
    }
}
