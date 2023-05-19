package com.science.earth.biogeochemistry.freshwaters.PANDORA.services.entityservices.implementations;

import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.PANDORA.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.model.Specie;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.services.entityservices.interfaces.SpecieService;

@Service
public class SpecieServiceImpl extends AbstractBaseEntityServiceImpl<Specie> implements SpecieService {

    public SpecieServiceImpl(ErrorMessageGenerator errorMessageGenerator) {
	super(errorMessageGenerator);
    }
}    
