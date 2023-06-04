package com.science.earth.biogeochemistry.freshwaters.pandora.mappers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs.params.FloatInputParamCommand;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.params.FloatInputParam;

class FloatInputParamToFloatInputParamCommandTest {
    private static final String TEST_NAME = "testName";
    private static final float TEST_FLOAT = 1f;

    FloatInputParamToFloatInputParamCommand converter;

    @BeforeEach
    void setUp() throws Exception {
	converter = new FloatInputParamToFloatInputParamCommand();
    }

    @Test
    void testNullObject() {
	Assertions.assertNull(converter.convert(null));
    }
    
    @Test
    void testEmptyObject() throws Exception {
	Assertions.assertNotNull(converter.convert(new FloatInputParam()));
    }

    @Test
    void testConvert() {
	// given
	FloatInputParam floatInputParam = new FloatInputParam();
	floatInputParam.setName(TEST_NAME);
	floatInputParam.setValue(TEST_FLOAT);

	// when
	FloatInputParamCommand floatInputParamCommand = converter.convert(floatInputParam);

	// then
	Assertions.assertEquals(TEST_NAME, floatInputParamCommand.getName());
	Assertions.assertEquals(TEST_FLOAT, floatInputParamCommand.getValue());
    }

}
