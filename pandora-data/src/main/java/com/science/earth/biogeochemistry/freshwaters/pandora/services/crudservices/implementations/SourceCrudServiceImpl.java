package com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.implementations;

import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.SourceInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.repositories.SourceRepository;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.interfaces.SourceCrudService;

@Service
public class SourceCrudServiceImpl extends AbstractBaseEntityCrudServiceImpl<SourceInputEntity, SourceRepository<SourceInputEntity>>
	implements SourceCrudService {

    protected SourceCrudServiceImpl(SourceRepository<SourceInputEntity> repository, ErrorMessageGenerator errorMessageGenerator) {
	super(repository, errorMessageGenerator);
    }

}
