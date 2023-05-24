package com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs;

import com.science.earth.biogeochemistry.freshwaters.pandora.model.AbstractBaseEntity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@NoArgsConstructor
@SuperBuilder
@Entity
public abstract class AbstractInputEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 462595636653587832L;

    protected AbstractInputEntity(Long id, String name) {
	super(id, name);
    }
}
