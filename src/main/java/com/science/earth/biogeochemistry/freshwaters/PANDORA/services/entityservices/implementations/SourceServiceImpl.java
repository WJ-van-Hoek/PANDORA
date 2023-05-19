package com.science.earth.biogeochemistry.freshwaters.PANDORA.services.entityservices.implementations;

import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.PANDORA.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.model.Source;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.services.entityservices.interfaces.SourceService;

@Service
public class SourceServiceImpl extends AbstractBaseEntityServiceImpl<Source> implements SourceService {

    public SourceServiceImpl(ErrorMessageGenerator errorMessageGenerator) {
	super(errorMessageGenerator);
    }

}
