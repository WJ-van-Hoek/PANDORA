package com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.implementations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.AbstractInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.repositories.AbstractInputEntityRepository;

class AbstractInputEntityCrudServiceImplTest {

    @Mock
    AbstractInputEntityRepository<AbstractInputEntity> abstractInputEntityRepository;

    @Mock
    ErrorMessageGenerator errorMessageGenerator;

    @InjectMocks
    AbstractInputEntityCrudServiceImpl<AbstractInputEntity> abstractInputEntityCrudServiceImpl;

    @BeforeEach
    void setUp() throws Exception {
	MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAbstractInputEntityCrudServiceImpl() {
	assertEquals(errorMessageGenerator, abstractInputEntityCrudServiceImpl.errorMessageGenerator);
	assertEquals(abstractInputEntityRepository, abstractInputEntityCrudServiceImpl.repository);
    }

}
