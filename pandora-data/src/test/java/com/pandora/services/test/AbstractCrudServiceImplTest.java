package com.pandora.services.test;

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

import com.pandora.errors.CrudError;
import com.pandora.errors.ErrorMessageGenerator;
import com.pandora.model.AbstractBaseDBEntity;
import com.pandora.repositories.AbstractBaseDBEntityRepository;
import com.pandora.services.entityservices.interfaces.AbstractBaseEntityService;

class AbstractCrudServiceImplTest {
    /**
     * Mock object representing a repository for managing database operations on entities that extend
     * AbstractBaseDBEntity, specifically ConcreteBaseEntity in this case. This mock is used for testing purposes to
     * simulate database interactions.
     */
    @Mock
    private AbstractBaseDBEntityRepository<ConcreteBaseEntity> repository;

    /**
     * Mock object representing an abstract base entity service. This service is used to provide common functionality
     * for entities that extend AbstractBaseDBEntity. The generic type, ConcreteBaseEntity, is specified to simulate the
     * service behavior for this concrete entity.
     */
    @Mock
    private AbstractBaseEntityService<ConcreteBaseEntity> abstractBaseEntityService;

    /**
     * Mock object representing an error message generator. This mock is used for simulating the generation of error
     * messages in case of exceptions during CRUD operations.
     */
    @Mock
    private ErrorMessageGenerator errorMessageGenerator;

    /**
     * Mocked implementation of the ConcreteCrudServiceImpl class, injecting the mocked repository,
     * abstractBaseEntityService, and errorMessageGenerator for testing purposes. This service class extends
     * AbstractCrudServiceImpl and is responsible for implementing specific CRUD operations related to
     * ConcreteBaseEntity entities.
     */
    @InjectMocks
    private ConcreteCrudServiceImpl concreteCrudServiceImpl;

    /**
     * A set of ConcreteBaseEntity instances used in testing scenarios. This set is initialized in the setup method to
     * contain mock instances of entities for testing various CRUD operations.
     */
    private Set<ConcreteBaseEntity> concreteBaseEntities;

    /**
     * An instance of ConcreteBaseEntity used in testing scenarios. This instance is initialized in the setup method and
     * is used as a sample entity for testing CRUD operations.
     */
    private ConcreteBaseEntity concreteBaseEntity1;

    /**
     * A constant representing a search ID used in testing scenarios. This ID is used to simulate the search for an
     * entity by its ID during testing.
     */
    private static final long SEARCH_ID = 3L;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        // given
        concreteBaseEntities = new HashSet<>();
        concreteBaseEntity1 = ConcreteBaseEntity.builder().id(1L).build();
        concreteBaseEntities.add(concreteBaseEntity1);
        ConcreteBaseEntity concreteBaseEntity2 = ConcreteBaseEntity.builder().id(2L).build();
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
        AbstractBaseDBEntity foundBaseEntity = concreteCrudServiceImpl.findById(1L);

        // then
        assertEquals(concreteBaseEntity1, foundBaseEntity);
        verify(repository, times(1)).findById(anyLong());
    }

    @Test
    void testFindByIdNotFound() {
        // and given
        String mockedErrorMessage = "this is a mocked message";
        when(repository.findById(SEARCH_ID)).thenReturn(Optional.empty());
        when(errorMessageGenerator.generate(any(String.class), any(Long.class))).thenReturn(mockedErrorMessage);

        // when
        CrudError e = assertThrows(CrudError.class, () -> concreteCrudServiceImpl.findById(SEARCH_ID));

        // then
        ArgumentCaptor<String> stringCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<Long> longCaptor = ArgumentCaptor.forClass(Long.class);

        verify(repository, times(1)).findById(anyLong());
        verify(errorMessageGenerator, times(1)).generate(stringCaptor.capture(), longCaptor.capture());
        assertEquals(mockedErrorMessage, e.getMessage());
        assertEquals("abstract.crud.service.id.notexist", stringCaptor.getValue());
        assertEquals(Long.valueOf(SEARCH_ID), longCaptor.getValue());
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
        ArgumentCaptor<String> classStringCaptor = ArgumentCaptor.forClass(String.class);

        verify(errorMessageGenerator, times(1)).generate(classStringCaptor.capture());
        assertEquals("abstract.crud.service.object.null", classStringCaptor.getValue());
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
        doNothing().when(repository).deleteById(1L);

        // when
        concreteCrudServiceImpl.deleteById(1L);

        // when
        verify(repository, times(1)).deleteById(1L);
    }
}
