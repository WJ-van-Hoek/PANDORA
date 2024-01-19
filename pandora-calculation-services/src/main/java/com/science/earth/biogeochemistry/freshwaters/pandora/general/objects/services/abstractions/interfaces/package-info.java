/**
 * This package contains a set of interfaces defining abstractions for various services related to freshwater
 * biogeochemistry within the Pandora framework. These interfaces provide a common contract for classes implementing
 * specific functionalities, such as CRUD (Create, Read, Update, Delete) operations, managing maps, and handling
 * different types of data associated with freshwater systems.
 * <p>
 * The key interfaces in this package are:
 * <ul>
 * <li>{@link com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.
 * abstractions.interfaces.CrudService}:
 * Defines CRUD operations for managing entities within the Pandora framework.</li>
 * <li>{@link com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.
 * abstractions.interfaces.MapService}:
 * Specifies operations for managing maps, including cleaning or resetting the map state.</li>
 * <li>{@link com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.
 * abstractions.interfaces.DischargesMapService}:
 * Extends MapService and includes methods for finding and saving discharge data associated with specific cells and time
 * steps.</li>
 * <li>{@link com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.
 * abstractions.interfaces.TerrestrialSourcesMapService}:
 * Extends MapService and provides methods for handling terrestrial sources data associated with cells and time
 * steps.</li>
 * <li>{@link com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.
 * abstractions.interfaces.UpstreamSourcesMapService}:
 * Extends MapService and includes methods for finding and saving upstream sources data, as well as handling additional
 * data for specific time steps and final states.</li>
 * <li>{@link com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.
 * abstractions.interfaces.VolumesMapService}:
 * Extends MapService and offers operations for finding and saving volume data associated with specific cells and time
 * steps.</li>
 * <li>{@link com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.
 * abstractions.interfaces.YMapService}:
 * Extends MapService and defines methods for managing state variable data, including finding and saving data associated
 * with specific cells and time steps.</li>
 * </ul>
 * </p>
 *
 * @see com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.
 * abstractions.interfaces.CrudService
 * @see com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.
 * abstractions.interfaces.MapService
 * @see com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.
 * abstractions.interfaces.DischargesMapService
 * @see com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.
 * abstractions.interfaces.TerrestrialSourcesMapService
 * @see com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.
 * abstractions.interfaces.UpstreamSourcesMapService
 * @see com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.
 * abstractions.interfaces.VolumesMapService
 * @see com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.
 * abstractions.interfaces.YMapService
 */
package com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.interfaces;
