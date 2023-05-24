package com.science.earth.biogeochemistry.freshwaters.pandora.services.entityservices.implementations;

import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.results.AbstractResultEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.entityservices.interfaces.ResultEntityService;

public class ResultEntityServiceImpl extends AbstractBaseEntityServiceImpl<AbstractResultEntity>
	implements ResultEntityService {

    public ResultEntityServiceImpl(ErrorMessageGenerator errorMessageGenerator) {
	super(errorMessageGenerator);
    }

}
