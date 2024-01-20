package com.pandora.services.crudservices.implementations;

import org.springframework.stereotype.Service;

import com.pandora.errors.ErrorMessageGenerator;
import com.pandora.model.AbstractBaseDBEntity;
import com.pandora.repositories.AbstractBaseDBEntityRepository;
import com.pandora.services.crudservices.interfaces.AbstractBaseEntityCrudService;

@Service
public abstract class AbstractBaseEntityCrudServiceImpl
    <T extends AbstractBaseDBEntity, R extends AbstractBaseDBEntityRepository<T>>
        extends AbstractCrudServiceImpl<T, Long, R> implements AbstractBaseEntityCrudService<T> {

    protected AbstractBaseEntityCrudServiceImpl(final R repository, final ErrorMessageGenerator errorMessageGenerator) {
        super(repository, errorMessageGenerator);
    }

}
