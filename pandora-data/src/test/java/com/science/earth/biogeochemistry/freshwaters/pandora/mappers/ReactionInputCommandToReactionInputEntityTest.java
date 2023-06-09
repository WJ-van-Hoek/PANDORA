package com.science.earth.biogeochemistry.freshwaters.pandora.mappers;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs.ReactionInputCommand;
import com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs.params.FloatInputParamCommand;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.ReactionInputEntity;

class ReactionInputCommandToReactionInputEntityTest {
    private static final String TEST_NAME = "testName";
    private static final FloatInputParamCommand floatInputParamCommand = new FloatInputParamCommand();
    private static final String TEST_FLOAT_PARAM_NAME = "testFloatParamName";
    private static final Map<String, FloatInputParamCommand> floatInputParamCommands = new HashMap<>();
    
    @Spy
    FloatInputParamCommandToFloatInputParam floatInputParamCommandToFloatInputParamConverter;

    @InjectMocks
    ReactionInputCommandToReactionInputEntity converter;

    @BeforeEach
    void setUp() throws Exception {
	MockitoAnnotations.openMocks(this);
	floatInputParamCommands.put(TEST_FLOAT_PARAM_NAME, floatInputParamCommand);
    }
    
    @Test
    void testNullObject() {
	Assertions.assertNull(converter.convert(null));
    }

    @Test
    void testEmptyObject() throws Exception {
	Assertions.assertNotNull(converter.convert(new ReactionInputCommand()));
    }

    @Test
    void testReactionInputEntityToReactionInputCommand() {
	Assertions.assertEquals(floatInputParamCommandToFloatInputParamConverter,
		converter.floatInputParamCommandToFloatInputParamConverter);
    }

    @Test
    void testConvert() {
	// given
	ReactionInputCommand reactionInputCommand = new ReactionInputCommand();
	reactionInputCommand.setName(TEST_NAME);
	reactionInputCommand.setFloatInputParamCommands(floatInputParamCommands);

	// when
	ReactionInputEntity reactionInputEntity = converter.convert(reactionInputCommand);

	// then
	Assertions.assertEquals(TEST_NAME, reactionInputEntity.getName());
	Assertions.assertEquals(1, reactionInputEntity.getFloatInputParams().size());
    }
}
