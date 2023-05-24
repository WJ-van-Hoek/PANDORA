package com.science.earth.biogeochemistry.freshwaters.pandora.services.entityservices.implementations;

import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.SpecieInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.entityservices.interfaces.SpecieInputService;

@Service
public class SpecieInputServiceImpl extends AbstractInputEntityServiceImpl<SpecieInputEntity> implements SpecieInputService {

    public SpecieInputServiceImpl(ErrorMessageGenerator errorMessageGenerator) {
	super(errorMessageGenerator);
    }
}    
