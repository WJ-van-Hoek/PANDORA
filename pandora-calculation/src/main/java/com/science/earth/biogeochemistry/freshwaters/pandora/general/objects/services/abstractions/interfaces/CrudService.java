package com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.interfaces;

import java.util.Set;

public interface CrudService<T, ID> {
    /**
     * Retrieves all entities managed by the service.
     *
     * @return A {@code Set} containing all entities managed by the service.
     */
    Set<T> findAll();

    /**
     * Retrieves an entity by its identifier.
     *
     * @param id The identifier of the entity to retrieve.
     * @return The entity with the specified identifier, or {@code null} if not found.
     */
    T findById(ID id);

    /**
     * Saves the provided entity.
     *
     * @param object The entity to be saved.
     * @return The saved entity.
     */
    T save(T object);

    /**
     * Deletes the specified entity.
     *
     * @param object The entity to be deleted.
     */
    void delete(T object);

    /**
     * Deletes an entity by its identifier.
     *
     * @param id The identifier of the entity to delete.
     */
    void deleteById(ID id);
}
