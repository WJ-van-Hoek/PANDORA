/**
 * The package {@code com.pandora.config.species.services} contains services responsible for managing the status of
 * biogeochemical species beans. These services interact with the Spring application context to enable, disable, and
 * query the status of specific species beans.
 * <p>
 * The main interface in this package is {@link com.pandora.config.species.services.SpecieStatusService
 * SpecieStatusService}, which defines methods for checking whether a species bean is enabled
 * ({@link com.pandora.config.species.services.SpecieStatusService#isBeanEnabled() isBeanEnabled()}) and toggling the
 * status of a species bean ({@link com.pandora.config.species.services.SpecieStatusService#toggleBeanStatus(boolean)
 * toggleBeanStatus(boolean)}).
 * </p>
 * <p>
 * The package also includes abstract and concrete implementations of
 * {@link com.pandora.config.species.services.AbstractBeanStatusService AbstractBeanStatusService}, which provides a
 * base class for creating status services for different biogeochemical species. Concrete implementations such as
 * {@link com.pandora.config.species.services.DicBeanStatusService DicBeanStatusService} and
 * {@link com.pandora.config.species.services.DocBeanStatusService DocBeanStatusService} manage the status of DIC
 * (Dissolved Inorganic Carbon) and DOC (Dissolved Organic Carbon) species beans, respectively.
 * </p>
 * <p>
 * These services utilize Spring annotations such as {@code @Value} for injecting external properties and
 * {@code @ConditionalOnProperty} to conditionally enable or disable the services based on configuration properties.
 * </p>
 *
 */
package com.pandora.config.species.services;
