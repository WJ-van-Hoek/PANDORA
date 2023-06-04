package com.science.earth.biogeochemistry.freshwaters.pandora.mappers;

import org.springframework.core.convert.converter.Converter;

import com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs.params.FloatInputParamCommand;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.params.FloatInputParam;

public class FloatInputParamToFloatInputParamCommand implements Converter<FloatInputParam, FloatInputParamCommand> {

    @Override
    public FloatInputParamCommand convert(FloatInputParam source) {
	if (source == null) {
	    return null;
	}

	final FloatInputParamCommand result = FloatInputParamCommand.builder().build();
	result.setName(source.getName());
	result.setValue(source.getValue());
	return result;
    }

}
