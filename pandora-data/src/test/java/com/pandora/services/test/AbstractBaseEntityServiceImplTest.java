package com.pandora.services.test;

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

import com.pandora.errors.ErrorMessageGenerator;
import com.pandora.errors.ServiceImplError;
import com.pandora.model.AbstractBaseDBEntity;

class AbstractBaseEntityServiceImplTest {
    /**
     * Mock object representing an error message generator used for simulating error messages in unit testing scenarios.
     * This mock is injected into the service being tested.
     */
    @Mock
    private ErrorMessageGenerator errorMessageGenerator;

    /**
     * Mocked implementation of the ConcreteBaseEntityServiceImpl class, injecting the mocked ErrorMessageGenerator for
     * testing purposes. This service class extends AbstractBaseEntityServiceImpl and is responsible for implementing
     * specific functionality related to concrete base entities.
     */
    @InjectMocks
    private ConcreteBaseEntityServiceImpl concreteBaseEntityServiceImpl;

    /**
     * An instance of AbstractBaseDBEntity used in testing scenarios. ConcreteBaseEntityServiceImpl methods are tested
     * using this instance to cover various cases, such as null checks and isNew checks.
     */
    private AbstractBaseDBEntity abstractBaseEntity;

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

        abstractBaseEntity.setId(1L);
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
        assertEquals("com.pandora.model.AbstractBaseDBEntity",
                fullGenericType);
    }
}
