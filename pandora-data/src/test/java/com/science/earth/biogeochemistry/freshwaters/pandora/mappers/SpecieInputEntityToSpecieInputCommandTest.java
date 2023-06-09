package com.science.earth.biogeochemistry.freshwaters.pandora.mappers;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs.SpecieInputCommand;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.SpecieInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.params.FloatInputParam;

class SpecieInputEntityToSpecieInputCommandTest {
    private static final String TEST_NAME = "testName";
    private static final String TEST_UNIT = "testUnit";
    private static final int TEST_MOLAR_MASS = 1;
    private static final FloatInputParam floatInputParam = new FloatInputParam();
    private static final Set<FloatInputParam> floatInputParams = new HashSet<>();

    @Spy
    FloatInputParamToFloatInputParamCommand floatInputParamToFloatInputParamCommandConverter;

    @InjectMocks
    SpecieInputEntityToSpecieInputCommand converter;

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
	Assertions.assertNotNull(converter.convert(new SpecieInputEntity()));
    }
    
    @Test
    void testSpecieInputEntityToSpecieInputCommand() {
	Assertions.assertEquals(floatInputParamToFloatInputParamCommandConverter,
		converter.floatInputParamToFloatInputParamCommandConverter);
    }

    @Test
    void testConvertHappy() {
	// given
	SpecieInputEntity specieInputEntity = new SpecieInputEntity();
	specieInputEntity.setName(TEST_NAME);
	specieInputEntity.setUnit(TEST_UNIT);
	specieInputEntity.setMolarMass(TEST_MOLAR_MASS);
	floatInputParams.add(floatInputParam);
	specieInputEntity.setFloatInputParams(floatInputParams);

	// when
	SpecieInputCommand specieInputCommand = converter.convert(specieInputEntity);

	// then
	Assertions.assertEquals(TEST_NAME, specieInputCommand.getName());
	Assertions.assertEquals(TEST_UNIT, specieInputCommand.getUnit());
	Assertions.assertEquals(TEST_MOLAR_MASS, specieInputCommand.getMolarMass());
	Assertions.assertEquals(1, specieInputCommand.getFloatInputParamCommands().size());
    }
    
    @Test
    void testConvertNullFloatInputParams() {
	// given
	SpecieInputEntity specieInputEntity = new SpecieInputEntity();
	specieInputEntity.setName(TEST_NAME);
	specieInputEntity.setUnit(TEST_UNIT);
	specieInputEntity.setMolarMass(TEST_MOLAR_MASS);
	floatInputParams.add(null);
	specieInputEntity.setFloatInputParams(floatInputParams);

	// when
	SpecieInputCommand specieInputCommand = converter.convert(specieInputEntity);

	// then
	Assertions.assertEquals(TEST_NAME, specieInputCommand.getName());
	Assertions.assertEquals(TEST_UNIT, specieInputCommand.getUnit());
	Assertions.assertEquals(TEST_MOLAR_MASS, specieInputCommand.getMolarMass());
	Assertions.assertEquals(0, specieInputCommand.getFloatInputParamCommands().size());
    }

}
