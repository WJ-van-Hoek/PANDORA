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
import com.science.earth.biogeochemistry.freshwaters.pandora.services.ConcreteInputEntityCrudServiceImpl;

class AbstractInputEntityCrudServiceImplTest {

    @Mock
    AbstractInputEntityRepository<AbstractInputEntity> abstractInputEntityRepository;

    @Mock
    ErrorMessageGenerator errorMessageGenerator;

    @InjectMocks
    ConcreteInputEntityCrudServiceImpl<AbstractInputEntity> concreteInputEntityCrudServiceImpl;

    @BeforeEach
    void setUp() throws Exception {
	MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAbstractInputEntityCrudServiceImpl() {
	assertEquals(errorMessageGenerator, concreteInputEntityCrudServiceImpl.errorMessageGenerator);
	assertEquals(abstractInputEntityRepository, concreteInputEntityCrudServiceImpl.repository);
    }

}
