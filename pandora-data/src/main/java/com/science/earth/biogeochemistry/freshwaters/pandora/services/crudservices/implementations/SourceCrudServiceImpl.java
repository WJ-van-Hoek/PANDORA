package com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.implementations;

import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.Source;
import com.science.earth.biogeochemistry.freshwaters.pandora.repositories.SourceRepository;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.interfaces.SourceCrudService;

@Service
public class SourceCrudServiceImpl extends AbstractBaseEntityCrudServiceImpl<Source, SourceRepository<Source>>
	implements SourceCrudService {

    protected SourceCrudServiceImpl(SourceRepository<Source> repository, ErrorMessageGenerator errorMessageGenerator) {
	super(repository, errorMessageGenerator);
    }

}
