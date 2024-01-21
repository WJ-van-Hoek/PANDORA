/**
 * This package contains entity classes representing database entities in the Pandora project. These entities are
 * designed to be persisted in a relational database using the Java Persistence API (JPA).
 *
 * <p>
 * The main classes in this package are: -
 * {@link com.pandora.model.AbstractBaseDBEntity}: An abstract base class for
 * database entities providing common properties and behavior. -
 * {@link com.pandora.model.CellDBEntity}: An entity representing a cell in
 * the Pandora project, extending the {@code AbstractBaseDBEntity}.
 *
 * <p>
 * The entities are annotated with JPA annotations such as {@link jakarta.persistence.Entity},
 * {@link jakarta.persistence.Table}, {@link jakarta.persistence.Id}, and others to define their structure,
 * relationships, and behavior in the database.
 *
 * <p>
 * These entities are designed for use with JPA repositories to enable database interaction and manipulation.
 *
 */
package com.pandora.model;
