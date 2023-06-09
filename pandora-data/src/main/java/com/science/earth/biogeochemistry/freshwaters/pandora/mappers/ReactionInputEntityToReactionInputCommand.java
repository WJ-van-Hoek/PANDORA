package com.science.earth.biogeochemistry.freshwaters.pandora.mappers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.convert.converter.Converter;

import com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs.ReactionInputCommand;
import com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs.params.FloatInputParamCommand;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.ReactionInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.params.FloatInputParam;

public class ReactionInputEntityToReactionInputCommand implements Converter<ReactionInputEntity, ReactionInputCommand> {

    FloatInputParamToFloatInputParamCommand floatInputParamToFloatInputParamCommandConverter;

    public ReactionInputEntityToReactionInputCommand(
	    FloatInputParamToFloatInputParamCommand floatInputParamToFloatInputParamCommandConverter) {
	this.floatInputParamToFloatInputParamCommandConverter = floatInputParamToFloatInputParamCommandConverter;
    }
    
    @Override
    public ReactionInputCommand convert(ReactionInputEntity source) {
	if (source == null) {
	    return null;
	}

	final ReactionInputCommand result = ReactionInputCommand.builder().build();
	result.setName(source.getName());
	convertFloatInputParams(source, result);
	return result;
    }

    private void convertFloatInputParams(ReactionInputEntity source, final ReactionInputCommand result) {
	Map<String, FloatInputParamCommand> floatInputParamCommands = new HashMap<>();
	for (FloatInputParam value : source.getFloatInputParams()) {
	    FloatInputParamCommand floatInputParamCommand = floatInputParamToFloatInputParamCommandConverter
		    .convert(value);
	    if (floatInputParamCommand != null) {
		floatInputParamCommands.put(floatInputParamCommand.getName(), floatInputParamCommand);
	    }
	}
	result.setFloatInputParamCommands(floatInputParamCommands);
    }
}
