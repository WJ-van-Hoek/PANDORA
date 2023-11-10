package com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.implementations;

import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.AbstractBaseDBEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.repositories.AbstractBaseDBEntityRepository;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.interfaces.AbstractBaseEntityCrudService;

@Service
public abstract class AbstractBaseEntityCrudServiceImpl<T extends AbstractBaseDBEntity, R extends AbstractBaseDBEntityRepository<T>>
	extends AbstractCrudServiceImpl<T, Long, R> implements AbstractBaseEntityCrudService<T> {

    protected AbstractBaseEntityCrudServiceImpl(R repository, ErrorMessageGenerator errorMessageGenerator) {
	super(repository, errorMessageGenerator);
    }



}