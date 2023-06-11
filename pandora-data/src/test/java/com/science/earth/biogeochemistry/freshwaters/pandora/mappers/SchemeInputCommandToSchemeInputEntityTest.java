package com.science.earth.biogeochemistry.freshwaters.pandora.mappers;

import java.util.HashMap;
import java.util.Map;

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
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.SchemeInputEntity;

class SchemeInputCommandToSchemeInputEntityTest {
    private static final String TEST_NAME = "testName";
    private static final ReactionInputCommand reactionInputCommand = new ReactionInputCommand();
    private static final String TEST_REACTION_NAME = "testReactionName";
    private static final Map<String, ReactionInputCommand> reactionInputCommands = new HashMap<>();
    
    private static final SourceInputCommand sourceInputCommand = new SourceInputCommand();
    private static final String TEST_SOURCE_NAME = "testSourceName";
    private static final Map<String, SourceInputCommand> sourceInputCommands = new HashMap<>();
    
    private static final SpecieInputCommand specieInputCommand = new SpecieInputCommand();
    private static final String TEST_SPECIE_NAME = "testSpecieName";
    private static final Map<String, SpecieInputCommand> specieInputCommands = new HashMap<>();
    
    private static final FloatInputParamCommand floatInputParamCommand = new FloatInputParamCommand();
    private static final String TEST_FLOAT_PARAM_NAME = "testFloatParamName";
    private static final Map<String, FloatInputParamCommand> floatInputParamCommands = new HashMap<>();

    @Mock
    ReactionInputCommandToReactionInputEntity reactionInputCommandToReactionInputEntityConverter;

    @Mock
    SourceInputCommandToSourceInputEntity sourceInputCommandToSourceInputEntityConverter;

    @Mock
    SpecieInputCommandToSpecieInputEntity specieInputCommandToSpecieInputEntityConverter;

    @Mock
    FloatInputParamCommandToFloatInputParam floatInputParamCommandToFloatInputParamConverter;

    @InjectMocks
    SchemeInputCommandToSchemeInputEntity converter;

    @BeforeEach
    void setUp() throws Exception {
	MockitoAnnotations.openMocks(this);
	reactionInputCommands.put(TEST_REACTION_NAME, reactionInputCommand);
	sourceInputCommands.put(TEST_SOURCE_NAME, sourceInputCommand);
	specieInputCommands.put(TEST_SPECIE_NAME, specieInputCommand);
	floatInputParamCommands.put(TEST_FLOAT_PARAM_NAME, floatInputParamCommand);
    }

    @Test
    void testNullObject() {
	Assertions.assertNull(converter.convert(null));
    }

    @Test
    void testEmptyObject() throws Exception {
	Assertions.assertNotNull(converter.convert(new SchemeInputCommand()));
    }

    @Test
    void testSchemeInputCommandToSchemeInputEntity() {
	Assertions.assertEquals(reactionInputCommandToReactionInputEntityConverter,
		converter.reactionInputCommandToReactionInputEntityConverter);
	Assertions.assertEquals(sourceInputCommandToSourceInputEntityConverter,
		converter.sourceInputCommandToSourceInputEntityConverter);
	Assertions.assertEquals(specieInputCommandToSpecieInputEntityConverter,
		converter.specieInputCommandToSpecieInputEntityConverter);
	Assertions.assertEquals(floatInputParamCommandToFloatInputParamConverter,
		converter.floatInputParamCommandToFloatInputParamConverter);
    }

    @Test
    void testConvert() {
	// given
	SchemeInputCommand schemeInputCommand = new SchemeInputCommand();
	schemeInputCommand.setName(TEST_NAME);
	schemeInputCommand.setReactionInputCommands(reactionInputCommands);
	schemeInputCommand.setSourceInputCommands(sourceInputCommands);
	schemeInputCommand.setSpecieInputCommands(specieInputCommands);
	schemeInputCommand.setFloatInputParamCommands(floatInputParamCommands);

	// when
	SchemeInputEntity schemeInputEntity = converter.convert(schemeInputCommand);

	// then
	Assertions.assertEquals(TEST_NAME, schemeInputEntity.getName());
	Assertions.assertEquals(1, schemeInputEntity.getReactions().size());
	Assertions.assertEquals(1, schemeInputEntity.getSources().size());
	Assertions.assertEquals(1, schemeInputEntity.getSpecies().size());
	Assertions.assertEquals(1, schemeInputEntity.getFloatInputParams().size());
    }

}
