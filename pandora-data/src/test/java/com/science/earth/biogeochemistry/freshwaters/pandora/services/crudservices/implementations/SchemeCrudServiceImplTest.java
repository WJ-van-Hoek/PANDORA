package com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.implementations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.Scheme;
import com.science.earth.biogeochemistry.freshwaters.pandora.repositories.SchemeRepository;

class SchemeCrudServiceImplTest {

    @Mock
    SchemeRepository<Scheme> schemeRepository;

    @Mock
    ErrorMessageGenerator errorMessageGenerator;

    @InjectMocks
    SchemeCrudServiceImpl schemeCrudServiceImpl;

    @BeforeEach
    void setUp() throws Exception {
	MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSchemeCrudServiceImpl() {
	assertEquals(schemeRepository, schemeCrudServiceImpl.repository);
    }

}
