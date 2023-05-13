package com.science.earth.biogeochemistry.freshwaters.PANDORA.repositories;

import org.springframework.data.repository.CrudRepository;

import com.science.earth.biogeochemistry.freshwaters.PANDORA.model.AbstractBaseEntity;

public interface AbstractBaseEntityRepository<T extends AbstractBaseEntity> extends CrudRepository<T, Long> {

}
