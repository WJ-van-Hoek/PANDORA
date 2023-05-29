package com.science.earth.biogeochemistry.freshwaters.pandora.services;

import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.params.AbstractInputParam;
import com.science.earth.biogeochemistry.freshwaters.pandora.repositories.AbstractInputParamRepository;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.implementations.AbstractInputParamCrudServiceImpl;

public class ConcreteInputParamCrudServiceImpl<T extends AbstractInputParam> extends AbstractInputParamCrudServiceImpl<T> {

    protected ConcreteInputParamCrudServiceImpl(AbstractInputParamRepository<T> repository,
	    ErrorMessageGenerator errorMessageGenerator) {
	super(repository, errorMessageGenerator);
    }

}
