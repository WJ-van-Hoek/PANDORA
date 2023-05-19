package com.science.earth.biogeochemistry.freshwaters.PANDORA.services;

import com.science.earth.biogeochemistry.freshwaters.PANDORA.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.model.AbstractBaseEntity;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.repositories.AbstractBaseEntityRepository;
import com.science.earth.biogeochemistry.freshwaters.PANDORA.services.crudservices.implementations.AbstractBaseEntityServiceImpl;

class ConcreteBaseEntityServiceImpl extends AbstractBaseEntityServiceImpl<AbstractBaseEntity, AbstractBaseEntityRepository<AbstractBaseEntity>> {
	protected ConcreteBaseEntityServiceImpl(AbstractBaseEntityRepository<AbstractBaseEntity> repository, ErrorMessageGenerator errorMessageGenerator) {
	    super(repository, errorMessageGenerator);
	}
}
