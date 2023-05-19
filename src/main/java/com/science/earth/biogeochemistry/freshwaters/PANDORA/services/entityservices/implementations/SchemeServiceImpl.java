package com.science.earth.biogeochemistry.freshwaters.PANDORA.services.entityservices.implementations;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.PANDORA.errors.CrudError;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.errors.ServiceImplError;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.model.Reaction;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.model.Scheme;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.model.Source;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.model.Specie;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.services.crudservices.interfaces.ReactionCrudService;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.services.crudservices.interfaces.SchemeCrudService;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.services.crudservices.interfaces.SourceCrudService;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.services.crudservices.interfaces.SpecieCrudService;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.services.entityservices.interfaces.ReactionService;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.services.entityservices.interfaces.SchemeService;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.services.entityservices.interfaces.SourceService;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.services.entityservices.interfaces.SpecieService;

@Service
public class SchemeServiceImpl extends AbstractBaseEntityServiceImpl<Scheme> implements SchemeService {

    @Autowired
    SchemeCrudService schemeCrudService;

    @Autowired
    ReactionCrudService reactionCrudService;

    @Autowired
    ReactionService reactionService;

    @Autowired
    SourceCrudService sourceCrudService;

    @Autowired
    SourceService sourceService;

    @Autowired
    SpecieCrudService specieCrudService;

    @Autowired
    SpecieService specieService;

    protected SchemeServiceImpl(SchemeCrudService schemeCrudService, ReactionCrudService reactionCrudService,
	    ReactionService reactionService, SourceCrudService sourceCrudService, SourceService sourceService,
	    SpecieCrudService specieCrudService, SpecieService specieService,
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

    public Scheme safeSave(Scheme scheme) {
	try {
	    return schemeCrudService.save(scheme);
	} catch (CrudError e) {
	    throw new ServiceImplError(
		    errorMessageGenerator.generate("concrete.crud.service.object.null", getGenericType()));
	}
    }

    @Override
    public void addReactionToScheme(Scheme scheme, Reaction reaction) {
	scheme.getReactions().add(reaction);
	safeSave(scheme);
    }

    @Override
    public void addReactionByIdToScheme(Scheme scheme, Long reactionId) {
	Reaction reaction = reactionCrudService.findById(reactionId);
	addReactionToScheme(scheme, reaction);
    }

    @Override
    public void addReactionByIdToSchemeById(Long schemeId, Long reactionId) {
	Scheme scheme = schemeCrudService.findById(schemeId);
	addReactionByIdToScheme(scheme, reactionId);
    }

    @Override
    public void addSourceToScheme(Scheme scheme, Source source) {
	scheme.getSources().add(source);
	safeSave(scheme);
    }

    @Override
    public void addSourceByIdToScheme(Scheme scheme, Long sourceId) {
	Source source = sourceCrudService.findById(sourceId);
	addSourceToScheme(scheme, source);
    }

    @Override
    public void addSourceByIdToSchemeById(Long schemeId, Long sourceId) {
	Scheme scheme = schemeCrudService.findById(schemeId);
	addSourceByIdToScheme(scheme, sourceId);
    }

    @Override
    public void addSpecieToScheme(Scheme scheme, Specie specie) {
	scheme.getSpecies().add(specie);
	safeSave(scheme);
    }

    @Override
    public void addSpecieByIdToScheme(Scheme scheme, Long specieId) {
	Specie specie = specieCrudService.findById(specieId);
	addSpecieToScheme(scheme, specie);
    }

    @Override
    public void addSpecieByIdToSchemeById(Long schemeId, Long specieId) {
	Scheme scheme = schemeCrudService.findById(schemeId);
	addSpecieByIdToScheme(scheme, specieId);
    }

    @Override
    public void deleteReactionFromScheme(Scheme scheme, Reaction reaction) {
	scheme.getReactions().remove(reaction);
	safeSave(scheme);
    }

    @Override
    public void deleteReactionByIdFromScheme(Scheme scheme, Long reactionId) {
	Reaction reaction = reactionCrudService.findById(reactionId);
	deleteReactionFromScheme(scheme, reaction);
    }

    @Override
    public void deleteReactionByIdFromSchemeById(Long schemeId, Long reactionId) {
	Scheme scheme = schemeCrudService.findById(schemeId);
	deleteReactionByIdFromScheme(scheme, reactionId);
    }

    @Override
    public void deleteSourceFromScheme(Scheme scheme, Source source) {
	scheme.getSources().remove(source);
	safeSave(scheme);
    }

    @Override
    public void deleteSourceByIdFromScheme(Scheme scheme, Long sourceId) {
	Source source = sourceCrudService.findById(sourceId);
	deleteSourceFromScheme(scheme, source);
    }

    @Override
    public void deleteSourceByIdFromSchemeById(Long schemeId, Long sourceId) {
	Scheme scheme = schemeCrudService.findById(schemeId);
	deleteSourceByIdFromScheme(scheme, sourceId);
    }

    @Override
    public void deleteSpecieFromScheme(Scheme scheme, Specie specie) {
	scheme.getSpecies().remove(specie);
	safeSave(scheme);
    }

    @Override
    public void deleteSpecieByIdFromScheme(Scheme scheme, Long specieId) {
	Specie specie = specieCrudService.findById(specieId);
	deleteSpecieFromScheme(scheme, specie);
    }

    @Override
    public void deleteSpecieByIdFromSchemeById(Long schemeId, Long specieId) {
	Scheme scheme = schemeCrudService.findById(schemeId);
	deleteSpecieByIdFromScheme(scheme, specieId);
    }

    @Override
    public void addReactionSetToScheme(Scheme scheme, Set<Reaction> reactions) {
	scheme.getReactions().addAll(reactions);
	safeSave(scheme);
    }

    @Override
    public void addSourceSetToScheme(Scheme scheme, Set<Source> sources) {
	scheme.getSources().addAll(sources);
	safeSave(scheme);
    }

    @Override
    public void addSpecieSetToScheme(Scheme scheme, Set<Specie> species) {
	scheme.getSpecies().addAll(species);
	safeSave(scheme);
    }

}
