package com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.implementations;

import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.params.FloatInputParam;
import com.science.earth.biogeochemistry.freshwaters.pandora.repositories.FloatInputParamRepository;

public class FloatInputParamCrudServiceImpl extends AbstractInputParamCrudServiceImpl<FloatInputParam> {

    public FloatInputParamCrudServiceImpl(FloatInputParamRepository repository,
	    ErrorMessageGenerator errorMessageGenerator) {
	super(repository, errorMessageGenerator);
    }

}
