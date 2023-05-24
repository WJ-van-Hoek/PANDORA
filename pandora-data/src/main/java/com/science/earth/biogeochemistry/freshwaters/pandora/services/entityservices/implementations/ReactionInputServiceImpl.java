package com.science.earth.biogeochemistry.freshwaters.pandora.services.entityservices.implementations;

import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.ReactionInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.entityservices.interfaces.ReactionInputService;

@Service
public class ReactionInputServiceImpl extends AbstractInputEntityServiceImpl<ReactionInputEntity> implements ReactionInputService {

    public ReactionInputServiceImpl(ErrorMessageGenerator errorMessageGenerator) {
	super(errorMessageGenerator);
    }

}
