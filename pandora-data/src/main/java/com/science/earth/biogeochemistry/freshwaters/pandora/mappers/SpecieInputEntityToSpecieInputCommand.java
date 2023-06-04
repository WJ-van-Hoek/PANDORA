package com.science.earth.biogeochemistry.freshwaters.pandora.mappers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.convert.converter.Converter;

import com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs.SpecieInputCommand;
import com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs.params.FloatInputParamCommand;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.SpecieInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.params.FloatInputParam;

public class SpecieInputEntityToSpecieInputCommand implements Converter<SpecieInputEntity, SpecieInputCommand> {

    FloatInputParamToFloatInputParamCommand floatInputParamToFloatInputParamCommandConverter;

    public SpecieInputEntityToSpecieInputCommand(
	    FloatInputParamToFloatInputParamCommand floatInputParamToFloatInputParamCommandConverter) {
	this.floatInputParamToFloatInputParamCommandConverter = floatInputParamToFloatInputParamCommandConverter;
    }

    @Override
    public SpecieInputCommand convert(SpecieInputEntity source) {
	if (source == null) {
	    return null;
	}

	final SpecieInputCommand result = SpecieInputCommand.builder().build();
	result.setName(source.getName());
	result.setUnit(source.getUnit());
	result.setMolarMass(source.getMolarMass());
	Map<String, FloatInputParamCommand> floatInputParamCommands = new HashMap<>();
	for (FloatInputParam value : source.getFloatInputParams()) {
	    FloatInputParamCommand floatInputParamCommand = floatInputParamToFloatInputParamCommandConverter
		    .convert(value);
	    if (floatInputParamCommand != null) {
		floatInputParamCommands.put(floatInputParamCommand.getName(), floatInputParamCommand);
	    }
	}
	return result;
    }

}
