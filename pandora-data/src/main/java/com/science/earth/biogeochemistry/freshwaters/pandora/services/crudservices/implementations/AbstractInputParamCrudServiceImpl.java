package com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.implementations;

import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.params.AbstractInputParam;
import com.science.earth.biogeochemistry.freshwaters.pandora.repositories.AbstractInputParamRepository;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.interfaces.AbstractInputParamCrudService;

@SuppressWarnings("rawtypes")
@Service
public abstract class AbstractInputParamCrudServiceImpl<T extends AbstractInputParam>
	extends AbstractBaseEntityCrudServiceImpl<T, AbstractInputParamRepository<T>>
	implements AbstractInputParamCrudService<T> {

    protected AbstractInputParamCrudServiceImpl(AbstractInputParamRepository<T> repository,
	    ErrorMessageGenerator errorMessageGenerator) {
	super(repository, errorMessageGenerator);
    }

}
