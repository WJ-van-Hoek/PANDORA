package com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.implementations;

import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.ReactionInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.repositories.ReactionRepository;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.interfaces.ReactionCrudService;

@Service
public class ReactionCrudServiceImpl extends AbstractBaseEntityCrudServiceImpl<ReactionInputEntity, ReactionRepository<ReactionInputEntity>>
	implements ReactionCrudService {

    protected ReactionCrudServiceImpl(ReactionRepository<ReactionInputEntity> repository,
	    ErrorMessageGenerator errorMessageGenerator) {
	super(repository, errorMessageGenerator);
    }
}
