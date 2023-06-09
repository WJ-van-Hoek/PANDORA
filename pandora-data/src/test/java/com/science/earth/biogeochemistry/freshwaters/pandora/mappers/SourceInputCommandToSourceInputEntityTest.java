package com.science.earth.biogeochemistry.freshwaters.pandora.mappers;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs.SourceInputCommand;
import com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs.params.FloatInputParamCommand;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.SourceInputEntity;

class SourceInputCommandToSourceInputEntityTest {
    private static final String TEST_NAME = "testName";
    private static final FloatInputParamCommand floatInputParamCommand = new FloatInputParamCommand();
    private static final String TEST_FLOAT_PARAM_NAME = "testFloatParamName";
    private static final Map<String, FloatInputParamCommand> floatInputParamCommands = new HashMap<>();
    
    @Spy
    FloatInputParamCommandToFloatInputParam floatInputParamCommandToFloatInputParamConverter;

    @InjectMocks
    SourceInputCommandToSourceInputEntity converter;

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
	Assertions.assertNotNull(converter.convert(new SourceInputCommand()));
    }

    @Test
    void testSourceInputCommandToSourceInputEntity() {
	Assertions.assertEquals(floatInputParamCommandToFloatInputParamConverter,
		converter.floatInputParamCommandToFloatInputParamConverter);
    }

    @Test
    void testConvert() {
	// given
	SourceInputCommand sourceInputCommand = new SourceInputCommand();
	sourceInputCommand.setName(TEST_NAME);
	sourceInputCommand.setFloatInputParamCommands(floatInputParamCommands);

	// when
	SourceInputEntity sourceInputEntity = converter.convert(sourceInputCommand);

	// then
	Assertions.assertEquals(TEST_NAME, sourceInputEntity.getName());
	Assertions.assertEquals(1, sourceInputEntity.getFloatInputParams().size());
    }

}
