/**
 * This package contains a set of interfaces defining abstractions for various services related to freshwater
 * biogeochemistry within the Pandora framework. These interfaces provide a common contract for classes implementing
 * specific functionalities, such as CRUD (Create, Read, Update, Delete) operations, managing maps, and handling
 * different types of data associated with freshwater systems.
 * <p>
 * The key interfaces in this package are:
 * <ul>
 * <li>{@link com.pandora.general.objects.services.abstractions.interfaces.CrudService}:<p>
 * Defines CRUD operations for managing entities within the Pandora framework.</li>
 * <li>{@link com.pandora.general.objects.services.abstractions.interfaces.MapService}:<p>
 * Specifies operations for managing maps, including cleaning or resetting the map state.</li>
 * <li>{@link com.pandora.general.objects.services.abstractions.interfaces.DischargesMapService}:<p>
 * Extends MapService and includes methods for finding and saving discharge data associated with specific cells and time
 * steps.</li>
 * <li>{@link com.pandora.general.objects.services.abstractions.interfaces.TerrestrialSourcesMapService}:<p>
 * Extends MapService and provides methods for handling terrestrial sources data associated with cells and time
 * steps.</li>
 * <li>{@link com.pandora.general.objects.services.abstractions.interfaces.UpstreamSourcesMapService}:<p>
 * Extends MapService and includes methods for finding and saving upstream sources data, as well as handling additional
 * data for specific time steps and final states.</li>
 * <li>{@link com.pandora.general.objects.services.abstractions.interfaces.VolumesMapService}:<p>
 * Extends MapService and offers operations for finding and saving volume data associated with specific cells and time
 * steps.</li>
 * <li>{@link com.pandora.general.objects.services.abstractions.interfaces.YMapService}:<p>
 * Extends MapService and defines methods for managing state variable data, including finding and saving data associated
 * with specific cells and time steps.</li>
 * </ul>
 *
 */
package com.pandora.general.objects.services.abstractions.interfaces;
