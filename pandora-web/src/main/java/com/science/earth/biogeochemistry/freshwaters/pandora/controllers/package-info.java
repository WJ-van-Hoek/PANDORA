/**
 * This package contains Spring MVC controllers for handling various aspects of the Pandora application. Controllers in
 * this package manage different services and functionalities within the application.
 *
 * - {@link CalculationsServiceController}: Handles requests related to the calculations service, such as the
 * calculations service index page and launching the calculation service.
 *
 * - {@link CommandLineServiceController}: Manages requests for the command line service, providing access to the
 * Thymeleaf template for the command line service.
 *
 * - {@link ConfigurationUploadController}: Handles requests for the configuration file upload form and processes
 * uploaded configuration files.
 *
 * - {@link DatabasesServiceController}: Manages requests for the databases index page.
 *
 * - {@link DockerController}: Controls Docker-related operations, including launching Docker containers.
 *
 * - {@link IndexController}: Manages requests for the application's index or home page.
 *
 * - {@link ParentTemplateController}: Handles requests to display the parent template.
 *
 * - {@link ReportsServiceController}: Handles requests to display the reports index page.
 *
 * These controllers are responsible for processing HTTP requests, interacting with services, and rendering Thymeleaf
 * templates.
 */
package com.pandora.controllers;
