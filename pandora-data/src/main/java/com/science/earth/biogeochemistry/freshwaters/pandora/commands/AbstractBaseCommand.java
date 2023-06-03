package com.science.earth.biogeochemistry.freshwaters.pandora.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public abstract class AbstractBaseCommand {

    private Long id;
    private String name;

    protected AbstractBaseCommand(Long id, String name) {
	this.id = id;
	this.name = name;
    }

}
