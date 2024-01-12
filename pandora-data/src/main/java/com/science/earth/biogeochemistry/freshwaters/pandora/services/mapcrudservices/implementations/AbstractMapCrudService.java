package com.science.earth.biogeochemistry.freshwaters.pandora.services.mapcrudservices.implementations;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.interfaces.CrudService;

/**
 * An abstract base class implementing the {@link CrudService} interface for map-based CRUD (Create, Read, Update,
 * Delete) operations.
 *
 * <p>
 * This class provides a generic implementation of a CRUD service using a {@code Map} as the underlying data structure.
 * It includes methods for finding all entities, finding an entity by ID, saving/updating entities, and deleting
 * entities.
 *
 * <p>
 * Concrete implementations are expected to provide specific entity types for the generic parameters {@code T} and
 * {@code ID}, and define how the underlying map is managed. The map is initialized as a {@code HashMap} by default.
 *
 * <p>
 * This abstract class is part of the map CRUD services in the Pandora project.
 *
 * @param <T> The type of entities managed by this service.
 * @param <ID> The type of the entity identifier (ID).
 */
public abstract class AbstractMapCrudService<T, ID> implements CrudService<T, ID> {

    /**
     * The underlying map to store entities, where the key is the entity ID and the value is the entity.
     */
    private Map<ID, T> map = new HashMap<>();

    /**
     * Retrieves all entities stored in the map.
     *
     * @return A {@code Set} containing all entities.
     */
    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    /**
     * Retrieves an entity by its ID from the map.
     *
     * @param id The ID of the entity to retrieve.
     * @return The entity with the specified ID, or {@code null} if not found.
     */
    public T findById(final ID id) {
        return map.get(id);
    }

    /**
     * Saves or updates an entity in the map with the specified ID.
     *
     * @param id The ID of the entity to save or update.
     * @param object The entity to save or update.
     * @return The saved or updated entity.
     */
    public T save(final ID id, final T object) {
        map.put(id, object);
        return object;
    }

    /**
     * Deletes an entity from the map based on its ID.
     *
     * @param id The ID of the entity to delete.
     */
    public void deleteById(final ID id) {
        map.remove(id);
    }

    /**
     * Deletes an entity from the map.
     *
     * @param object The entity to delete.
     */
    public void delete(final T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    /**
     * Performs a null check on the provided entity.
     *
     * @param object The entity to check for null.
     * @throws RuntimeException if the entity is {@code null}.
     */
    public void nullCheck(final T object) {
        if (object == null) {
            throw new RuntimeException("Entity can not be null");
        }
    }

    protected final Map<ID, T> getMap() {
        return this.map;
    }

    protected final void setMap(final Map<ID, T> mapParam) {
        this.map = mapParam;
    }
}
