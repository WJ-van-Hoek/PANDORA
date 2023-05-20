package com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.implementations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.Source;
import com.science.earth.biogeochemistry.freshwaters.pandora.repositories.SourceRepository;

class SourceCrudServiceImplTest {

    @Mock
    SourceRepository<Source> sourceRepository;

    @Mock
    ErrorMessageGenerator errorMessageGenerator;

    @InjectMocks
    SourceCrudServiceImpl sourceCrudServiceImpl;

    @BeforeEach
    void setUp() throws Exception {
	MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSourceCrudServiceImpl() {
	assertEquals(sourceRepository, sourceCrudServiceImpl.repository);
    }

}
