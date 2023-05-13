package com.science.earth.biogeochemistry.freshwaters.PANDORA.services;

import com.science.earth.biogeochemistry.freshwaters.PANDORA.model.AbstractBaseEntity;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.repositories.AbstractBaseEntityRepository;

public abstract class AbstractBaseEntityServiceImpl<T extends AbstractBaseEntity, R extends AbstractBaseEntityRepository<T>>
	extends AbstractCrudServiceImpl<T, Long, R> implements AbstractBaseEntityService<T> {

    protected AbstractBaseEntityServiceImpl(R repository) {
	super(repository);
    }

    @Override
    public void nullCheck(T baseEntity) {
	if (baseEntity == null) {
	    throw new RuntimeException("Entity can not be null");
	}
    }

}