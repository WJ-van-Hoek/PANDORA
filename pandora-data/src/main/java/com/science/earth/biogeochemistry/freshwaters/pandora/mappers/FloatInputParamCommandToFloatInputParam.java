package com.science.earth.biogeochemistry.freshwaters.pandora.mappers;

import org.springframework.core.convert.converter.Converter;

import com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs.params.FloatInputParamCommand;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.params.FloatInputParam;

public class FloatInputParamCommandToFloatInputParam implements Converter<FloatInputParamCommand, FloatInputParam> {

    @Override
    public FloatInputParam convert(FloatInputParamCommand source) {
	if (source == null) {
	    return null;
	}

	final FloatInputParam result = FloatInputParam.builder().build();
	result.setName(source.getName());
	result.setValue(source.getValue());
	return result;
    }

}
