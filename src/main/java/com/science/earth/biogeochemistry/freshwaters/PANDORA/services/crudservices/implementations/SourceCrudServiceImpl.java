package com.science.earth.biogeochemistry.freshwaters.PANDORA.services.crudservices.implementations;

import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.PANDORA.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.model.Source;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.repositories.SourceRepository;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.services.crudservices.interfaces.SourceCrudService;

@Service
public class SourceCrudServiceImpl extends AbstractBaseEntityCrudServiceImpl<Source, SourceRepository<Source>>
	implements SourceCrudService {

    protected SourceCrudServiceImpl(SourceRepository<Source> repository, ErrorMessageGenerator errorMessageGenerator) {
	super(repository, errorMessageGenerator);
    }

}
