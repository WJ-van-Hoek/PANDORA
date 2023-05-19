package com.science.earth.biogeochemistry.freshwaters.PANDORA.services.crudservices.implementations;

import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.PANDORA.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.model.Reaction;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.repositories.ReactionRepository;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.services.crudservices.interfaces.ReactionCrudService;

@Service
public class ReactionCrudServiceImpl extends AbstractBaseEntityCrudServiceImpl<Reaction, ReactionRepository<Reaction>>
	implements ReactionCrudService {

    protected ReactionCrudServiceImpl(ReactionRepository<Reaction> repository,
	    ErrorMessageGenerator errorMessageGenerator) {
	super(repository, errorMessageGenerator);
    }
}
