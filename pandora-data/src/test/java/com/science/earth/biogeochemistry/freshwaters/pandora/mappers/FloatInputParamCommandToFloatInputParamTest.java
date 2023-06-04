package com.science.earth.biogeochemistry.freshwaters.pandora.mappers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs.params.FloatInputParamCommand;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.params.FloatInputParam;

class FloatInputParamCommandToFloatInputParamTest {
    private static final String TEST_NAME = "testName";
    private static final float TEST_FLOAT = 1f;

    FloatInputParamCommandToFloatInputParam converter;

    @BeforeEach
    void setUp() throws Exception {
	converter = new FloatInputParamCommandToFloatInputParam();
    }

    @Test
    void testNullObject() {
	Assertions.assertNull(converter.convert(null));
    }

    @Test
    void testEmptyObject() throws Exception {
	Assertions.assertNotNull(converter.convert(new FloatInputParamCommand()));
    }

    @Test
    void testConvert() {
	// given
	FloatInputParamCommand floatInputParamCommand = new FloatInputParamCommand();
	floatInputParamCommand.setName(TEST_NAME);
	floatInputParamCommand.setValue(TEST_FLOAT);

	// when
	FloatInputParam floatInputParam = converter.convert(floatInputParamCommand);

	// then
	Assertions.assertEquals(TEST_NAME, floatInputParam.getName());
	Assertions.assertEquals(TEST_FLOAT, floatInputParam.getValue());
    }

}
