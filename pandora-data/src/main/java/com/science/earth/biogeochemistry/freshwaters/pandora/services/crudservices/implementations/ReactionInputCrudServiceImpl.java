package com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.implementations;

import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.ReactionInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.repositories.ReactionInputRepository;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.interfaces.ReactionCrudService;

@Service
public class ReactionInputCrudServiceImpl extends AbstractBaseEntityCrudServiceImpl<ReactionInputEntity, ReactionInputRepository<ReactionInputEntity>>
	implements ReactionCrudService {

    protected ReactionInputCrudServiceImpl(ReactionInputRepository<ReactionInputEntity> repository,
	    ErrorMessageGenerator errorMessageGenerator) {
	super(repository, errorMessageGenerator);
    }
}
