package com.science.earth.biogeochemistry.freshwaters.pandora.repositories;

import org.springframework.data.repository.CrudRepository;

import com.science.earth.biogeochemistry.freshwaters.pandora.model.AbstractBaseDBEntity;

public interface AbstractBaseDBEntityRepository<T extends AbstractBaseDBEntity> extends CrudRepository<T, Long> {

}
