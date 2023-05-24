package com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.implementations;

import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.SchemeInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.repositories.SchemeRepository;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.interfaces.SchemeCrudService;

@Service
public class SchemeCrudServiceImpl extends AbstractBaseEntityCrudServiceImpl<SchemeInputEntity, SchemeRepository<SchemeInputEntity>>
	implements SchemeCrudService {

    protected SchemeCrudServiceImpl(SchemeRepository<SchemeInputEntity> repository, ErrorMessageGenerator errorMessageGenerator) {
	super(repository, errorMessageGenerator);
    }

}
