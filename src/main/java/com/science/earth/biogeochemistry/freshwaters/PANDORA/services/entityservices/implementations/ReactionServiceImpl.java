package com.science.earth.biogeochemistry.freshwaters.PANDORA.services.entityservices.implementations;

import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.PANDORA.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.model.Reaction;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.services.entityservices.interfaces.ReactionService;

@Service
public class ReactionServiceImpl extends AbstractBaseEntityServiceImpl<Reaction> implements ReactionService {

    public ReactionServiceImpl(ErrorMessageGenerator errorMessageGenerator) {
	super(errorMessageGenerator);
    }

}
