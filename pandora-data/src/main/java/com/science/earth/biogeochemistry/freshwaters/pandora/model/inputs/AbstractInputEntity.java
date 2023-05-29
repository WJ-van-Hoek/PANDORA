package com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs;

import java.util.HashSet;
import java.util.Set;

import com.science.earth.biogeochemistry.freshwaters.pandora.model.AbstractBaseEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.params.FloatInputParam;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inputEntity")
    private Set<FloatInputParam> floatInputParams = new HashSet<>();
    
    protected AbstractInputEntity(Long id, String name, Set<FloatInputParam> floatInputParams) {
	super(id, name);
	this.floatInputParams = floatInputParams != null ? floatInputParams : new HashSet<>();
    }
}
