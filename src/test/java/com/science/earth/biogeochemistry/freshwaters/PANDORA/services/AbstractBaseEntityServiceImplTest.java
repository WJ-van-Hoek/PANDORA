package com.science.earth.biogeochemistry.freshwaters.PANDORA.services;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.science.earth.biogeochemistry.freshwaters.PANDORA.model.AbstractBaseEntity;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.repositories.AbstractBaseEntityRepository;

class AbstractBaseEntityServiceImplTest {

    @Mock
    AbstractBaseEntityRepository<AbstractBaseEntity> abstractBaseEntityRepository;

    @InjectMocks
    ConcreteBaseEntityServiceImpl concreteBaseEntityServiceImpl;

    AbstractBaseEntity abstractBaseEntity;

    @BeforeEach
    void setUp() throws Exception {
	MockitoAnnotations.openMocks(this);
    }

    @Test
    void nullCheckTest() {
	RuntimeException e = assertThrows(RuntimeException.class,
		() -> concreteBaseEntityServiceImpl.nullCheck(abstractBaseEntity));
	assertEquals("Entity can not be null", e.getMessage());

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

}
