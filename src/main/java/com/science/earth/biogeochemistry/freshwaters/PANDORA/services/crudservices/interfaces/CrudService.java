package com.science.earth.biogeochemistry.freshwaters.PANDORA.services.crudservices.interfaces;

import java.util.Set;

public interface CrudService<T, ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);
}
