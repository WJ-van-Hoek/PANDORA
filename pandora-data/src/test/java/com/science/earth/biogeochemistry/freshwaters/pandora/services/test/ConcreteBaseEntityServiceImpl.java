package com.pandora.services.test;

import com.pandora.errors.ErrorMessageGenerator;
import com.pandora.model.AbstractBaseDBEntity;
import com.pandora.services.entityservices.implementations.AbstractBaseEntityServiceImpl;

class ConcreteBaseEntityServiceImpl extends AbstractBaseEntityServiceImpl<AbstractBaseDBEntity> {
    protected ConcreteBaseEntityServiceImpl(final ErrorMessageGenerator errorMessageGenerator) {
        super(errorMessageGenerator);
    }
}
