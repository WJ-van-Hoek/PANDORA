package com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.classes;

import java.util.Collections;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.AbstractBaseObject;

public abstract class AbstractBaseMapCrudService<T extends AbstractBaseObject> extends AbstractMapCrudService<T, Long> {

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
