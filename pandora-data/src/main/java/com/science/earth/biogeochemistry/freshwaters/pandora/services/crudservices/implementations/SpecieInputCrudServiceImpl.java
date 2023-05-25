package com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.implementations;

import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.SpecieInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.repositories.SpecieInputRepository;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.interfaces.SpecieCrudService;

@Service
public class SpecieInputCrudServiceImpl extends AbstractBaseEntityCrudServiceImpl<SpecieInputEntity, SpecieInputRepository<SpecieInputEntity>>
	implements SpecieCrudService {

    protected SpecieInputCrudServiceImpl(SpecieInputRepository<SpecieInputEntity> repository, ErrorMessageGenerator errorMessageGenerator) {
	super(repository, errorMessageGenerator);
    }

}
