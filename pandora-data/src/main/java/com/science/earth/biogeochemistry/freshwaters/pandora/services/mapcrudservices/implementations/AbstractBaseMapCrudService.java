package com.science.earth.biogeochemistry.freshwaters.pandora.services.mapcrudservices.implementations;

import java.util.Collections;

import com.science.earth.biogeochemistry.freshwaters.pandora.mappedentities.AbstractBaseMappedEntity;

public abstract class AbstractBaseMapCrudService<T extends AbstractBaseMappedEntity> extends AbstractMapCrudService<T, Long> {

    public T save(T mappedEntity) {
	nullCheck(mappedEntity);

	if (mappedEntity.getId() == null) {
	    mappedEntity.setId(getNextId());
	}
	return super.save(mappedEntity.getId(), mappedEntity);
    }

    private Long getNextId() {
	if (map.keySet().isEmpty())
	    return 1L;

	return Collections.max(map.keySet()) + 1;
    }
}
