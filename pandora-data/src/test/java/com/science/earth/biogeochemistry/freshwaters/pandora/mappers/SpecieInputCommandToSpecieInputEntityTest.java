package com.science.earth.biogeochemistry.freshwaters.pandora.mappers;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs.SpecieInputCommand;
import com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs.params.FloatInputParamCommand;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.SpecieInputEntity;

class SpecieInputCommandToSpecieInputEntityTest {

    private static final String TEST_NAME = "testName";
    private static final String TEST_UNIT = "testUnit";
    private static final int TEST_MOLAR_MASS = 1;
    private static final FloatInputParamCommand floatInputParamCommand = new FloatInputParamCommand();
    private static final String TEST_FLOAT_PARAM_NAME = "testFloatParamName";
    private static final Map<String, FloatInputParamCommand> floatInputParamCommands = new HashMap<>();

    @Spy
    FloatInputParamCommandToFloatInputParam floatInputParamCommandToFloatInputParamConverter;

    @InjectMocks
    SpecieInputCommandToSpecieInputEntity converter;

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
	Assertions.assertNotNull(converter.convert(new SpecieInputCommand()));
    }

    @Test
    void testSpecieInputCommandToSpecieInputEntity() {
	Assertions.assertEquals(floatInputParamCommandToFloatInputParamConverter,
		converter.floatInputParamCommandToFloatInputParamConverter);
    }

    @Test
    void testConvert() {
	// given
	SpecieInputCommand specieInputCommand = new SpecieInputCommand();
	specieInputCommand.setName(TEST_NAME);
	specieInputCommand.setUnit(TEST_UNIT);
	specieInputCommand.setMolarMass(TEST_MOLAR_MASS);
	specieInputCommand.setFloatInputParamCommands(floatInputParamCommands);

	// when
	SpecieInputEntity specieInputEntity = converter.convert(specieInputCommand);

	// then
	Assertions.assertEquals(TEST_NAME, specieInputEntity.getName());
	Assertions.assertEquals(TEST_UNIT, specieInputEntity.getUnit());
	Assertions.assertEquals(TEST_MOLAR_MASS, specieInputEntity.getMolarMass());
	Assertions.assertEquals(1, specieInputEntity.getFloatInputParams().size());
    }

}
