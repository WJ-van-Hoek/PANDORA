package com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.implementations;

import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.CellDBEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.repositories.CellDBEntityRepository;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.interfaces.CellDBEntityCrudService;

@Service
public class CellDBEntityCrudServiceImpl extends AbstractBaseEntityCrudServiceImpl<CellDBEntity, CellDBEntityRepository>
        implements CellDBEntityCrudService {

    protected CellDBEntityCrudServiceImpl(final CellDBEntityRepository repository,
            final ErrorMessageGenerator errorMessageGenerator) {

        super(repository, errorMessageGenerator);
    }

}
