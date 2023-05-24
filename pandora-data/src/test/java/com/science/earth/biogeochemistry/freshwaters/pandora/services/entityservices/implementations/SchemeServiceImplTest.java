package com.science.earth.biogeochemistry.freshwaters.pandora.services.entityservices.implementations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.science.earth.biogeochemistry.freshwaters.pandora.errors.CrudError;
import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ServiceImplError;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.ReactionInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.SchemeInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.SourceInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.SpecieInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.ConcreteReaction;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.ConcreteSource;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.ConcreteSpecie;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.interfaces.ReactionCrudService;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.interfaces.SchemeCrudService;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.interfaces.SourceCrudService;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.interfaces.SpecieCrudService;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.entityservices.interfaces.ReactionService;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.entityservices.interfaces.SourceService;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.entityservices.interfaces.SpecieService;

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
      
    SchemeInputEntity scheme;

    @BeforeEach
    void setUp() throws Exception {
	MockitoAnnotations.openMocks(this);
	
	scheme = SchemeInputEntity.builder().id(1L).name("testName").build();
    }

    @Test
    void testSafeSaveHappy() {
	// given
	when(schemeCrudService.save(scheme)).thenReturn(scheme);	
	
	// when
	SchemeInputEntity savedScheme = schemeServiceImpl.safeSave(scheme);
	
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
	assertEquals("SchemeInputEntity", classNameCaptor.getValue());
	assertEquals("this is a mocked error message", e.getMessage());
    }

    @Test
    void testAddReactionToScheme() {
	// given
	assertEquals(0, scheme.getReactions().size());
	when(schemeCrudService.save(scheme)).thenReturn(scheme);
	ReactionInputEntity reaction = ConcreteReaction.builder().build();
		
	// when
	schemeServiceImpl.addReactionToScheme(scheme, reaction);
	
	// then
	verify(schemeCrudService, times(1)).save(scheme);
	assertEquals(1, scheme.getReactions().size());
	assertTrue(scheme.getReactions().contains(reaction));
    }
    
    @Test
    void testAddReactionByIdToScheme() {
	// given
	assertEquals(0, scheme.getReactions().size());
	when(schemeCrudService.save(scheme)).thenReturn(scheme);
	ReactionInputEntity reaction = ConcreteReaction.builder().id(2l).build();
	when(reactionCrudService.findById(any(Long.class))).thenReturn(reaction);
	
	// when
	schemeServiceImpl.addReactionByIdToScheme(scheme, 2l);
	
	// then
	ArgumentCaptor<Long> reactionIdCaptor = ArgumentCaptor.forClass(Long.class);
	
	verify(schemeCrudService, times(1)).save(scheme);
	verify(reactionCrudService, times(1)).findById(reactionIdCaptor.capture());
	assertEquals(Long.valueOf(2l), reactionIdCaptor.getValue());
	assertEquals(1, scheme.getReactions().size());
	assertTrue(scheme.getReactions().contains(reaction));
    }

    @Test
    void testAddReactionByIdToSchemeById() {
	// given
	assertEquals(0, scheme.getReactions().size());
	when(schemeCrudService.save(scheme)).thenReturn(scheme);
	ReactionInputEntity reaction = ConcreteReaction.builder().id(2l).build();
	when(schemeCrudService.findById(any(Long.class))).thenReturn(scheme);
	when(reactionCrudService.findById(any(Long.class))).thenReturn(reaction);
	
	// when
	schemeServiceImpl.addReactionByIdToSchemeById(1l, 2l);
	
	// then
	ArgumentCaptor<Long> schemeIdCaptor = ArgumentCaptor.forClass(Long.class);
	ArgumentCaptor<Long> reactionIdCaptor = ArgumentCaptor.forClass(Long.class);
	
	verify(schemeCrudService, times(1)).save(scheme);
	verify(reactionCrudService, times(1)).findById(reactionIdCaptor.capture());
	verify(schemeCrudService, times(1)).findById(schemeIdCaptor.capture());
	assertEquals(Long.valueOf(2l), reactionIdCaptor.getValue());
	assertEquals(Long.valueOf(2l), reactionIdCaptor.getValue());
	assertEquals(1, scheme.getReactions().size());
	assertTrue(scheme.getReactions().contains(reaction));
    }

    @Test
    void testAddSourceToScheme() {
	// given
	assertEquals(0, scheme.getSources().size());
	when(schemeCrudService.save(scheme)).thenReturn(scheme);
	SourceInputEntity source = ConcreteSource.builder().build();
		
	// when
	schemeServiceImpl.addSourceToScheme(scheme, source);
	
	// then
	verify(schemeCrudService, times(1)).save(scheme);
	assertEquals(1, scheme.getSources().size());
	assertTrue(scheme.getSources().contains(source));
    }

    @Test
    void testAddSourceByIdToScheme() {
	// given
	assertEquals(0, scheme.getSources().size());
	when(schemeCrudService.save(scheme)).thenReturn(scheme);
	SourceInputEntity source = ConcreteSource.builder().id(2l).build();
	
	when(sourceCrudService.findById(any(Long.class))).thenReturn(source);
	
	// when
	schemeServiceImpl.addSourceByIdToScheme(scheme, 2l);
	
	// then
	ArgumentCaptor<Long> sourceIdCaptor = ArgumentCaptor.forClass(Long.class);
	
	verify(schemeCrudService, times(1)).save(scheme);
	verify(sourceCrudService, times(1)).findById(sourceIdCaptor.capture());
	assertEquals(Long.valueOf(2l), sourceIdCaptor.getValue());
	assertEquals(1, scheme.getSources().size());
	assertTrue(scheme.getSources().contains(source));
    }

    @Test
    void testAddSourceByIdToSchemeById() {
	// given
	assertEquals(0, scheme.getSources().size());
	when(schemeCrudService.save(scheme)).thenReturn(scheme);
	SourceInputEntity source = ConcreteSource.builder().id(2l).build();
	when(schemeCrudService.findById(any(Long.class))).thenReturn(scheme);
	when(sourceCrudService.findById(any(Long.class))).thenReturn(source);
	
	// when
	schemeServiceImpl.addSourceByIdToSchemeById(1l, 2l);
	
	// then
	ArgumentCaptor<Long> schemeIdCaptor = ArgumentCaptor.forClass(Long.class);
	ArgumentCaptor<Long> sourceIdCaptor = ArgumentCaptor.forClass(Long.class);
	
	verify(schemeCrudService, times(1)).save(scheme);
	verify(sourceCrudService, times(1)).findById(sourceIdCaptor.capture());
	verify(schemeCrudService, times(1)).findById(schemeIdCaptor.capture());
	assertEquals(Long.valueOf(2l), sourceIdCaptor.getValue());
	assertEquals(Long.valueOf(2l), sourceIdCaptor.getValue());
	assertEquals(1, scheme.getSources().size());
	assertTrue(scheme.getSources().contains(source));
    }

    @Test
    void testAddSpecieToScheme() {
	// given
	assertEquals(0, scheme.getSpecies().size());
	when(schemeCrudService.save(scheme)).thenReturn(scheme);
	SpecieInputEntity specie = ConcreteSpecie.builder().build();
		
	// when
	schemeServiceImpl.addSpecieToScheme(scheme, specie);
	
	// then
	verify(schemeCrudService, times(1)).save(scheme);
	assertEquals(1, scheme.getSpecies().size());
	assertTrue(scheme.getSpecies().contains(specie));
    }

    @Test
    void testAddSpecieByIdToScheme() {
	// given
	assertEquals(0, scheme.getSpecies().size());
	when(schemeCrudService.save(scheme)).thenReturn(scheme);
	SpecieInputEntity specie = ConcreteSpecie.builder().id(2l).build();
	
	when(specieCrudService.findById(any(Long.class))).thenReturn(specie);
	
	// when
	schemeServiceImpl.addSpecieByIdToScheme(scheme, 2l);
	
	// then
	ArgumentCaptor<Long> specieIdCaptor = ArgumentCaptor.forClass(Long.class);
	
	verify(schemeCrudService, times(1)).save(scheme);
	verify(specieCrudService, times(1)).findById(specieIdCaptor.capture());
	assertEquals(Long.valueOf(2l), specieIdCaptor.getValue());
	assertEquals(1, scheme.getSpecies().size());
	assertTrue(scheme.getSpecies().contains(specie));
    }

    @Test
    void testAddSpecieByIdToSchemeById() {
	// given
	assertEquals(0, scheme.getSpecies().size());
	when(schemeCrudService.save(scheme)).thenReturn(scheme);
	SpecieInputEntity specie = ConcreteSpecie.builder().id(2l).build();
	when(schemeCrudService.findById(any(Long.class))).thenReturn(scheme);
	when(specieCrudService.findById(any(Long.class))).thenReturn(specie);
	
	// when
	schemeServiceImpl.addSpecieByIdToSchemeById(1l, 2l);
	
	// then
	ArgumentCaptor<Long> schemeIdCaptor = ArgumentCaptor.forClass(Long.class);
	ArgumentCaptor<Long> specieIdCaptor = ArgumentCaptor.forClass(Long.class);
	
	verify(schemeCrudService, times(1)).save(scheme);
	verify(specieCrudService, times(1)).findById(specieIdCaptor.capture());
	verify(schemeCrudService, times(1)).findById(schemeIdCaptor.capture());
	assertEquals(Long.valueOf(2l), specieIdCaptor.getValue());
	assertEquals(Long.valueOf(2l), specieIdCaptor.getValue());
	assertEquals(1, scheme.getSpecies().size());
	assertTrue(scheme.getSpecies().contains(specie));
    }

    @Test
    void testDeleteReactionFromScheme() {
	// given
	ReactionInputEntity reaction = ConcreteReaction.builder().build();
	Set<ReactionInputEntity> reactionSet = new HashSet<>();
	reactionSet.add(reaction);
	SchemeInputEntity scheme = SchemeInputEntity.builder().reactions(reactionSet).build();
	assertEquals(1, scheme.getReactions().size());
		
	// when
	schemeServiceImpl.deleteReactionFromScheme(scheme, reaction);
	
	// then
	verify(schemeCrudService, times(1)).save(scheme);
	assertEquals(0, scheme.getReactions().size());
    }

    @Test
    void testDeleteReactionByIdFromScheme() {
	// given
	ReactionInputEntity reaction = ConcreteReaction.builder().id(2L).build();
	Set<ReactionInputEntity> reactionSet = new HashSet<>();
	reactionSet.add(reaction);
	SchemeInputEntity scheme = SchemeInputEntity.builder().reactions(reactionSet).build();
	assertEquals(1, scheme.getReactions().size());
	when(reactionCrudService.findById(2L)).thenReturn(reaction);
		
	// when
	schemeServiceImpl.deleteReactionByIdFromScheme(scheme, 2L);
	
	// then
	verify(schemeCrudService, times(1)).save(scheme);
	assertEquals(0, scheme.getReactions().size());
    }

    @Test
    void testDeleteReactionByIdFromSchemeById() {
	// given
	ReactionInputEntity reaction = ConcreteReaction.builder().id(2L).build();
	Set<ReactionInputEntity> reactionSet = new HashSet<>();
	reactionSet.add(reaction);
	SchemeInputEntity scheme = SchemeInputEntity.builder().reactions(reactionSet).build();
	assertEquals(1, scheme.getReactions().size());
	when(reactionCrudService.findById(2L)).thenReturn(reaction);
	when(schemeCrudService.findById(1L)).thenReturn(scheme);
		
	// when
	schemeServiceImpl.deleteReactionByIdFromSchemeById(1L, 2L);
	
	// then
	verify(schemeCrudService, times(1)).save(scheme);
	assertEquals(0, scheme.getReactions().size());
    }

    @Test
    void testDeleteSourceFromScheme() {
	// given
	SourceInputEntity source = ConcreteSource.builder().build();
	Set<SourceInputEntity> sourceSet = new HashSet<>();
	sourceSet.add(source);
	SchemeInputEntity scheme = SchemeInputEntity.builder().sources(sourceSet).build();
	assertEquals(1, scheme.getSources().size());
		
	// when
	schemeServiceImpl.deleteSourceFromScheme(scheme, source);
	
	// then
	verify(schemeCrudService, times(1)).save(scheme);
	assertEquals(0, scheme.getSources().size());
    }

    @Test
    void testDeleteSourceByIdFromScheme() {
	// given
	SourceInputEntity source = ConcreteSource.builder().id(2L).build();
	Set<SourceInputEntity> sourceSet = new HashSet<>();
	sourceSet.add(source);
	SchemeInputEntity scheme = SchemeInputEntity.builder().sources(sourceSet).build();
	assertEquals(1, scheme.getSources().size());
	when(sourceCrudService.findById(2L)).thenReturn(source);
		
	// when
	schemeServiceImpl.deleteSourceByIdFromScheme(scheme, 2L);
	
	// then
	verify(schemeCrudService, times(1)).save(scheme);
	assertEquals(0, scheme.getSources().size());
    }

    @Test
    void testDeleteSourceByIdFromSchemeById() {
	// given
	SourceInputEntity source = ConcreteSource.builder().id(2L).build();
	Set<SourceInputEntity> sourceSet = new HashSet<>();
	sourceSet.add(source);
	SchemeInputEntity scheme = SchemeInputEntity.builder().sources(sourceSet).build();
	assertEquals(1, scheme.getSources().size());
	when(sourceCrudService.findById(2L)).thenReturn(source);
	when(schemeCrudService.findById(1L)).thenReturn(scheme);
		
	// when
	schemeServiceImpl.deleteSourceByIdFromSchemeById(1L, 2L);
	
	// then
	verify(schemeCrudService, times(1)).save(scheme);
	assertEquals(0, scheme.getSources().size());
    }

    @Test
    void testDeleteSpecieFromScheme() {
	// given
	SpecieInputEntity specie = ConcreteSpecie.builder().build();
	Set<SpecieInputEntity> specieSet = new HashSet<>();
	specieSet.add(specie);
	SchemeInputEntity scheme = SchemeInputEntity.builder().species(specieSet).build();
	assertEquals(1, scheme.getSpecies().size());
		
	// when
	schemeServiceImpl.deleteSpecieFromScheme(scheme, specie);
	
	// then
	verify(schemeCrudService, times(1)).save(scheme);
	assertEquals(0, scheme.getSpecies().size());
    }

    @Test
    void testDeleteSpecieByIdFromScheme() {
	// given
	SpecieInputEntity specie = ConcreteSpecie.builder().id(2L).build();
	Set<SpecieInputEntity> specieSet = new HashSet<>();
	specieSet.add(specie);
	SchemeInputEntity scheme = SchemeInputEntity.builder().species(specieSet).build();
	assertEquals(1, scheme.getSpecies().size());
	when(specieCrudService.findById(2L)).thenReturn(specie);
		
	// when
	schemeServiceImpl.deleteSpecieByIdFromScheme(scheme, 2L);
	
	// then
	verify(schemeCrudService, times(1)).save(scheme);
	assertEquals(0, scheme.getSpecies().size());
    }

    @Test
    void testDeleteSpecieByIdFromSchemeById() {
	// given
	SpecieInputEntity specie = ConcreteSpecie.builder().id(2L).build();
	Set<SpecieInputEntity> specieSet = new HashSet<>();
	specieSet.add(specie);
	SchemeInputEntity scheme = SchemeInputEntity.builder().species(specieSet).build();
	assertEquals(1, scheme.getSpecies().size());
	when(specieCrudService.findById(2L)).thenReturn(specie);
	when(schemeCrudService.findById(1L)).thenReturn(scheme);
		
	// when
	schemeServiceImpl.deleteSpecieByIdFromSchemeById(1L, 2L);
	
	// then
	verify(schemeCrudService, times(1)).save(scheme);
	assertEquals(0, scheme.getSpecies().size());
    }

    @Test
    void testAddReactionSetToScheme() {
	// given
	assertEquals(0, scheme.getReactions().size());
	when(schemeCrudService.save(scheme)).thenReturn(scheme);
	Set<ReactionInputEntity> reactionSet = new HashSet<>();
	ReactionInputEntity reaction1 = ConcreteReaction.builder().build();
	reactionSet.add(reaction1);
	ReactionInputEntity reaction2 = ConcreteReaction.builder().build();
	reactionSet.add(reaction2);
		
	// when
	schemeServiceImpl.addReactionSetToScheme(scheme, reactionSet);
	
	// then
	verify(schemeCrudService, times(1)).save(scheme);
	assertEquals(2, scheme.getReactions().size());
	assertTrue(scheme.getReactions().contains(reaction1));
	assertTrue(scheme.getReactions().contains(reaction2));
    }

    @Test
    void testAddSourceSetToScheme() {
	// given
	assertEquals(0, scheme.getSources().size());
	when(schemeCrudService.save(scheme)).thenReturn(scheme);
	Set<SourceInputEntity> sourceSet = new HashSet<>();
	SourceInputEntity source1 = ConcreteSource.builder().build();
	sourceSet.add(source1);
	SourceInputEntity source2 = ConcreteSource.builder().build();
	sourceSet.add(source2);
		
	// when
	schemeServiceImpl.addSourceSetToScheme(scheme, sourceSet);
	
	// then
	verify(schemeCrudService, times(1)).save(scheme);
	assertEquals(2, scheme.getSources().size());
	assertTrue(scheme.getSources().contains(source1));
	assertTrue(scheme.getSources().contains(source2));
    }

    @Test
    void testAddSpecieSetToScheme() {
	// given
	assertEquals(0, scheme.getSpecies().size());
	when(schemeCrudService.save(scheme)).thenReturn(scheme);
	Set<SpecieInputEntity> specieSet = new HashSet<>();
	SpecieInputEntity specie1 = ConcreteSpecie.builder().build();
	specieSet.add(specie1);
	SpecieInputEntity specie2 = ConcreteSpecie.builder().build();
	specieSet.add(specie2);
		
	// when
	schemeServiceImpl.addSpecieSetToScheme(scheme, specieSet);
	
	// then
	verify(schemeCrudService, times(1)).save(scheme);
	assertEquals(2, scheme.getSpecies().size());
	assertTrue(scheme.getSpecies().contains(specie1));
	assertTrue(scheme.getSpecies().contains(specie2));
    }

}
