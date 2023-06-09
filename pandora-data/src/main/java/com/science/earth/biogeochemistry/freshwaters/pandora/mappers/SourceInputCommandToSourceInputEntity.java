package com.science.earth.biogeochemistry.freshwaters.pandora.mappers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.converter.Converter;

import com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs.SourceInputCommand;
import com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs.params.FloatInputParamCommand;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.SourceInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.params.FloatInputParam;

public class SourceInputCommandToSourceInputEntity implements Converter<SourceInputCommand, SourceInputEntity> {

    FloatInputParamCommandToFloatInputParam floatInputParamCommandToFloatInputParamConverter;

    public SourceInputCommandToSourceInputEntity(
	    FloatInputParamCommandToFloatInputParam floatInputParamCommandToFloatInputParamConverter) {
	this.floatInputParamCommandToFloatInputParamConverter = floatInputParamCommandToFloatInputParamConverter;
    }
    
    @Override
    public SourceInputEntity convert(SourceInputCommand source) {
	if (source == null) {
	    return null;
	}

	final SourceInputEntity result = SourceInputEntity.builder().build();
	result.setName(source.getName());
	convertFloatInputParamCommands(source, result);
	return result;
    }

    private void convertFloatInputParamCommands(SourceInputCommand source, final SourceInputEntity result) {
	Set<FloatInputParam> floatInputParams = new HashSet<>();
	for (FloatInputParamCommand value : source.getFloatInputParamCommands().values()) {
	    floatInputParams.add(floatInputParamCommandToFloatInputParamConverter.convert(value));
	}
	result.setFloatInputParams(floatInputParams);
    }
    
}
