/**
 * This package contains interfaces defining CRUD (Create, Read, Update, Delete) operations for various entities in the
 * Pandora application. These interfaces provide a standard set of methods for managing entities, including retrieving,
 * saving, and deleting them.
 * <p>
 * The main interfaces in this package are:
 * <ul>
 * <li>{@link com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.interfaces.CrudService}:
 * Defines basic CRUD operations for any entity type.</li>
 * <li>{@link com.science.earth.biogeochemistry.freshwaters.pandora.services.
 * crudservices.interfaces.AbstractBaseEntityCrudService}:
 * Extends {@code CrudService} and introduces generics to manage operations on entities extending
 * {@code AbstractBaseDBEntity}.</li>
 * <li>{@link com.science.earth.biogeochemistry.freshwaters.pandora.services.
 * crudservices.interfaces.CellDBEntityCrudService}:
 * Extends {@code AbstractBaseEntityCrudService} and specializes in CRUD operations for {@code CellDBEntity}
 * instances.</li>
 * </ul>
 * </p>
 * The interfaces in this package provide a consistent and generic way to interact with different types of entities
 * across the Pandora application.
 */
package com.science.earth.biogeochemistry.freshwaters.pandora.services.crudservices.interfaces;
