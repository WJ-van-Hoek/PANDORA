package com.science.earth.biogeochemistry.freshwaters.pandora.services.commandcrudservices.implementations;

import java.util.Collections;

import com.science.earth.biogeochemistry.freshwaters.pandora.commands.AbstractBaseCommand;

public abstract class AbstractBaseCommandCrudService<T extends AbstractBaseCommand> extends AbstractMapCrudService<T, Long> {

    public T save(T baseCommand) {
	nullCheck(baseCommand);

	if (baseCommand.getId() == null) {
	    baseCommand.setId(getNextId());
	}
	return super.save(baseCommand.getId(), baseCommand);
    }

    private Long getNextId() {
	if (map.keySet().isEmpty())
	    return 1L;

	return Collections.max(map.keySet()) + 1;
    }
}
