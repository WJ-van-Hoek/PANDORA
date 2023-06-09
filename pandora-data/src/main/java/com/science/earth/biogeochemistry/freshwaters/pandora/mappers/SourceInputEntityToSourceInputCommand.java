package com.science.earth.biogeochemistry.freshwaters.pandora.mappers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.convert.converter.Converter;

import com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs.SourceInputCommand;
import com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs.params.FloatInputParamCommand;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.SourceInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.params.FloatInputParam;

public class SourceInputEntityToSourceInputCommand implements Converter<SourceInputEntity, SourceInputCommand> {

    FloatInputParamToFloatInputParamCommand floatInputParamToFloatInputParamCommandConverter;

    public SourceInputEntityToSourceInputCommand(
	    FloatInputParamToFloatInputParamCommand floatInputParamToFloatInputParamCommandConverter) {
	this.floatInputParamToFloatInputParamCommandConverter = floatInputParamToFloatInputParamCommandConverter;
    }
    
    @Override
    public SourceInputCommand convert(SourceInputEntity source) {
	if (source == null) {
	    return null;
	}

	final SourceInputCommand result = SourceInputCommand.builder().build();
	result.setName(source.getName());
	convertFloatInputParams(source, result);
	return result;
    }

    private void convertFloatInputParams(SourceInputEntity source, final SourceInputCommand result) {
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
