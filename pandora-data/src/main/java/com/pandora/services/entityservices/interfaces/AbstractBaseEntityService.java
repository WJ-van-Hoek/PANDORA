package com.pandora.services.entityservices.interfaces;

import com.pandora.model.AbstractBaseDBEntity;

public interface AbstractBaseEntityService<T extends AbstractBaseDBEntity> {
    /**
     * Performs a null check on the provided {@link AbstractBaseDBEntity}.
     *
     * <p>This method is designed to ensure that the provided entity is not {@code null} before
     * proceeding with other operations.
     *
     * @param abstractBaseEntity The entity to check for null.
     * @throws RuntimeException if the provided entity is {@code null}.
     * @since [Date or Version Number]
     */
    void nullCheck(T abstractBaseEntity);

    /**
     * Determines whether the provided {@link AbstractBaseDBEntity} is a new entity.
     *
     * <p>An entity is considered new if it does not have an assigned identifier (ID).
     *
     * @param abstractBaseEntity The entity to check for newness.
     * @return {@code true} if the entity is new, {@code false} otherwise.
     * @since [Date or Version Number]
     */
    boolean isNew(T abstractBaseEntity);

    /**
     * Retrieves the generic type of entities managed by the service.
     *
     * <p>The generic type is represented as a string.
     *
     * @return The generic type of entities.
     * @since [Date or Version Number]
     */
    String getGenericType();

    /**
     * Retrieves the full generic type, including package information, of entities managed by the service.
     *
     * <p>The full generic type is represented as a string.
     *
     * @return The full generic type of entities.
     * @since [Date or Version Number]
     */
    String getFullGenericType();
}
