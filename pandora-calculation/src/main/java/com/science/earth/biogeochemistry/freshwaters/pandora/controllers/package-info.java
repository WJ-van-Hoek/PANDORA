/**
 * Provides controllers for handling various HTTP endpoints related to biogeochemistry in freshwater environments within
 * PANDORA. These controllers facilitate interactions with the system, including initiating cell
 * calculations, managing DIC (Dissolved Inorganic Carbon) and DOC (Dissolved Organic Carbon) bean statuses, retrieving
 * information about rivers, and obtaining details about available species.
 *
 * <p>
 * The package includes the following controllers:
 * </p>
 * <ul>
 * <li>{@link com.science.earth.biogeochemistry.freshwaters.pandora.controllers.CellController}: Manages the initiation
 * and processing of cell calculations, handling HTTP POST requests for cell calculations.</li>
 * <li>{@link com.science.earth.biogeochemistry.freshwaters.pandora.controllers.DicBeanStatusController}: Manages the
 * status of the DIC (Dissolved Inorganic Carbon) bean, allowing toggling and retrieval of its status.</li>
 * <li>{@link com.science.earth.biogeochemistry.freshwaters.pandora.controllers.DocBeanStatusController}: Manages the
 * status of the DOC (Dissolved Organic Carbon) bean, allowing toggling and retrieval of its status.</li>
 * <li>{@link com.science.earth.biogeochemistry.freshwaters.pandora.controllers.RiverController}: Represents a
 * placeholder for potential future functionalities related to rivers.</li>
 * <li>{@link com.science.earth.biogeochemistry.freshwaters.pandora.controllers.SpeciesController}: Retrieves
 * information about all available species in the Pandora system.</li>
 * </ul>
 *
 * <p>
 * These controllers are responsible for processing incoming HTTP requests, interacting with the underlying services,
 * and returning appropriate responses to the clients.
 * </p>
 *
 * @see com.science.earth.biogeochemistry.freshwaters.pandora.controllers.CellController
 * @see com.science.earth.biogeochemistry.freshwaters.pandora.controllers.DicBeanStatusController
 * @see com.science.earth.biogeochemistry.freshwaters.pandora.controllers.DocBeanStatusController
 * @see com.science.earth.biogeochemistry.freshwaters.pandora.controllers.RiverController
 * @see com.science.earth.biogeochemistry.freshwaters.pandora.controllers.SpeciesController
 */
package com.science.earth.biogeochemistry.freshwaters.pandora.controllers;
