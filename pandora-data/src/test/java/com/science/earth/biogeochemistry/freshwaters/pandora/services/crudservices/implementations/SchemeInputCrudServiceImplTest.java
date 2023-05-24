package com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.implementations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.SchemeInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.repositories.SchemeInputRepository;

class SchemeInputCrudServiceImplTest {

    @Mock
    SchemeInputRepository<SchemeInputEntity> schemeRepository;

    @Mock
    ErrorMessageGenerator errorMessageGenerator;

    @InjectMocks
    SchemeInputCrudServiceImpl schemeCrudServiceImpl;

    @BeforeEach
    void setUp() throws Exception {
	MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSchemeCrudServiceImpl() {
	assertEquals(errorMessageGenerator, schemeCrudServiceImpl.errorMessageGenerator);
	assertEquals(schemeRepository, schemeCrudServiceImpl.repository);
    }

}
