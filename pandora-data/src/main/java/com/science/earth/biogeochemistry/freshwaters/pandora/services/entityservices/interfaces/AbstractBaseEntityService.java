package com.science.earth.biogeochemistry.freshwaters.pandora.services.entityservices.interfaces;

import com.science.earth.biogeochemistry.freshwaters.pandora.model.AbstractBaseEntity;

public interface AbstractBaseEntityService<T extends AbstractBaseEntity> {
    public void nullCheck(T abstractBaseEntity);
    public boolean isNew(T abstractBaseEntity);
    public String getGenericType();
    public String getFullGenericType();
   }
