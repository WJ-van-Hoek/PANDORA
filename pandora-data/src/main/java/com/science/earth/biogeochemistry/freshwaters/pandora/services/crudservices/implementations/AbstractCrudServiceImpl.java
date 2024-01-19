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

@Service
public abstract class AbstractCrudServiceImpl<T, ID, R extends CrudRepository<T, ID>> implements CrudService<T, ID> {
    /**
     * The Spring Data {@link CrudRepository} used for managing entities.
     */
    @Autowired
    private R repository;

    /**
     * The error message generator used for creating error messages in the service.
     */
    @Autowired
    private ErrorMessageGenerator errorMessageGenerator;

    /**
     * Constructs an instance of {@code AbstractCrudServiceImpl} with the specified {@link CrudRepository} and
     * {@link ErrorMessageGenerator}.
     *
     * @param repositoryParam The Spring Data {@link CrudRepository} to be used by the service.
     * @param errorMessageGeneratorParam The error message generator to be used by the service.
     */
    protected AbstractCrudServiceImpl(final R repositoryParam, final ErrorMessageGenerator errorMessageGeneratorParam) {
        this.repository = repositoryParam;
        this.errorMessageGenerator = errorMessageGeneratorParam;
    }

    /**
     * Retrieves all entities managed by the service.
     *
     * @return A {@code Set} containing all entities.
     */
    public final Set<T> findAll() {
        Set<T> objects = new HashSet<>();
        repository.findAll().forEach(objects::add);
        return objects;
    }

    /**
     * Retrieves an entity by its ID.
     *
     * @param id The ID of the entity to retrieve.
     * @return The entity with the specified ID.
     * @throws CrudError if the entity with the given ID does not exist.
     */
    public final T findById(final ID id) {
        Optional<T> object = repository.findById(id);
        if (object.isPresent()) {
            return object.get();
        } else {
            throw new CrudError(errorMessageGenerator.generate("abstract.crud.service.id.notexist", id));
        }
    }

    /**
     * Saves or updates an entity.
     *
     * @param object The entity to save or update.
     * @return The saved or updated entity.
     * @throws CrudError if the provided entity is {@code null}.
     */
    @Transactional
    public final T save(final T object) {
        if (object != null) {
            return repository.save(object);
        } else {
            throw new CrudError(errorMessageGenerator.generate("abstract.crud.service.object.null"));
        }
    }

    /**
     * Deletes an entity.
     *
     * @param object The entity to delete.
     */
    @Transactional
    public final void delete(final T object) {
        repository.delete(object);
    }

    /**
     * Deletes an entity by its ID.
     *
     * @param id The ID of the entity to delete.
     */
    @Transactional
    public final void deleteById(final ID id) {
        repository.deleteById(id);
    }

    protected final R getRepository() {
        return repository;
    }

    protected final void setRepository(final R repositoryParam) {
        this.repository = repositoryParam;
    }

    protected final ErrorMessageGenerator getErrorMessageGenerator() {
        return errorMessageGenerator;
    }

    protected final void setErrorMessageGenerator(final ErrorMessageGenerator errorMessageGeneratorParam) {
        this.errorMessageGenerator = errorMessageGeneratorParam;
    }
}
