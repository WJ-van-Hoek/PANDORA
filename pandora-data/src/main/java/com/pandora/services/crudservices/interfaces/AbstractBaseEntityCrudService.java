package com.pandora.services.crudservices.interfaces;

import com.pandora.model.AbstractBaseDBEntity;

public interface AbstractBaseEntityCrudService<T extends AbstractBaseDBEntity> extends CrudService<T, Long> {

}
