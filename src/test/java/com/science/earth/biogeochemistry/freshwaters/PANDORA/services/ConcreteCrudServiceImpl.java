package com.science.earth.biogeochemistry.freshwaters.PANDORA.services;

import com.science.earth.biogeochemistry.freshwaters.PANDORA.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.repositories.AbstractBaseEntityRepository;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.services.crudservices.implementations.AbstractCrudServiceImpl;

public class ConcreteCrudServiceImpl
	extends AbstractCrudServiceImpl<ConcreteBaseEntity, Long, AbstractBaseEntityRepository<ConcreteBaseEntity>> {
    protected ConcreteCrudServiceImpl(AbstractBaseEntityRepository<ConcreteBaseEntity> repository, ErrorMessageGenerator errorMessageGenerator) {
	super(repository, errorMessageGenerator);
    }
}
