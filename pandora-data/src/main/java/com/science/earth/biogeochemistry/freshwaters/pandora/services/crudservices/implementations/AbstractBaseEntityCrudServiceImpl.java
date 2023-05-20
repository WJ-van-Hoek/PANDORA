package com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.implementations;

import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.AbstractBaseEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.repositories.AbstractBaseEntityRepository;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.interfaces.AbstractBaseEntityCrudService;

@Service
public abstract class AbstractBaseEntityCrudServiceImpl<T extends AbstractBaseEntity, R extends AbstractBaseEntityRepository<T>>
	extends AbstractCrudServiceImpl<T, Long, R> implements AbstractBaseEntityCrudService<T> {

    protected AbstractBaseEntityCrudServiceImpl(R repository, ErrorMessageGenerator errorMessageGenerator) {
	super(repository, errorMessageGenerator);
    }



}