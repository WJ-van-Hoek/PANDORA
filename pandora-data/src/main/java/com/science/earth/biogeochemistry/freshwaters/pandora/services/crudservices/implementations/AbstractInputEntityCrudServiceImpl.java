package com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.implementations;

import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.AbstractInputEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.repositories.AbstractInputEntityRepository;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.interfaces.AbstractInputEntityCrudService;

@Service
public class AbstractInputEntityCrudServiceImpl<T extends AbstractInputEntity>
	extends AbstractBaseEntityCrudServiceImpl<T, AbstractInputEntityRepository<T>>
	implements AbstractInputEntityCrudService<T> {

    protected AbstractInputEntityCrudServiceImpl(AbstractInputEntityRepository<T> repository,
	    ErrorMessageGenerator errorMessageGenerator) {
	super(repository, errorMessageGenerator);
    }

}
