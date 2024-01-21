package com.pandora.services.crudservices.implementations;

import org.springframework.stereotype.Service;

import com.pandora.errors.ErrorMessageGenerator;
import com.pandora.model.CellDBEntity;
import com.pandora.repositories.CellDBEntityRepository;
import com.pandora.services.crudservices.interfaces.CellDBEntityCrudService;

@Service
public class CellDBEntityCrudServiceImpl extends AbstractBaseEntityCrudServiceImpl<CellDBEntity, CellDBEntityRepository>
        implements CellDBEntityCrudService {

    protected CellDBEntityCrudServiceImpl(final CellDBEntityRepository repository,
            final ErrorMessageGenerator errorMessageGenerator) {

        super(repository, errorMessageGenerator);
    }

}
