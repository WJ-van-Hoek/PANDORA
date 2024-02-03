/**
 * This package contains REST controllers for handling HTTP requests related to specie configurations.
 * <p>
 * These controllers provide endpoints for saving and retrieving specie configurations.
 * <p>
 * Endpoint mappings:
 * <ul>
 * <li>POST /specie-configurations: Saves a new specie configuration.</li>
 * <li>GET /specie-configurations/{name}: Retrieves a specie configuration by its name.</li>
 * </ul>
 * <p>
 * Responses:
 * <ul>
 * <li>For successful POST requests, returns HTTP status 201 (Created).</li>
 * <li>For successful GET requests, returns HTTP status 200 (OK) along with the retrieved specie configuration.</li>
 * <li>If no specie configuration is found for the given name, returns HTTP status 404 (Not Found).</li>
 * </ul>
 *
 * @version 0.0.1
 * @since 0.0.1
 * @author Wim Joost van Hoek
 */
package com.pandora.rest.controllers;
