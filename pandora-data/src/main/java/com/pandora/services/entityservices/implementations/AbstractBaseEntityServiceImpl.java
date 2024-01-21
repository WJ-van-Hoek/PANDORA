package com.pandora.services.entityservices.implementations;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pandora.errors.ErrorMessageGenerator;
import com.pandora.errors.ServiceImplError;
import com.pandora.model.AbstractBaseDBEntity;
import com.pandora.services.entityservices.interfaces.AbstractBaseEntityService;

@Service
public abstract class AbstractBaseEntityServiceImpl<T extends AbstractBaseDBEntity>
        implements AbstractBaseEntityService<T> {

    /**
     * The error message generator used for creating error messages in the service.
     */
    @Autowired
    private ErrorMessageGenerator errorMessageGenerator;

    protected AbstractBaseEntityServiceImpl(final ErrorMessageGenerator errorMessageGeneratorParam) {
        this.errorMessageGenerator = errorMessageGeneratorParam;
    }

    @Override
    public final void nullCheck(final T baseEntity) {
        if (baseEntity == null) {
            throw new ServiceImplError(errorMessageGenerator.generate("abstract.crud.service.object.null"));
        }
    }

    @Override
    public final boolean isNew(final T baseEntity) {
        return baseEntity.getId() == null;
    }

    @Override
    public final String getGenericType() {
        String[] packageParts = getFullGenericType().split("\\.");
        return packageParts[packageParts.length - 1];
    }

    @Override
    public final String getFullGenericType() {
        Type classType = getClass().getGenericSuperclass();
        return ((ParameterizedType) classType).getActualTypeArguments()[0].getTypeName();
    }

    protected final ErrorMessageGenerator getErrorMessageGenerator() {
        return errorMessageGenerator;
    }

    protected final void setErrorMessageGenerator(final ErrorMessageGenerator errorMessageGeneratorParam) {
        this.errorMessageGenerator = errorMessageGeneratorParam;
    }
}
