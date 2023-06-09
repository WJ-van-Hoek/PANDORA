package com.science.earth.biogeochemistry.freshwaters.pandora.mappers;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs.ReactionInputCommand;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.ReactionInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.params.FloatInputParam;

class ReactionInputEntityToReactionInputCommandTest {
    private static final String TEST_NAME = "testName";
    private static final FloatInputParam floatInputParam = new FloatInputParam();

    @Spy
    FloatInputParamToFloatInputParamCommand floatInputParamToFloatInputParamCommandConverter;

    @InjectMocks
    ReactionInputEntityToReactionInputCommand converter;

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
	Assertions.assertNotNull(converter.convert(new ReactionInputEntity()));
    }
    
    @Test
    void testSourceInputEntityToSourceInputCommand() {
	Assertions.assertEquals(floatInputParamToFloatInputParamCommandConverter,
		converter.floatInputParamToFloatInputParamCommandConverter);
    }

    @Test
    void testConvert() {
	// given
	Set<FloatInputParam> floatInputParams = new HashSet<>();
	ReactionInputEntity reactionInputEntity = new ReactionInputEntity();
	reactionInputEntity.setName(TEST_NAME);
	floatInputParams.add(floatInputParam);
	reactionInputEntity.setFloatInputParams(floatInputParams);

	// when
	ReactionInputCommand reactionInputCommand = converter.convert(reactionInputEntity);

	// then
	Assertions.assertEquals(TEST_NAME, reactionInputCommand.getName());
	Assertions.assertEquals(1, reactionInputCommand.getFloatInputParamCommands().size());
    }
    
    @Test
    void testConvertNullFloatInputParams() {
	// given
	Set<FloatInputParam> floatInputParams = new HashSet<>();
	ReactionInputEntity reactionInputEntity = new ReactionInputEntity();
	reactionInputEntity.setName(TEST_NAME);
	floatInputParams.add(null);
	reactionInputEntity.setFloatInputParams(floatInputParams);

	// when
	ReactionInputCommand reactionInputCommand = converter.convert(reactionInputEntity);

	// then
	Assertions.assertEquals(TEST_NAME, reactionInputCommand.getName());
	Assertions.assertEquals(0, reactionInputCommand.getFloatInputParamCommands().size());
    }

}
