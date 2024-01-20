/**
 * This package contains service implementations for managing various aspects related to freshwater biogeochemistry
 * within the Pandora model. These services are responsible for CRUD operations, data storage, and manipulation
 * associated with different entities such as cells, rivers, timesteps, discharges, terrestrial sources, upstream
 * sources, volumes, and state variables.
 * <p>
 * The package includes the following classes:
 * <ul>
 * <li>{@link com.pandora.general.objects.services.implementations.CellTimestepMapCrudService
 * CellTimestepMapCrudService}:
 * <p>
 * Service for CRUD operations on a map of {@link com.pandora.general.objects.CellTimestep CellTimestep} objects.</li>
 *
 * <li>{@link com.pandora.general.objects.services.implementations.DischargesMapServiceImpl DischargesMapServiceImpl}:
 * <p>
 * Service for managing discharge data associated with a {@link com.pandora.general.objects.Cell Cell} and a
 * {@link java.time.LocalDateTime LocalDateTime}.</li>
 *
 * <li>{@link com.pandora.general.objects.services.implementations.RiverMapCrudService RiverMapCrudService}:
 * <p>
 * Service for CRUD operations on a map of {@link com.pandora.general.objects.River River} objects.</li>
 *
 * <li>{@link com.pandora.general.objects.services.implementations.RiverTimestepMapCrudService
 * RiverTimestepMapCrudService}:
 * <p>
 * Service for CRUD operations on a map of {@link com.pandora.general.objects.RiverTimestep RiverTimestep} objects.</li>
 *
 * <li>{@link com.pandora.general.objects.services.implementations.TerrestrialSourcesMapServiceImpl
 * TerrestrialSourcesMapServiceImpl}:
 * <p>
 * Service for managing terrestrial sources data associated with a
 * {@link com.pandora.general.objects.Cell Cell} and a
 * {@link java.time.LocalDateTime LocalDateTime}.</li>
 *
 * <li>{@link com.pandora.general.objects.services.implementations.UpstreamSourcesMapServiceImpl
 * UpstreamSourcesMapServiceImpl}:
 * <p>
 * Service for managing upstream sources data associated with a
 * {@link com.pandora.general.objects.Cell Cell} and a
 * {@link java.time.LocalDateTime LocalDateTime}, utilizing an injected
 * {@link com.pandora.general.services.calculation.interfaces.TransportCalculationService
 * TransportCalculationService}.</li>
 *
 * <li>{@link com.pandora.general.objects.services.implementations.VolumesMapServiceImpl VolumesMapServiceImpl}:
 * <p>
 * Service for managing volume data associated with a {@link com.pandora.general.objects.Cell Cell} and a
 * {@link java.time.LocalDateTime LocalDateTime}.</li>
 *
 * <li>{@link com.pandora.general.objects.services.implementations.YMapServiceImpl YMapServiceImpl}:
 * <p>
 * Service for managing state variable data associated with a {@link com.pandora.general.objects.Cell Cell} and a
 * {@link java.time.LocalDateTime LocalDateTime}.</li>
 * </ul>
 */
package com.pandora.general.objects.services.implementations;
