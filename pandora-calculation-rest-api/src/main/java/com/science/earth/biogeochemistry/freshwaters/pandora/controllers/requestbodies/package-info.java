/**
 * The {@code com.science.earth.biogeochemistry.freshwaters.pandora.controllers.requestbodies} package contains classes
 * and interfaces related to request bodies used in Pandora for cell-based calculations. These request bodies are
 * designed to encapsulate the necessary data required for various calculations and are used as inputs to the
 * corresponding services.
 * <p>
 * The main interfaces in this package include:
 * <ul>
 * <li>{@link com.science.earth.biogeochemistry.freshwaters.pandora.controllers.requestbodies.RequestBody} - An
 * interface that defines the contract for validating request bodies.</li>
 * </ul>
 * <p>
 * The primary class in this package is:
 * <ul>
 * <li>{@link com.science.earth.biogeochemistry.freshwaters.pandora.controllers.requestbodies.CellCalculationRequest} -
 * A class representing a request body for cell-based calculations. It implements the
 * {@link com.science.earth.biogeochemistry.freshwaters.pandora.controllers.requestbodies.RequestBody} interface and
 * includes validation logic for the incoming data.</li>
 * </ul>
 * <p>
 * Additionally, the package contains services that utilize these request bodies, such as:
 * <ul>
 * <li>{@link com.science.earth.biogeochemistry.freshwaters.pandora.controllers.requestbodies.
 * CellCalculationRequestService}
 * - An interface that defines methods for preprocessing and processing cell calculation requests.</li>
 * <li>{@link com.science.earth.biogeochemistry.freshwaters.pandora.controllers.requestbodies.
 * CellCalculationRequestServiceImpl}
 * - An implementation of the
 * {@link com.science.earth.biogeochemistry.freshwaters.pandora.controllers.requestbodies.CellCalculationRequestService}
 * interface, providing the actual implementation of the methods for handling cell calculation requests.</li>
 * </ul>
 */
package com.science.earth.biogeochemistry.freshwaters.pandora.controllers.requestbodies;
