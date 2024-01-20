package com.pandora.repositories;

import org.springframework.data.repository.CrudRepository;

import com.pandora.model.AbstractBaseDBEntity;

public interface AbstractBaseDBEntityRepository<T extends AbstractBaseDBEntity> extends CrudRepository<T, Long> {

}
