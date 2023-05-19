package com.science.earth.biogeochemistry.freshwaters.PANDORA.services.crudservices.implementations;

import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.PANDORA.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.model.Scheme;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.repositories.SchemeRepository;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.services.crudservices.interfaces.SchemeCrudService;

@Service
public class SchemeCrudServiceImpl extends AbstractBaseEntityCrudServiceImpl<Scheme, SchemeRepository<Scheme>>
	implements SchemeCrudService {

    protected SchemeCrudServiceImpl(SchemeRepository<Scheme> repository, ErrorMessageGenerator errorMessageGenerator) {
	super(repository, errorMessageGenerator);
    }

}
