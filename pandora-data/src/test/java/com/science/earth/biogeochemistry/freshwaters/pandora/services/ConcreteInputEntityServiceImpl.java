package com.science.earth.biogeochemistry.freshwaters.pandora.services;

import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.AbstractInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.entityservices.implementations.AbstractInputEntityServiceImpl;

public class ConcreteInputEntityServiceImpl<T extends AbstractInputEntity> extends AbstractInputEntityServiceImpl<T> {
    protected ConcreteInputEntityServiceImpl(ErrorMessageGenerator errorMessageGenerator) {
	super(errorMessageGenerator);
    }
}
