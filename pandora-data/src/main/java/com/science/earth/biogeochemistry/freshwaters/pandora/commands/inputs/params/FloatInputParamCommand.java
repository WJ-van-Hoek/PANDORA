package com.science.earth.biogeochemistry.freshwaters.pandora.commands.inputs.params;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FloatInputParamCommand extends AbstractInputParamCommand<Float> {

    @Builder
    public FloatInputParamCommand(Long id, String name, Float value) {
	super(id, name, value);
    }
    
}
