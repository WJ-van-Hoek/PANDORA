package com.science.earth.biogeochemistry.freshwaters.pandora.mappers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.converter.Converter;

import com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs.ReactionInputCommand;
import com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs.params.FloatInputParamCommand;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.ReactionInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.params.FloatInputParam;

public class ReactionInputCommandToReactionInputEntity implements Converter<ReactionInputCommand, ReactionInputEntity> {
    FloatInputParamCommandToFloatInputParam floatInputParamCommandToFloatInputParamConverter;

    public ReactionInputCommandToReactionInputEntity(
	    FloatInputParamCommandToFloatInputParam floatInputParamCommandToFloatInputParamConverter) {
	this.floatInputParamCommandToFloatInputParamConverter = floatInputParamCommandToFloatInputParamConverter;
    }
    
    @Override
    public ReactionInputEntity convert(ReactionInputCommand source) {
	if (source == null) {
	    return null;
	}

	final ReactionInputEntity result = ReactionInputEntity.builder().build();
	result.setName(source.getName());
	convertFloatInputParamCommands(source, result);
	return result;
    }

    private void convertFloatInputParamCommands(ReactionInputCommand source, final ReactionInputEntity result) {
	Set<FloatInputParam> floatInputParams = new HashSet<>();
	for (FloatInputParamCommand value : source.getFloatInputParamCommands().values()) {
	    floatInputParams.add(floatInputParamCommandToFloatInputParamConverter.convert(value));
	}
	result.setFloatInputParams(floatInputParams);
    }
}
