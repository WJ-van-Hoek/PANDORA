package com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.params;

import com.science.earth.biogeochemistry.freshwaters.pandora.model.inputs.AbstractInputEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "float_input_param")
public class FloatInputParam extends AbstractInputParam {

    private static final long serialVersionUID = 4725624920793601027L;

    private Float value;
    
    @Builder
    public FloatInputParam(Long id, String name, AbstractInputEntity inputEntity, Float value) {
	super(id, name, inputEntity);
	this.value = value;
    }

}
