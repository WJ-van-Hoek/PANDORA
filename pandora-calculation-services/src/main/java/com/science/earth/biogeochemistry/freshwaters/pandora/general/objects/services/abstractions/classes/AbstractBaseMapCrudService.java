package com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.classes;

import java.util.Collections;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.AbstractBaseObject;

public abstract class AbstractBaseMapCrudService<T extends AbstractBaseObject> extends AbstractMapCrudService<T, Long> {
    /**
     * Saves the given {@code AbstractBaseObject} to the underlying map.
     *
     * <p>
     * This method checks if the provided object has a non-null ID. If the ID is null, it assigns the next available ID
     * by invoking the {@link #getNextId()} method. The object is then saved to the map using the ID and the
     * {@link AbstractMapCrudService#save(Object, Object)} method.
     * </p>
     *
     * <p>
     * If the underlying map is empty, the initial ID assigned is 1L. Otherwise, the next available ID is determined by
     * incrementing the maximum existing ID in the map by 1.
     * </p>
     *
     * @param baseCommand The {@code AbstractBaseObject} to be saved.
     * @return The saved {@code AbstractBaseObject} with an assigned or existing ID.
     *
     * @throws NullPointerException If the provided {@code baseCommand} is null.
     *
     * @see AbstractMapCrudService#save(Object, Object) The underlying method used for saving objects to the map.
     * @see #getNextId() The method used for determining the next available ID.
     */
    public T save(final T baseCommand) {
        nullCheck(baseCommand);

        if (baseCommand.getId() == null) {
            baseCommand.setId(getNextId());
        }
        return super.save(baseCommand.getId(), baseCommand);
    }

    private Long getNextId() {
        if (getMap().keySet().isEmpty()) {
            return 1L;
        }

        return Collections.max(getMap().keySet()) + 1;
    }
}
