package com.science.earth.biogeochemistry.freshwaters.PANDORA.services;

import com.science.earth.biogeochemistry.freshwaters.PANDORA.model.AbstractBaseEntity;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.repositories.AbstractBaseEntityRepository;

class ConcreteBaseEntityServiceImpl extends AbstractBaseEntityServiceImpl<AbstractBaseEntity, AbstractBaseEntityRepository<AbstractBaseEntity>> {
	protected ConcreteBaseEntityServiceImpl(AbstractBaseEntityRepository<AbstractBaseEntity> repository) {
	    super(repository);
	}
}
