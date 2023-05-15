package com.science.earth.biogeochemistry.freshwaters.PANDORA.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.science.earth.biogeochemistry.freshwaters.PANDORA.model.AbstractBaseEntity;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.repositories.AbstractBaseEntityRepository;

class AbstractCrudServiceImplTest {

    @Mock
    AbstractBaseEntityRepository<ConcreteBaseEntity> repository;

    @InjectMocks
    ConcreteCrudServiceImpl concreteCrudServiceImpl;

    Set<ConcreteBaseEntity> concreteBaseEntities;

    ConcreteBaseEntity concreteBaseEntity1;

    @BeforeEach
    void setUp() throws Exception {
	MockitoAnnotations.openMocks(this);
	// given
	concreteBaseEntities = new HashSet<>();
	concreteBaseEntity1 = ConcreteBaseEntity.builder().id(1L).name("baseEntity1").build();
	concreteBaseEntities.add(concreteBaseEntity1);
	ConcreteBaseEntity concreteBaseEntity2 = ConcreteBaseEntity.builder().id(2L).name("baseEntity2").build();
	concreteBaseEntities.add(concreteBaseEntity2);
    }

    @Test
    void findAllTest() {
	// and given
	when(repository.findAll()).thenReturn(concreteBaseEntities);

	// when
	Set<ConcreteBaseEntity> foundConcreteBaseEntities = concreteCrudServiceImpl.findAll();
	
	// then
	assertEquals(2, foundConcreteBaseEntities.size());
	verify(repository, times(1)).findAll();
    }

    @Test
    void findByIdHappyTest() {
	// and given
	when(repository.findById(1L)).thenReturn(Optional.of(concreteBaseEntity1));

	// when
	AbstractBaseEntity foundBaseEntity = concreteCrudServiceImpl.findById(1L);
	
	// then
	assertEquals(concreteBaseEntity1, foundBaseEntity);
	verify(repository, times(1)).findById(anyLong());
    }

    @Test
    void testFindByIdNotFound() {
	// and given
	when(repository.findById(3L)).thenReturn(Optional.empty());

	// when
	ConcreteBaseEntity notFoundConcreteBaseEntity = concreteCrudServiceImpl.findById(3L);
	
	// then
	assertNull(notFoundConcreteBaseEntity);
	verify(repository, times(1)).findById(anyLong());
    }

    @Test
    void testSave() {
	// and given
	when(repository.save(concreteBaseEntity1)).thenReturn(concreteBaseEntity1);

	//when
	ConcreteBaseEntity savedConcreteBaseEntity = concreteCrudServiceImpl.save(concreteBaseEntity1);
	
	//then
	assertNotNull(savedConcreteBaseEntity);
	assertEquals(concreteBaseEntity1, savedConcreteBaseEntity);
	verify(repository, times(1)).save(concreteBaseEntity1);
    }
    
    @Test
    void testDelete() {
	// and given
	doNothing().when(repository).delete(concreteBaseEntity1);
	
	// when
	concreteCrudServiceImpl.delete(concreteBaseEntity1);
	
	// when 
	verify(repository, times(1)).delete(concreteBaseEntity1);
    }
    
    @Test
    void testDeleteByIdExisting() {
	// and given
	doNothing().when(repository).deleteById(1l);
	
	// when
	concreteCrudServiceImpl.deleteById(1l);
	
	// when 
	verify(repository, times(1)).deleteById(1l);
    }
}
