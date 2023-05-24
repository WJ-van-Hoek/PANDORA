package com.science.earth.biogeochemistry.freshwaters.pandora.services.entityservices.implementations;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.errors.CrudError;
import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ServiceImplError;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.ReactionInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.SchemeInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.SourceInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.SpecieInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.interfaces.ReactionCrudService;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.interfaces.SchemeCrudService;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.interfaces.SourceCrudService;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.interfaces.SpecieCrudService;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.entityservices.interfaces.ReactionInputService;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.entityservices.interfaces.SchemeInputService;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.entityservices.interfaces.SourceInputService;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.entityservices.interfaces.SpecieInputService;

@Service
public class SchemeInputServiceImpl extends AbstractBaseEntityServiceImpl<SchemeInputEntity> implements SchemeInputService {

    @Autowired
    SchemeCrudService schemeCrudService;

    @Autowired
    ReactionCrudService reactionCrudService;

    @Autowired
    ReactionInputService reactionService;

    @Autowired
    SourceCrudService sourceCrudService;

    @Autowired
    SourceInputService sourceService;

    @Autowired
    SpecieCrudService specieCrudService;

    @Autowired
    SpecieInputService specieService;

    protected SchemeInputServiceImpl(SchemeCrudService schemeCrudService, ReactionCrudService reactionCrudService,
	    ReactionInputService reactionService, SourceCrudService sourceCrudService, SourceInputService sourceService,
	    SpecieCrudService specieCrudService, SpecieInputService specieService,
	    ErrorMessageGenerator errorMessageGenerator) {
	super(errorMessageGenerator);
	this.schemeCrudService = schemeCrudService;
	this.reactionCrudService = reactionCrudService;
	this.reactionService = reactionService;
	this.sourceCrudService = sourceCrudService;
	this.sourceService = sourceService;
	this.specieCrudService = specieCrudService;
	this.specieService = specieService;
    }

    public SchemeInputEntity safeSave(SchemeInputEntity scheme) {
	try {
	    return schemeCrudService.save(scheme);
	} catch (CrudError e) {
	    throw new ServiceImplError(
		    errorMessageGenerator.generate("concrete.crud.service.object.null", getGenericType()));
	}
    }

    @Override
    public void addReactionToScheme(SchemeInputEntity scheme, ReactionInputEntity reaction) {
	scheme.getReactions().add(reaction);
	safeSave(scheme);
    }

    @Override
    public void addReactionByIdToScheme(SchemeInputEntity scheme, Long reactionId) {
	ReactionInputEntity reaction = reactionCrudService.findById(reactionId);
	addReactionToScheme(scheme, reaction);
    }

    @Override
    public void addReactionByIdToSchemeById(Long schemeId, Long reactionId) {
	SchemeInputEntity scheme = schemeCrudService.findById(schemeId);
	addReactionByIdToScheme(scheme, reactionId);
    }

    @Override
    public void addSourceToScheme(SchemeInputEntity scheme, SourceInputEntity source) {
	scheme.getSources().add(source);
	safeSave(scheme);
    }

    @Override
    public void addSourceByIdToScheme(SchemeInputEntity scheme, Long sourceId) {
	SourceInputEntity source = sourceCrudService.findById(sourceId);
	addSourceToScheme(scheme, source);
    }

    @Override
    public void addSourceByIdToSchemeById(Long schemeId, Long sourceId) {
	SchemeInputEntity scheme = schemeCrudService.findById(schemeId);
	addSourceByIdToScheme(scheme, sourceId);
    }

    @Override
    public void addSpecieToScheme(SchemeInputEntity scheme, SpecieInputEntity specie) {
	scheme.getSpecies().add(specie);
	safeSave(scheme);
    }

    @Override
    public void addSpecieByIdToScheme(SchemeInputEntity scheme, Long specieId) {
	SpecieInputEntity specie = specieCrudService.findById(specieId);
	addSpecieToScheme(scheme, specie);
    }

    @Override
    public void addSpecieByIdToSchemeById(Long schemeId, Long specieId) {
	SchemeInputEntity scheme = schemeCrudService.findById(schemeId);
	addSpecieByIdToScheme(scheme, specieId);
    }

    @Override
    public void deleteReactionFromScheme(SchemeInputEntity scheme, ReactionInputEntity reaction) {
	scheme.getReactions().remove(reaction);
	safeSave(scheme);
    }

    @Override
    public void deleteReactionByIdFromScheme(SchemeInputEntity scheme, Long reactionId) {
	ReactionInputEntity reaction = reactionCrudService.findById(reactionId);
	deleteReactionFromScheme(scheme, reaction);
    }

    @Override
    public void deleteReactionByIdFromSchemeById(Long schemeId, Long reactionId) {
	SchemeInputEntity scheme = schemeCrudService.findById(schemeId);
	deleteReactionByIdFromScheme(scheme, reactionId);
    }

    @Override
    public void deleteSourceFromScheme(SchemeInputEntity scheme, SourceInputEntity source) {
	scheme.getSources().remove(source);
	safeSave(scheme);
    }

    @Override
    public void deleteSourceByIdFromScheme(SchemeInputEntity scheme, Long sourceId) {
	SourceInputEntity source = sourceCrudService.findById(sourceId);
	deleteSourceFromScheme(scheme, source);
    }

    @Override
    public void deleteSourceByIdFromSchemeById(Long schemeId, Long sourceId) {
	SchemeInputEntity scheme = schemeCrudService.findById(schemeId);
	deleteSourceByIdFromScheme(scheme, sourceId);
    }

    @Override
    public void deleteSpecieFromScheme(SchemeInputEntity scheme, SpecieInputEntity specie) {
	scheme.getSpecies().remove(specie);
	safeSave(scheme);
    }

    @Override
    public void deleteSpecieByIdFromScheme(SchemeInputEntity scheme, Long specieId) {
	SpecieInputEntity specie = specieCrudService.findById(specieId);
	deleteSpecieFromScheme(scheme, specie);
    }

    @Override
    public void deleteSpecieByIdFromSchemeById(Long schemeId, Long specieId) {
	SchemeInputEntity scheme = schemeCrudService.findById(schemeId);
	deleteSpecieByIdFromScheme(scheme, specieId);
    }

    @Override
    public void addReactionSetToScheme(SchemeInputEntity scheme, Set<ReactionInputEntity> reactions) {
	scheme.getReactions().addAll(reactions);
	safeSave(scheme);
    }

    @Override
    public void addSourceSetToScheme(SchemeInputEntity scheme, Set<SourceInputEntity> sources) {
	scheme.getSources().addAll(sources);
	safeSave(scheme);
    }

    @Override
    public void addSpecieSetToScheme(SchemeInputEntity scheme, Set<SpecieInputEntity> species) {
	scheme.getSpecies().addAll(species);
	safeSave(scheme);
    }

}
