package com.pandora.services.test;

import com.pandora.errors.ErrorMessageGenerator;
import com.pandora.repositories.AbstractBaseDBEntityRepository;
import com.pandora.services.crudservices.implementations.AbstractCrudServiceImpl;

public class ConcreteCrudServiceImpl
        extends AbstractCrudServiceImpl<ConcreteBaseEntity, Long, AbstractBaseDBEntityRepository<ConcreteBaseEntity>> {
    protected ConcreteCrudServiceImpl(final AbstractBaseDBEntityRepository<ConcreteBaseEntity> repository,
            final ErrorMessageGenerator errorMessageGenerator) {
        super(repository, errorMessageGenerator);
    }
}
