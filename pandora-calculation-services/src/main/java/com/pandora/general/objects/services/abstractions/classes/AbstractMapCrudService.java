package com.pandora.general.objects.services.abstractions.classes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.pandora.general.objects.services.abstractions.interfaces.CrudService;

import lombok.Getter;

/**
 * The {@code AbstractMapCrudService} is an abstract class implementing the {@link CrudService} interface for managing
 * entities using a {@link Map} as the underlying storage. It provides generic CRUD (Create, Read, Update, Delete)
 * operations for entities of type {@code T} with identifiers of type {@code ID}.
 * <p>
 * This class is intended to be extended by concrete implementations to leverage common CRUD functionality.
 * </p>
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 * @param <T> The type of entity managed by the service.
 * @param <ID> The type of identifier for the entities.
 * @see Map
 * @see Set
 * @see CrudService
 * @see lombok.Getter
 */
@Getter
public abstract class AbstractMapCrudService<T, ID> implements CrudService<T, ID> {

    /**
     * The underlying map used for storing entities, where the key is the entity identifier (ID) and the value is the
     * entity itself.
     */
    private Map<ID, T> map = new HashMap<>();

    /**
     * Retrieves all entities stored in the map.
     *
     * @return A {@code Set} containing all entities stored in the map.
     */
    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    /**
     * Retrieves an entity by its identifier from the map.
     *
     * @param id The identifier of the entity to retrieve.
     * @return The entity with the specified identifier, or {@code null} if not found.
     */
    public T findById(final ID id) {
        return map.get(id);
    }

    /**
     * Saves an entity to the map with the specified identifier.
     *
     * @param id The identifier for the entity.
     * @param object The entity to be saved.
     * @return The saved entity.
     */
    public T save(final ID id, final T object) {
        map.put(id, object);
        return object;
    }

    /**
     * Deletes an entity from the map based on its identifier.
     *
     * @param id The identifier of the entity to delete.
     */
    public void deleteById(final ID id) {
        map.remove(id);
    }

    /**
     * Deletes a specified entity from the map.
     *
     * @param object The entity to delete.
     */
    public void delete(final T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    /**
     * Checks if the provided entity is null and throws a {@code RuntimeException} if so.
     *
     * @param object The entity to check for null.
     * @throws RuntimeException If the provided entity is null.
     */
    public void nullCheck(final T object) {
        if (object == null) {
            throw new RuntimeException("Entity can not be null");
        }
    }

}
