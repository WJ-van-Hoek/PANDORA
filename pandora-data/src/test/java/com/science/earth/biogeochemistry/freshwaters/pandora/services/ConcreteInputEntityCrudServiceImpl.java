package com.science.earth.biogeochemistry.freshwaters.pandora.services;

import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.AbstractInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.repositories.AbstractInputEntityRepository;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.implementations.AbstractInputEntityCrudServiceImpl;

public class ConcreteInputEntityCrudServiceImpl<T extends AbstractInputEntity> extends AbstractInputEntityCrudServiceImpl<T> {
    protected ConcreteInputEntityCrudServiceImpl(AbstractInputEntityRepository<T> repository,
	    ErrorMessageGenerator errorMessageGenerator) {
	super(repository, errorMessageGenerator);
    }

}
