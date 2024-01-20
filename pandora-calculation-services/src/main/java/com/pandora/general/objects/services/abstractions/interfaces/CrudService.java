package com.pandora.general.objects.services.abstractions.interfaces;

import java.util.Set;

/**
 * The {@code CrudService} interface defines generic CRUD (Create, Read, Update, Delete) operations for managing
 * entities of type {@code T} with identifiers of type {@code ID}. Implementations of this interface are expected to
 * provide functionality for retrieving, saving, and deleting entities.
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 * @param <T> The type of entity managed by the service.
 * @param <ID> The type of identifier for the entities.
 * @see java.util.Set
 */
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
