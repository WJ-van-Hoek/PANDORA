package com.science.earth.biogeochemistry.freshwaters.pandora.services.test;

import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.AbstractBaseDBEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.entityservices.implementations.AbstractBaseEntityServiceImpl;

class ConcreteBaseEntityServiceImpl extends AbstractBaseEntityServiceImpl<AbstractBaseDBEntity> {
    protected ConcreteBaseEntityServiceImpl(final ErrorMessageGenerator errorMessageGenerator) {
        super(errorMessageGenerator);
    }
}
