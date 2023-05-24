package com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.implementations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.SpecieInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.repositories.SpecieInputRepository;

class SpecieInputCrudServiceImplTest {

    @Mock
    SpecieInputRepository<SpecieInputEntity> specieRepository;

    @Mock
    ErrorMessageGenerator errorMessageGenerator;

    @InjectMocks
    SpecieInputCrudServiceImpl specieCrudServiceImpl;

    @BeforeEach
    void setUp() throws Exception {
	MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSpecieCrudServiceImpl() {
	assertEquals(specieRepository, specieCrudServiceImpl.repository);
    }

}
