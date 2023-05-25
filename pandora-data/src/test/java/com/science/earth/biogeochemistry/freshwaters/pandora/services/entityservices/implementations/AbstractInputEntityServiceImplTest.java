package com.science.earth.biogeochemistry.freshwaters.pandora.services.entityservices.implementations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.AbstractInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.ConcreteInputEntityServiceImpl;

class AbstractInputEntityServiceImplTest {
    
    @Mock
    ErrorMessageGenerator errorMessageGenerator;

    @InjectMocks
    ConcreteInputEntityServiceImpl<AbstractInputEntity> concreteInputEntityServiceImpl;

    @BeforeEach
    void setUp() throws Exception {
	MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAbstractInputEntityServiceImpl() {
	assertEquals(errorMessageGenerator, concreteInputEntityServiceImpl.errorMessageGenerator);
    }

}
