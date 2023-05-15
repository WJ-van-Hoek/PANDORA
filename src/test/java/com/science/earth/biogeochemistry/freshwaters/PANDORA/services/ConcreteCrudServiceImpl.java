package com.science.earth.biogeochemistry.freshwaters.PANDORA.services;

import com.science.earth.biogeochemistry.freshwaters.PANDORA.repositories.AbstractBaseEntityRepository;

public class ConcreteCrudServiceImpl
	extends AbstractCrudServiceImpl<ConcreteBaseEntity, Long, AbstractBaseEntityRepository<ConcreteBaseEntity>> {
    protected ConcreteCrudServiceImpl(AbstractBaseEntityRepository<ConcreteBaseEntity> repository) {
	super(repository);
    }
}
