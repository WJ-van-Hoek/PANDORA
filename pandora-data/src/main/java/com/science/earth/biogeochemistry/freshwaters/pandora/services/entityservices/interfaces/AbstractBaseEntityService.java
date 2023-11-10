package com.science.earth.biogeochemistry.freshwaters.pandora.services.entityservices.interfaces;

import com.science.earth.biogeochemistry.freshwaters.pandora.model.AbstractBaseDBEntity;

public interface AbstractBaseEntityService<T extends AbstractBaseDBEntity> {
    public void nullCheck(T abstractBaseEntity);
    public boolean isNew(T abstractBaseEntity);
    public String getGenericType();
    public String getFullGenericType();
   }
