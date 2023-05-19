package com.science.earth.biogeochemistry.freshwaters.PANDORA.services.entityservices.implementations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.science.earth.biogeochemistry.freshwaters.PANDORA.errors.CrudError;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.errors.ServiceImplError;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.model.Scheme;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.services.crudservices.interfaces.ReactionCrudService;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.services.crudservices.interfaces.SchemeCrudService;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.services.crudservices.interfaces.SourceCrudService;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.services.crudservices.interfaces.SpecieCrudService;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.services.entityservices.interfaces.ReactionService;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.services.entityservices.interfaces.SourceService;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.services.entityservices.interfaces.SpecieService;

class SchemeServiceImplTest {
    
    @Mock
    SchemeCrudService schemeCrudService;

    @Mock
    ReactionCrudService reactionCrudService;

    @Mock
    ReactionService reactionService;

    @Mock
    SourceCrudService sourceCrudService;

    @Mock
    SourceService sourceService;

    @Mock
    SpecieCrudService specieCrudService;

    @Mock
    SpecieService specieService;

    @Mock
    ErrorMessageGenerator errorMessageGenerator;
    
    @InjectMocks
    SchemeServiceImpl schemeServiceImpl;
      
    Scheme scheme;

    @BeforeEach
    void setUp() throws Exception {
	MockitoAnnotations.openMocks(this);
	
	scheme = Scheme.builder().id(1L).name("testName").build();
    }

    @Test
    void testSafeSaveHappy() {
	// given
	when(schemeCrudService.save(scheme)).thenReturn(scheme);	
	
	// when
	Scheme savedScheme = schemeServiceImpl.safeSave(scheme);
	
	// then
	verify(schemeCrudService, times(1)).save(scheme);
	assertEquals(scheme, savedScheme);
    }
    
    @Test
    void testSafeSaveError() {
	// given
	when(schemeCrudService.save(null)).thenThrow(new CrudError(""));
	when(errorMessageGenerator.generate(any(String.class), any(String.class))).thenReturn("this is a mocked error message");
	
	// when
	ServiceImplError e = assertThrows(ServiceImplError.class, () -> schemeServiceImpl.safeSave(null));
	
	// then
	ArgumentCaptor<String> messageCaptor = ArgumentCaptor.forClass(String.class);
	ArgumentCaptor<String> classNameCaptor = ArgumentCaptor.forClass(String.class);
	
	verify(schemeCrudService, times(1)).save(null);
	verify(errorMessageGenerator, times(1)).generate(messageCaptor.capture(), classNameCaptor.capture());
	assertEquals("concrete.crud.service.object.null", messageCaptor.getValue());
	assertEquals("Scheme", classNameCaptor.getValue());
	assertEquals("this is a mocked error message", e.getMessage());
    }

    @Test
    void testAddReactionToScheme() {
	fail("Not yet implemented");
    }

    @Test
    void testAddReactionByIdToScheme() {
	fail("Not yet implemented");
    }

    @Test
    void testAddReactionByIdToSchemeById() {
	fail("Not yet implemented");
    }

    @Test
    void testAddSourceToScheme() {
	fail("Not yet implemented");
    }

    @Test
    void testAddSourceByIdToScheme() {
	fail("Not yet implemented");
    }

    @Test
    void testAddSourceByIdToSchemeById() {
	fail("Not yet implemented");
    }

    @Test
    void testAddSpecieToScheme() {
	fail("Not yet implemented");
    }

    @Test
    void testAddSpecieByIdToScheme() {
	fail("Not yet implemented");
    }

    @Test
    void testAddSpecieByIdToSchemeById() {
	fail("Not yet implemented");
    }

    @Test
    void testDeleteReactionFromScheme() {
	fail("Not yet implemented");
    }

    @Test
    void testDeleteReactionByIdFromScheme() {
	fail("Not yet implemented");
    }

    @Test
    void testDeleteReactionByIdFromSchemeById() {
	fail("Not yet implemented");
    }

    @Test
    void testDeleteSourceFromScheme() {
	fail("Not yet implemented");
    }

    @Test
    void testDeleteSourceByIdFromScheme() {
	fail("Not yet implemented");
    }

    @Test
    void testDeleteSourceByIdFromSchemeById() {
	fail("Not yet implemented");
    }

    @Test
    void testDeleteSpecieFromScheme() {
	fail("Not yet implemented");
    }

    @Test
    void testDeleteSpecieByIdFromScheme() {
	fail("Not yet implemented");
    }

    @Test
    void testDeleteSpecieByIdFromSchemeById() {
	fail("Not yet implemented");
    }

    @Test
    void testAddReactionSetToScheme() {
	fail("Not yet implemented");
    }

    @Test
    void testAddSourceSetToScheme() {
	fail("Not yet implemented");
    }

    @Test
    void testAddSpecieSetToScheme() {
	fail("Not yet implemented");
    }

}
