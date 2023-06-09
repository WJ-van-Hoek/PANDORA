package com.science.earth.biogeochemistry.freshwaters.pandora.mappers;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs.SourceInputCommand;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.SourceInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.params.FloatInputParam;

class SourceInputEntityToSourceInputCommandTest {
    private static final String TEST_NAME = "testName";
    private static final FloatInputParam floatInputParam = new FloatInputParam();
    private static final Set<FloatInputParam> floatInputParams = new HashSet<>();

    @Spy
    FloatInputParamToFloatInputParamCommand floatInputParamToFloatInputParamCommandConverter;

    @InjectMocks
    SourceInputEntityToSourceInputCommand converter;

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
	Assertions.assertNotNull(converter.convert(new SourceInputEntity()));
    }
    
    @Test
    void testSourceInputEntityToSourceInputCommand() {
	Assertions.assertEquals(floatInputParamToFloatInputParamCommandConverter,
		converter.floatInputParamToFloatInputParamCommandConverter);
    }

    @Test
    void testConvert() {
	// given
	SourceInputEntity sourceInputEntity = new SourceInputEntity();
	sourceInputEntity.setName(TEST_NAME);
	floatInputParams.add(floatInputParam);
	sourceInputEntity.setFloatInputParams(floatInputParams);

	// when
	SourceInputCommand sourceInputCommand = converter.convert(sourceInputEntity);

	// then
	Assertions.assertEquals(TEST_NAME, sourceInputCommand.getName());
	Assertions.assertEquals(1, sourceInputCommand.getFloatInputParamCommands().size());
    }
    
    @Test
    void testConvertNullFloatInputParams() {
	// given
	SourceInputEntity sourceInputEntity = new SourceInputEntity();
	sourceInputEntity.setName(TEST_NAME);
	floatInputParams.add(null);
	sourceInputEntity.setFloatInputParams(floatInputParams);

	// when
	SourceInputCommand sourceInputCommand = converter.convert(sourceInputEntity);

	// then
	Assertions.assertEquals(TEST_NAME, sourceInputCommand.getName());
	Assertions.assertEquals(0, sourceInputCommand.getFloatInputParamCommands().size());
    }

}
