package com.science.earth.biogeochemistry.freshwaters.pandora.repositories;

import org.springframework.data.repository.CrudRepository;

import com.science.earth.biogeochemistry.freshwaters.pandora.model.AbstractBaseEntity;

public interface AbstractBaseEntityRepository<T extends AbstractBaseEntity> extends CrudRepository<T, Long> {

}
