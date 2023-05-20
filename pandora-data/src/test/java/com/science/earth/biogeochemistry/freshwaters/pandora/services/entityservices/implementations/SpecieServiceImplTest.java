package com.science.earth.biogeochemistry.freshwaters.pandora.services.entityservices.implementations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ErrorMessageGenerator;

class SpecieServiceImplTest {
    
    @Mock
    ErrorMessageGenerator errorMessageGenerator;

    @InjectMocks
    SpecieServiceImpl specieServiceImpl;

    @BeforeEach
    void setUp() throws Exception {
	MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSpecieServiceImpl() {
	assertEquals(errorMessageGenerator, specieServiceImpl.errorMessageGenerator);
    }

}
