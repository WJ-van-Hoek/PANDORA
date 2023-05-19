package com.science.earth.biogeochemistry.freshwaters.PANDORA.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
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
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.science.earth.biogeochemistry.freshwaters.PANDORA.errors.CrudError;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.model.AbstractBaseEntity;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.repositories.AbstractBaseEntityRepository;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.services.entityservices.interfaces.AbstractBaseEntityService;

class AbstractCrudServiceImplTest {

    @Mock
    AbstractBaseEntityRepository<ConcreteBaseEntity> repository;

    @Mock
    AbstractBaseEntityService abstractBaseEntityService;

    @Mock
    ErrorMessageGenerator errorMessageGenerator;

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
	String mockedErrorMessage = "this is a mocked message";
	when(repository.findById(3L)).thenReturn(Optional.empty());
	when(errorMessageGenerator.generate(any(String.class), any(Long.class)))
		.thenReturn(mockedErrorMessage);

	// when
	CrudError e = assertThrows(CrudError.class, () -> concreteCrudServiceImpl.findById(3L));

	// then
	ArgumentCaptor<String> stringCaptor = ArgumentCaptor.forClass(String.class);
	ArgumentCaptor<Long> longCaptor = ArgumentCaptor.forClass(Long.class);
	ArgumentCaptor<String> classStringCaptor = ArgumentCaptor.forClass(String.class);

	verify(repository, times(1)).findById(anyLong());
	verify(errorMessageGenerator, times(1)).generate(stringCaptor.capture(), longCaptor.capture());
	assertEquals(mockedErrorMessage, e.getMessage());
	assertEquals("abstract.crud.service.id.notexist", stringCaptor.getValue());
	assertEquals(Long.valueOf(3l), longCaptor.getValue());
    }

    @Test
    void testSave() {
	// and given
	when(repository.save(concreteBaseEntity1)).thenReturn(concreteBaseEntity1);

	// when
	ConcreteBaseEntity savedConcreteBaseEntity = concreteCrudServiceImpl.save(concreteBaseEntity1);

	// then
	assertNotNull(savedConcreteBaseEntity);
	assertEquals(concreteBaseEntity1, savedConcreteBaseEntity);
	verify(repository, times(1)).save(concreteBaseEntity1);
    }

    @Test
    void testSaveNull() {
	// given
	String mockedErrorMessage = "this is a mocked message";
	when(errorMessageGenerator.generate(any(String.class), any(String.class))).thenReturn(mockedErrorMessage);

	// when
	CrudError e = assertThrows(CrudError.class, () -> concreteCrudServiceImpl.save(null));

	// then
	ArgumentCaptor<String> stringCaptor = ArgumentCaptor.forClass(String.class);
	ArgumentCaptor<String> classStringCaptor = ArgumentCaptor.forClass(String.class);

	verify(errorMessageGenerator, times(1)).generate(stringCaptor.capture(), classStringCaptor.capture());
	assertEquals(mockedErrorMessage, e.getMessage());
	assertEquals("abstract.crud.service.object.null", stringCaptor.getValue());
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
    void testDeleteById() {
	// and given
	doNothing().when(repository).deleteById(1l);

	// when
	concreteCrudServiceImpl.deleteById(1l);

	// when
	verify(repository, times(1)).deleteById(1l);
    }
}
