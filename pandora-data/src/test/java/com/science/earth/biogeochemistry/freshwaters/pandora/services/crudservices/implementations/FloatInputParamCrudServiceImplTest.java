package com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.implementations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.pandora.repositories.FloatInputParamRepository;

class FloatInputParamCrudServiceImplTest {
    
    @Mock
    FloatInputParamRepository repository;
    
    @Mock
    ErrorMessageGenerator errorMessageGenerator;
    
    @InjectMocks
    FloatInputParamCrudServiceImpl floatInputParamCrudServiceImpl;

    @BeforeEach
    void setUp() throws Exception {
	MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFloatInputParamCrudServiceImpl() {
	assertEquals(errorMessageGenerator, floatInputParamCrudServiceImpl.errorMessageGenerator);
	assertEquals(repository, floatInputParamCrudServiceImpl.repository);
    }

}
