package com.science.earth.biogeochemistry.freshwaters.pandora.services.entityservices.implementations;

import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.SpecieInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.entityservices.interfaces.SpecieService;

@Service
public class SpecieServiceImpl extends AbstractBaseEntityServiceImpl<SpecieInputEntity> implements SpecieService {

    public SpecieServiceImpl(ErrorMessageGenerator errorMessageGenerator) {
	super(errorMessageGenerator);
    }
}    
