package com.science.earth.biogeochemistry.freshwaters.pandora.mappers;

import java.util.HashMap;
import java.util.Map;

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

public class SchemeInputEntityToSchemeInputCommand implements Converter<SchemeInputEntity, SchemeInputCommand> {
    
    ReactionInputEntityToReactionInputCommand reactionInputEntityToReactionInputCommandConverter;
    SourceInputEntityToSourceInputCommand sourceInputEntityToSourceInputCommandConverter;
    SpecieInputEntityToSpecieInputCommand specieInputEntityToSpecieInputCommandConverter;
    FloatInputParamToFloatInputParamCommand floatInputParamToFloatInputParamCommandConverter;

    public SchemeInputEntityToSchemeInputCommand (
	    ReactionInputEntityToReactionInputCommand reactionInputEntityToReactionInputCommandConverter,
	    SourceInputEntityToSourceInputCommand sourceInputEntityToSourceInputCommandConverter,
	    SpecieInputEntityToSpecieInputCommand specieInputEntityToSpecieInputCommandConverter,
	    FloatInputParamToFloatInputParamCommand floatInputParamToFloatInputParamCommandConverter) {
	this.reactionInputEntityToReactionInputCommandConverter = reactionInputEntityToReactionInputCommandConverter;
	this.sourceInputEntityToSourceInputCommandConverter = sourceInputEntityToSourceInputCommandConverter;
	this.specieInputEntityToSpecieInputCommandConverter = specieInputEntityToSpecieInputCommandConverter;
	this.floatInputParamToFloatInputParamCommandConverter = floatInputParamToFloatInputParamCommandConverter;
    }	
    
    @Override
    public SchemeInputCommand convert(SchemeInputEntity source) {
	if (source == null) {
	    return null;
	}

	final SchemeInputCommand result = SchemeInputCommand.builder().build();
	result.setName(source.getName());
	convertReactions(source, result);
	convertSources(source, result);
	convertSpecies(source, result);
	convertFloatInputParams(source, result);
	return result;
    }
    
    private void convertReactions(SchemeInputEntity source, final SchemeInputCommand result) {
	Map<String, ReactionInputCommand> reactionInputCommands = new HashMap<>();
	for (ReactionInputEntity value : source.getReactions()) {
	    ReactionInputCommand reactionInputCommand = reactionInputEntityToReactionInputCommandConverter
		    .convert(value);
	    if (reactionInputCommand != null) {
		reactionInputCommands.put(reactionInputCommand.getName(), reactionInputCommand);
	    }
	}
	result.setReactionInputCommands(reactionInputCommands);
    }
    
    private void convertSources(SchemeInputEntity source, final SchemeInputCommand result) {
	Map<String, SourceInputCommand> sourceInputCommands = new HashMap<>();
	for (SourceInputEntity value : source.getSources()) {
	    SourceInputCommand sourceInputCommand = sourceInputEntityToSourceInputCommandConverter
		    .convert(value);
	    if (sourceInputCommand != null) {
		sourceInputCommands.put(sourceInputCommand.getName(), sourceInputCommand);
	    }
	}
	result.setSourceInputCommands(sourceInputCommands);
    }

    private void convertSpecies(SchemeInputEntity source, final SchemeInputCommand result) {
	Map<String, SpecieInputCommand> specieInputCommands = new HashMap<>();
	for (SpecieInputEntity value : source.getSpecies()) {
	    SpecieInputCommand specieInputCommand = specieInputEntityToSpecieInputCommandConverter
		    .convert(value);
	    if (specieInputCommand != null) {
		specieInputCommands.put(specieInputCommand.getName(), specieInputCommand);
	    }
	}
	result.setSpecieInputCommands(specieInputCommands);
    }
    
    private void convertFloatInputParams(SchemeInputEntity source, final SchemeInputCommand result) {
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
