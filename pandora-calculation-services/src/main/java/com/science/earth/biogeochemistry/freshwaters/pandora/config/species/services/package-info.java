/**
 * The package {@code com.science.earth.biogeochemistry.freshwaters.pandora.config.species.services} contains services
 * responsible for managing the status of biogeochemical species beans. These services interact with the Spring
 * application context to enable, disable, and query the status of specific species beans.
 * <p>
 * The main interface in this package is {@link SpecieStatusService}, which defines methods for checking whether a
 * species bean is enabled ({@link SpecieStatusService#isBeanEnabled()}) and toggling the status of a species bean
 * ({@link SpecieStatusService#toggleBeanStatus(boolean)}).
 * </p>
 * <p>
 * The package also includes abstract and concrete implementations of {@link AbstractBeanStatusService}, which provides
 * a base class for creating status services for different biogeochemical species. Concrete implementations such as
 * {@link DicBeanStatusService} and {@link DocBeanStatusService} manage the status of DIC (Dissolved Inorganic Carbon)
 * and DOC (Dissolved Organic Carbon) species beans, respectively.
 * </p>
 * <p>
 * These services utilize Spring annotations such as {@code @Value} for injecting external properties and
 * {@code @ConditionalOnProperty} to conditionally enable or disable the services based on configuration properties.
 * </p>
 *
 * @see SpecieStatusService
 * @see AbstractBeanStatusService
 * @see DicBeanStatusService
 * @see DocBeanStatusService
 */
package com.science.earth.biogeochemistry.freshwaters.pandora.config.species.services;
