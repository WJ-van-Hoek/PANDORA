package com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.interfaces;

import java.util.Set;

public interface CrudService<T, ID> {
    /**
     * Retrieves all entities managed by the service.
     *
     * @return A {@code Set} containing all entities.
     */
    Set<T> findAll();

    /**
     * Retrieves an entity by its ID.
     *
     * @param id The ID of the entity to retrieve.
     * @return The entity with the specified ID, or {@code null} if not found.
     */
    T findById(ID id);

    /**
     * Saves or updates an entity.
     *
     * @param object The entity to save or update.
     * @return The saved or updated entity.
     */
    T save(T object);

    /**
     * Deletes an entity.
     *
     * @param object The entity to delete.
     */
    void delete(T object);

    /**
     * Deletes an entity by its ID.
     *
     * @param id The ID of the entity to delete.
     */
    void deleteById(ID id);
}
