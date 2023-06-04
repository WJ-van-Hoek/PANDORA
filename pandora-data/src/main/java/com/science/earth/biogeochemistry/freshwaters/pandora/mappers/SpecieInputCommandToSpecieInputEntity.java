package com.science.earth.biogeochemistry.freshwaters.pandora.mappers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.converter.Converter;

import com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs.SpecieInputCommand;
import com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs.params.FloatInputParamCommand;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.SpecieInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.params.FloatInputParam;

public class SpecieInputCommandToSpecieInputEntity implements Converter<SpecieInputCommand, SpecieInputEntity> {

    FloatInputParamCommandToFloatInputParam floatInputParamCommandToFloatInputParamConverter;

    public SpecieInputCommandToSpecieInputEntity(
	    FloatInputParamCommandToFloatInputParam floatInputParamCommandToFloatInputParamConverter) {
	this.floatInputParamCommandToFloatInputParamConverter = floatInputParamCommandToFloatInputParamConverter;
    }

    @Override
    public SpecieInputEntity convert(SpecieInputCommand source) {
	if (source == null) {
	    return null;
	}

	final SpecieInputEntity result = SpecieInputEntity.builder().build();
	result.setName(source.getName());
	result.setUnit(source.getUnit());
	result.setMolarMass(source.getMolarMass());
	convertFloatInputParamCommands(source, result);
	return result;
    }

    private void convertFloatInputParamCommands(SpecieInputCommand source, final SpecieInputEntity result) {
	Set<FloatInputParam> floatInputParams = new HashSet<>();
	for (FloatInputParamCommand value : source.getFloatInputParamCommands().values()) {
	    floatInputParams.add(floatInputParamCommandToFloatInputParamConverter.convert(value));
	}
	result.setFloatInputParams(floatInputParams);
    }

}
