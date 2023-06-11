package com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.params;

import com.science.earth.biogeochemistry.freshwaters.pandora.model.AbstractBaseEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.AbstractInputEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@NoArgsConstructor
@SuperBuilder
@Entity
public abstract class AbstractInputParam extends AbstractBaseEntity {

    private static final long serialVersionUID = -2778748076466663940L;
    
    @ManyToOne
    @JoinColumn(name = "input_entity_id")
    private AbstractInputEntity inputEntity;

    protected AbstractInputParam(Long id, String name, AbstractInputEntity inputEntity) {
	super(id, name);
	this.inputEntity = inputEntity;
    }
}
