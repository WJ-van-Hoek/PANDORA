package com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.implementations;

import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.SchemeInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.repositories.SchemeInputRepository;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.interfaces.SchemeCrudService;

@Service
public class SchemeInputCrudServiceImpl extends AbstractBaseEntityCrudServiceImpl<SchemeInputEntity, SchemeInputRepository<SchemeInputEntity>>
	implements SchemeCrudService {

    protected SchemeInputCrudServiceImpl(SchemeInputRepository<SchemeInputEntity> repository, ErrorMessageGenerator errorMessageGenerator) {
	super(repository, errorMessageGenerator);
    }

}
