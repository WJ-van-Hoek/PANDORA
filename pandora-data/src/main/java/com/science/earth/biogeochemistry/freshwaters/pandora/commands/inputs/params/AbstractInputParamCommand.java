package com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs.params;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.AbstractBaseObject;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@NoArgsConstructor
@SuperBuilder
public abstract class AbstractInputParamCommand<T extends Number> extends AbstractBaseObject {
    
    private T value;
    
    protected AbstractInputParamCommand(Long id, String name, T value) {
	super(id, name);
	this.value = value;
    }
    
}