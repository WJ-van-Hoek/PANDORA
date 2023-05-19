package com.science.earth.biogeochemistry.freshwaters.PANDORA.services;

import com.science.earth.biogeochemistry.freshwaters.PANDORA.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.model.AbstractBaseEntity;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.services.entityservices.implementations.AbstractBaseEntityServiceImpl;

class ConcreteBaseEntityServiceImpl extends AbstractBaseEntityServiceImpl<AbstractBaseEntity> {
    protected ConcreteBaseEntityServiceImpl(ErrorMessageGenerator errorMessageGenerator) {
	super(errorMessageGenerator);
    }
}
