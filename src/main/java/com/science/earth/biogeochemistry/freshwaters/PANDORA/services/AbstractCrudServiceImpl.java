package com.science.earth.biogeochemistry.freshwaters.PANDORA.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


public abstract class AbstractCrudServiceImpl<T, ID, R extends CrudRepository<T, ID>> implements CrudService<T, ID> {
    
    R repository;

    protected AbstractCrudServiceImpl(R repository) {
        this.repository = repository;
    }
	
    public Set<T> findAll() {
	Set<T> objects = new HashSet<>();
	repository.findAll().forEach(objects::add);
	return objects;
    }

    public T findById(ID id) {
	return repository.findById(id).orElse(null);
    }

    @Transactional
    public T save(T object) {
	return repository.save(object);
    }

    @Transactional
    public void delete(T object) {
	repository.delete(object);
    }

    @Transactional
    public void deleteById(ID id) {
	repository.deleteById(id);
    }

}
