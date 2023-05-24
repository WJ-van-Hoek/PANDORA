package com.science.earth.biogeochemistry.freshwaters.pandora.services.entityservices.implementations;

import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.SourceInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.entityservices.interfaces.SourceService;

@Service
public class SourceServiceImpl extends AbstractBaseEntityServiceImpl<SourceInputEntity> implements SourceService {

    public SourceServiceImpl(ErrorMessageGenerator errorMessageGenerator) {
	super(errorMessageGenerator);
    }

}
