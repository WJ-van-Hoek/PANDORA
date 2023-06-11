package com.science.earth.biogeochemistry.freshwaters.pandora.mappers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.converter.Converter;

import com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs.ReactionInputCommand;
import com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs.SchemeInputCommand;
import com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs.SourceInputCommand;
import com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs.SpecieInputCommand;
import com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs.params.FloatInputParamCommand;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.ReactionInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.SchemeInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.SourceInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.SpecieInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.params.FloatInputParam;

public class SchemeInputCommandToSchemeInputEntity implements Converter<SchemeInputCommand, SchemeInputEntity> {

    ReactionInputCommandToReactionInputEntity reactionInputCommandToReactionInputEntityConverter;
    SourceInputCommandToSourceInputEntity sourceInputCommandToSourceInputEntityConverter;
    SpecieInputCommandToSpecieInputEntity specieInputCommandToSpecieInputEntityConverter;
    FloatInputParamCommandToFloatInputParam floatInputParamCommandToFloatInputParamConverter;

    public SchemeInputCommandToSchemeInputEntity(
	    ReactionInputCommandToReactionInputEntity reactionInputCommandToReactionInputEntityConverter,
	    SourceInputCommandToSourceInputEntity sourceInputCommandToSourceInputEntityConverter,
	    SpecieInputCommandToSpecieInputEntity specieInputCommandToSpecieInputEntityConverter,
	    FloatInputParamCommandToFloatInputParam floatInputParamCommandToFloatInputParamConverter) {
	this.reactionInputCommandToReactionInputEntityConverter = reactionInputCommandToReactionInputEntityConverter;
	this.sourceInputCommandToSourceInputEntityConverter = sourceInputCommandToSourceInputEntityConverter;
	this.specieInputCommandToSpecieInputEntityConverter = specieInputCommandToSpecieInputEntityConverter;
	this.floatInputParamCommandToFloatInputParamConverter = floatInputParamCommandToFloatInputParamConverter;
    }

    @Override
    public SchemeInputEntity convert(SchemeInputCommand source) {
	if (source == null) {
	    return null;
	}

	final SchemeInputEntity result = SchemeInputEntity.builder().build();
	result.setName(source.getName());
	convertReactionInputCommands(source, result);
	convertSourceInputCommands(source, result);
	convertSpecieInputCommands(source, result);
	convertFloatInputParamCommands(source, result);
	return result;
    }

    private void convertReactionInputCommands(SchemeInputCommand source, final SchemeInputEntity result) {
	Set<ReactionInputEntity> reactionInputEntities = new HashSet<>();
	for (ReactionInputCommand value : source.getReactionInputCommands().values()) {
	    reactionInputEntities.add(reactionInputCommandToReactionInputEntityConverter.convert(value));
	}
	result.setReactions(reactionInputEntities);
    }
    
    private void convertSourceInputCommands(SchemeInputCommand source, final SchemeInputEntity result) {
	Set<SourceInputEntity> sourceInputEntities = new HashSet<>();
	for (SourceInputCommand value : source.getSourceInputCommands().values()) {
	    sourceInputEntities.add(sourceInputCommandToSourceInputEntityConverter.convert(value));
	}
	result.setSources(sourceInputEntities);
    }
    
    private void convertSpecieInputCommands(SchemeInputCommand source, final SchemeInputEntity result) {
	Set<SpecieInputEntity> specieInputEntities = new HashSet<>();
	for (SpecieInputCommand value : source.getSpecieInputCommands().values()) {
	    specieInputEntities.add(specieInputCommandToSpecieInputEntityConverter.convert(value));
	}
	result.setSpecies(specieInputEntities);
    }
    
    private void convertFloatInputParamCommands(SchemeInputCommand source, final SchemeInputEntity result) {
	Set<FloatInputParam> floatInputParams = new HashSet<>();
	for (FloatInputParamCommand value : source.getFloatInputParamCommands().values()) {
	    floatInputParams.add(floatInputParamCommandToFloatInputParamConverter.convert(value));
	}
	result.setFloatInputParams(floatInputParams);
    }
    
}
