package com.science.earth.biogeochemistry.freshwaters.pandora.mappers;

import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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

class SchemeInputEntityToSchemeInputCommandTest {
    
    private static final String TEST_NAME = "testName";
    private static final ReactionInputEntity reaction = new ReactionInputEntity();
    private static final SourceInputEntity source = new SourceInputEntity();
    private static final SpecieInputEntity specie = new SpecieInputEntity();
    private static final FloatInputParam floatInputParam = new FloatInputParam();
    
    @Mock
    ReactionInputEntityToReactionInputCommand reactionInputEntityToReactionInputCommandConverter;
    
    @Mock
    SourceInputEntityToSourceInputCommand sourceInputEntityToSourceInputCommandConverter;
    
    @Mock
    SpecieInputEntityToSpecieInputCommand specieInputEntityToSpecieInputCommandConverter;
    
    @Mock
    FloatInputParamToFloatInputParamCommand floatInputParamToFloatInputParamCommandConverter;

    @InjectMocks
    SchemeInputEntityToSchemeInputCommand converter;

    @BeforeEach
    void setUp() throws Exception {
	MockitoAnnotations.openMocks(this);
    }
    
    
    @Test
    void testNullObject() {
	Assertions.assertNull(converter.convert(null));
    }

    @Test
    void testEmptyObject() throws Exception {
	Assertions.assertNotNull(converter.convert(new SchemeInputEntity()));
    }

    @Test
    void testSchemeInputEntityToSchemeInputCommand() {
	Assertions.assertEquals(reactionInputEntityToReactionInputCommandConverter,
		converter.reactionInputEntityToReactionInputCommandConverter);
	Assertions.assertEquals(sourceInputEntityToSourceInputCommandConverter,
		converter.sourceInputEntityToSourceInputCommandConverter);
	Assertions.assertEquals(specieInputEntityToSpecieInputCommandConverter,
		converter.specieInputEntityToSpecieInputCommandConverter);
	Assertions.assertEquals(floatInputParamToFloatInputParamCommandConverter,
		converter.floatInputParamToFloatInputParamCommandConverter);
    }

    @Test
    void testConvert() {
	// given
	Set<ReactionInputEntity> reactions = new HashSet<>();
	Set<SourceInputEntity> sources = new HashSet<>();
	Set<SpecieInputEntity> species = new HashSet<>();
	Set<FloatInputParam> floatInputParams = new HashSet<>();
	SchemeInputEntity schemeInputEntity = new SchemeInputEntity();
	schemeInputEntity.setName(TEST_NAME);
	reactions.add(reaction);
	reactions.add(null);
	schemeInputEntity.setReactions(reactions);
	sources.add(source);
	sources.add(null);
	schemeInputEntity.setSources(sources);
	species.add(specie);
	species.add(null);
	schemeInputEntity.setSpecies(species);
	floatInputParams.add(floatInputParam);
	floatInputParams.add(null);
	schemeInputEntity.setFloatInputParams(floatInputParams);
	
	when(reactionInputEntityToReactionInputCommandConverter.convert(reaction)).thenReturn(new ReactionInputCommand());
	when(sourceInputEntityToSourceInputCommandConverter.convert(source)).thenReturn(new SourceInputCommand());
	when(specieInputEntityToSpecieInputCommandConverter.convert(specie)).thenReturn(new SpecieInputCommand());
	when(floatInputParamToFloatInputParamCommandConverter.convert(floatInputParam)).thenReturn(new FloatInputParamCommand());
	when(reactionInputEntityToReactionInputCommandConverter.convert(null)).thenReturn(null);
	when(sourceInputEntityToSourceInputCommandConverter.convert(null)).thenReturn(null);
	when(specieInputEntityToSpecieInputCommandConverter.convert(null)).thenReturn(null);
	when(floatInputParamToFloatInputParamCommandConverter.convert(null)).thenReturn(null);

	// when
	SchemeInputCommand schemeInputCommand = converter.convert(schemeInputEntity);

	// then
	Assertions.assertEquals(TEST_NAME, schemeInputCommand.getName());
	Assertions.assertEquals(1, schemeInputCommand.getReactionInputCommands().size());
	Assertions.assertEquals(1, schemeInputCommand.getSourceInputCommands().size());
	Assertions.assertEquals(1, schemeInputCommand.getSpecieInputCommands().size());
	Assertions.assertEquals(1, schemeInputCommand.getFloatInputParamCommands().size());
    }
}
