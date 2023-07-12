package com.science.earth.biogeochemistry.freshwaters.pandora.mappedentities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public abstract class AbstractBaseMappedEntity {

    private Long id;
    private String name;

    protected AbstractBaseMappedEntity(Long id, String name) {
	this.id = id;
	this.name = name;
    }

}
