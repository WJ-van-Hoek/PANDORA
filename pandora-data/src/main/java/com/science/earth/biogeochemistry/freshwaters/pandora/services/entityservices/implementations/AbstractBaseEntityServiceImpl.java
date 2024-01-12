package com.science.earth.biogeochemistry.freshwaters.pandora.services.entityservices.implementations;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ErrorMessageGenerator;
import com.science.earth.biogeochemistry.freshwaters.pandora.errors.ServiceImplError;
import com.science.earth.biogeochemistry.freshwaters.pandora.model.AbstractBaseDBEntity;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.entityservices.interfaces.AbstractBaseEntityService;

@Service
public abstract class AbstractBaseEntityServiceImpl<T extends AbstractBaseDBEntity>
        implements AbstractBaseEntityService<T> {

    @Autowired
    protected ErrorMessageGenerator errorMessageGenerator;

    protected AbstractBaseEntityServiceImpl(ErrorMessageGenerator errorMessageGenerator) {
        this.errorMessageGenerator = errorMessageGenerator;
    }

    @Override
    public void nullCheck(T baseEntity) {
        if (baseEntity == null) {
            throw new ServiceImplError(errorMessageGenerator.generate("abstract.crud.service.object.null"));
        }
    }

    @Override
    public boolean isNew(T baseEntity) {
        return baseEntity.getId() == null;
    }

    @Override
    public String getGenericType() {
        String[] packageParts = getFullGenericType().split("\\.");
        return packageParts[packageParts.length - 1];
    }

    @Override
    public String getFullGenericType() {
        Type classType = getClass().getGenericSuperclass();
        return ((ParameterizedType) classType).getActualTypeArguments()[0].getTypeName();
    }
}
