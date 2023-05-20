package com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.implementations;

import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.Scheme;
import com.science.earth.biogeochemistry.freshwaters.pandora.repositories.SchemeRepository;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.interfaces.SchemeCrudService;

@Service
public class SchemeCrudServiceImpl extends AbstractBaseEntityCrudServiceImpl<Scheme, SchemeRepository<Scheme>>
	implements SchemeCrudService {

    protected SchemeCrudServiceImpl(SchemeRepository<Scheme> repository, ErrorMessageGenerator errorMessageGenerator) {
	super(repository, errorMessageGenerator);
    }

}
