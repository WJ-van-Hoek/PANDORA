package com.science.earth.biogeochemistry.freshwaters.pandora.services.entityservices.implementations;

import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.Reaction;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.entityservices.interfaces.ReactionService;

@Service
public class ReactionServiceImpl extends AbstractBaseEntityServiceImpl<Reaction> implements ReactionService {

    public ReactionServiceImpl(ErrorMessageGenerator errorMessageGenerator) {
	super(errorMessageGenerator);
    }

}
