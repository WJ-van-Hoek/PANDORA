package com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.implementations;

import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.SourceInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.repositories.SourceInputRepository;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.interfaces.SourceCrudService;

@Service
public class SourceInputCrudServiceImpl extends AbstractBaseEntityCrudServiceImpl<SourceInputEntity, SourceInputRepository<SourceInputEntity>>
	implements SourceCrudService {

    protected SourceInputCrudServiceImpl(SourceInputRepository<SourceInputEntity> repository, ErrorMessageGenerator errorMessageGenerator) {
	super(repository, errorMessageGenerator);
    }

}
