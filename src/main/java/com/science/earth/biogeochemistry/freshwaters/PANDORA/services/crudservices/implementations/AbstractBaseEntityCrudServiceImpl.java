package com.science.earth.biogeochemistry.freshwaters.PANDORA.services.crudservices.implementations;

import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.PANDORA.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.model.AbstractBaseEntity;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.repositories.AbstractBaseEntityRepository;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.services.crudservices.interfaces.AbstractBaseEntityCrudService;

@Service
public abstract class AbstractBaseEntityCrudServiceImpl<T extends AbstractBaseEntity, R extends AbstractBaseEntityRepository<T>>
	extends AbstractCrudServiceImpl<T, Long, R> implements AbstractBaseEntityCrudService<T> {

    protected AbstractBaseEntityCrudServiceImpl(R repository, ErrorMessageGenerator errorMessageGenerator) {
	super(repository, errorMessageGenerator);
    }



}