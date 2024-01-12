package com.science.earth.biogeochemistry.freshwaters.pandora.general.objects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public abstract class AbstractBaseObject {
    /**
     * The unique identifier (ID) for the object.
     */
    private Long id;

    /**
     * The name of the object.
     */
    private String name;

    /**
     * Constructs a new {@code AbstractBaseObject} with the specified ID and name.
     *
     * @param idParam The unique identifier (ID) for the object.
     * @param nameParam The name of the object.
     */
    protected AbstractBaseObject(final Long idParam, final String nameParam) {
        this.id = idParam;
        this.name = nameParam;
    }
}
