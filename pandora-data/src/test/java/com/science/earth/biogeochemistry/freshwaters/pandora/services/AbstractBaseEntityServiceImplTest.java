package com.science.earth.biogeochemistry.freshwaters.pandora.services;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ServiceImplError;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.AbstractBaseDBEntity;

class AbstractBaseEntityServiceImplTest {

    @Mock
    ErrorMessageGenerator errorMessageGenerator;

    @InjectMocks
    ConcreteBaseEntityServiceImpl concreteBaseEntityServiceImpl;

    AbstractBaseDBEntity abstractBaseEntity;

    @BeforeEach
    void setUp() throws Exception {
	MockitoAnnotations.openMocks(this);
    }

    @Test
    void nullCheckTest() {
	// given
	when(errorMessageGenerator.generate(any(String.class), any(Object[].class)))
		.thenReturn("this is a mocked message");

	// when
	ServiceImplError e = assertThrows(ServiceImplError.class,
		() -> concreteBaseEntityServiceImpl.nullCheck(abstractBaseEntity));

	// then
	verify(errorMessageGenerator, times(1)).generate(any(String.class), any(Object[].class));
	assertEquals("this is a mocked message", e.getMessage());
	

	abstractBaseEntity = ConcreteBaseEntity.builder().build();
	assertDoesNotThrow(() -> concreteBaseEntityServiceImpl.nullCheck(abstractBaseEntity));
    }

    @Test
    void isNewTest() {
	abstractBaseEntity = ConcreteBaseEntity.builder().build();
	assertTrue(concreteBaseEntityServiceImpl.isNew(abstractBaseEntity));

	abstractBaseEntity.setId(1l);
	assertFalse(concreteBaseEntityServiceImpl.isNew(abstractBaseEntity));
    }
    
    @Test
    void getGenericTypeTest() {
	String genericType = concreteBaseEntityServiceImpl.getGenericType();
	assertEquals("AbstractBaseDBEntity", genericType);	
    }

    @Test
    void getFullGenericTypeTest() {
	String fullGenericType = concreteBaseEntityServiceImpl.getFullGenericType();
	assertEquals("com.science.earth.biogeochemistry.freshwaters.pandora.model.AbstractBaseDBEntity", fullGenericType);
    }
}
