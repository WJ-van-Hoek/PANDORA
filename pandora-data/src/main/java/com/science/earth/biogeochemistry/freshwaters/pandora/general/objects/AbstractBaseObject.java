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
    private Long id;
    private String name;

    protected AbstractBaseObject(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
