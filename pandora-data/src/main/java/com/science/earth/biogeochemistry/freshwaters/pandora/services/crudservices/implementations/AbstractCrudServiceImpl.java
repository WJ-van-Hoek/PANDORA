package com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.implementations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.science.earth.biogeochemistry.freshwaters.pandora.errors.CrudError;
import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.interfaces.CrudService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public abstract class AbstractCrudServiceImpl<T, ID, R extends CrudRepository<T, ID>> implements CrudService<T, ID> {

    @Autowired
    protected R repository;

    @Autowired
    protected ErrorMessageGenerator errorMessageGenerator;

    protected AbstractCrudServiceImpl(R repository, ErrorMessageGenerator errorMessageGenerator) {
	this.repository = repository;
	this.errorMessageGenerator = errorMessageGenerator;
    }

    public Set<T> findAll() {
	Set<T> objects = new HashSet<>();
	repository.findAll().forEach(objects::add);
	return objects;
    }

    public T findById(ID id) {
	Optional<T> object = repository.findById(id);
	if (object.isPresent()) {
	    return object.get();
	} else {
	    throw new CrudError(errorMessageGenerator.generate("abstract.crud.service.id.notexist", id));
	}
    }

    @Transactional
    public T save(T object) {
	if (object != null) {
	    return repository.save(object);
	} else {
	    throw new CrudError(errorMessageGenerator.generate("abstract.crud.service.object.null"));
	}
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
