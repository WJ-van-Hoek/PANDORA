/**
 * This package contains service implementations for managing various aspects related to freshwater biogeochemistry
 * within the Pandora model. These services are responsible for CRUD operations, data storage, and manipulation
 * associated with different entities such as cells, rivers, timesteps, discharges, terrestrial sources, upstream
 * sources, volumes, and state variables.
 * <p>
 * The package includes the following classes:
 * <ul>
 * <li>{@link com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.
 * services.implementations.CellTimestepMapCrudService}:
 * Service for CRUD operations on a map of
 * {@link com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.CellTimestep} objects.</li>
 *
 * <li>{@link com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.
 * services.implementations.DischargesMapServiceImpl}:
 * Service for managing discharge data associated with
 * {@link com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.Cell} and
 * {@link java.time.LocalDateTime}.</li>
 *
 * <li>{@link com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.
 * services.implementations.RiverMapCrudService}:
 * Service for CRUD operations on a map of
 * {@link com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.River} objects.</li>
 *
 * <li>{@link com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.
 * services.implementations.RiverTimestepMapCrudService}:
 * Service for CRUD operations on a map of
 * {@link com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.RiverTimestep} objects.</li>
 *
 * <li>{@link com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.
 * services.implementations.TerrestrialSourcesMapServiceImpl}:
 * Service for managing terrestrial sources data associated with
 * {@link com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.Cell} and
 * {@link java.time.LocalDateTime}.</li>
 *
 * <li>{@link com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.
 * services.implementations.UpstreamSourcesMapServiceImpl}:
 * Service for managing upstream sources data associated with
 * {@link com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.Cell} and
 * {@link java.time.LocalDateTime}, utilizing an injected
 * {@link com.science.earth.biogeochemistry.freshwaters.pandora.general.
 * services.calculation.interfaces.TransportCalculationService}.</li>
 *
 * <li>{@link com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.
 * services.implementations.VolumesMapServiceImpl}:
 * Service for managing volume data associated with
 * {@link com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.Cell} and
 * {@link java.time.LocalDateTime}.</li>
 *
 * <li>{@link com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.
 * services.implementations.YMapServiceImpl}:
 * Service for managing state variable data associated with
 * {@link com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.Cell} and
 * {@link java.time.LocalDateTime}.</li>
 * </ul>
 */
package com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.implementations;
