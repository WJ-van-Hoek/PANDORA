package com.science.earth.biogeochemistry.freshwaters.pandora.services.test;

import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.pandora.repositories.AbstractBaseDBEntityRepository;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.implementations.AbstractCrudServiceImpl;

public class ConcreteCrudServiceImpl
        extends AbstractCrudServiceImpl<ConcreteBaseEntity, Long, AbstractBaseDBEntityRepository<ConcreteBaseEntity>> {
    protected ConcreteCrudServiceImpl(final AbstractBaseDBEntityRepository<ConcreteBaseEntity> repository,
            final ErrorMessageGenerator errorMessageGenerator) {
        super(repository, errorMessageGenerator);
    }
}
