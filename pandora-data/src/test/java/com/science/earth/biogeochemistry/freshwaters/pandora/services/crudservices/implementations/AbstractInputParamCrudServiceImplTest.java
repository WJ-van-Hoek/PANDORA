package com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.implementations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.params.AbstractInputParam;
import com.science.earth.biogeochemistry.freshwaters.pandora.repositories.AbstractInputParamRepository;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.ConcreteInputParamCrudServiceImpl;

class AbstractInputParamCrudServiceImplTest {
    
    @Mock
    AbstractInputParamRepository<AbstractInputParam> abstractInputParamRepository;

    @Mock
    ErrorMessageGenerator errorMessageGenerator;

    @InjectMocks
    ConcreteInputParamCrudServiceImpl<AbstractInputParam> concreteInputParamCrudServiceImpl;

    @BeforeEach
    void setUp() throws Exception {
	MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAbstractInputParamCrudServiceImpl() {
	assertEquals(errorMessageGenerator, concreteInputParamCrudServiceImpl.errorMessageGenerator);
	assertEquals(abstractInputParamRepository, concreteInputParamCrudServiceImpl.repository);
    }

}
