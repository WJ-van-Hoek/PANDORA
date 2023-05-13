package com.science.earth.biogeochemistry.freshwaters.PANDORA.services;

import com.science.earth.biogeochemistry.freshwaters.PANDORA.model.AbstractBaseEntity;


public interface AbstractBaseEntityCrudService <T extends AbstractBaseEntity> extends CrudService<T, Long> {
	public void nullCheck(T baseEntity);

}
