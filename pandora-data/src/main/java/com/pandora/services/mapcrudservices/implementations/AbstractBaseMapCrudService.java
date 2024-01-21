package com.pandora.services.mapcrudservices.implementations;

import java.util.Collections;

import com.pandora.general.objects.AbstractBaseObject;

public abstract class AbstractBaseMapCrudService<T extends AbstractBaseObject> extends AbstractMapCrudService<T, Long> {
    /**
     * Saves or updates the provided {@link AbstractBaseObject} in the underlying map.
     *
     * <p>
     * If the provided object has a {@code null} ID, a new unique identifier is generated using the {@link #getNextId()}
     * method. The object's ID is then set to the generated value, and the object is saved in the map using the
     * {@link AbstractMapCrudService#save(Object, Object)} method.
     *
     * <p>
     * If the provided object already has a non-null ID, it is assumed to be an existing object, and the object is
     * updated in the map using the {@link AbstractMapCrudService#save(Object, Object)} method.
     *
     * <p>
     * The method ensures that the provided object is not {@code null} before proceeding with the save operation.
     *
     * @param baseCommand The {@link AbstractBaseObject} to save or update.
     * @return The saved or updated {@link AbstractBaseObject}.
     * @throws RuntimeException if the provided object is {@code null}.
     * @see AbstractMapCrudService#save(Object, Object)
     * @see #getNextId()
     */
    public final T save(final T baseCommand) {
        // Ensure the provided object is not null
        nullCheck(baseCommand);

        // If the object has a null ID, generate a new unique identifier
        if (baseCommand.getId() == null) {
            baseCommand.setId(getNextId());
        }

        // Save or update the object in the underlying map
        return super.save(baseCommand.getId(), baseCommand);
    }

    private Long getNextId() {
        if (getMap().keySet().isEmpty()) {
            return 1L;
        }

        return Collections.max(getMap().keySet()) + 1;
    }
}
