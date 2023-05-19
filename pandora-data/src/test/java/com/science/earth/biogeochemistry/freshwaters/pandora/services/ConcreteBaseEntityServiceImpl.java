package com.science.earth.biogeochemistry.freshwaters.pandora.services;

import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.AbstractBaseEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.entityservices.implementations.AbstractBaseEntityServiceImpl;

class ConcreteBaseEntityServiceImpl extends AbstractBaseEntityServiceImpl<AbstractBaseEntity> {
    protected ConcreteBaseEntityServiceImpl(ErrorMessageGenerator errorMessageGenerator) {
	super(errorMessageGenerator);
    }
}
