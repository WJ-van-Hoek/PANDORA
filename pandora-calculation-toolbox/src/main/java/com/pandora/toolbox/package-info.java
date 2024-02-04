/**
 * This package contains utility tools and entry points for various functionalities in the PANDORA system.
 * <p>
 * The main class in this package is {@link com.pandora.toolbox.PandoraCellTool}, which serves as an entry point
 * for a tool related to PANDORA cell calculations.
 * <p>
 * It provides functionality for bootstrapping the application by initializing calculation parameters using Spring
 * framework's application context and parsing command-line arguments.
 * <p>
 * To use the tool, execute the main method of {@link com.pandora.toolbox.PandoraCellTool} class.
 * <p>
 * The {@link com.pandora.calculation.bootstrap.BootstrapParams} class and its associated parser classes are used
 * for parsing command-line arguments and initializing bootstrap parameters.
 * <p>
 * The {@link com.pandora.calculation.services.BootstrapService} class is responsible for initializing the calculation
 * parameters based on the provided bootstrap parameters.
 *
 * @author Wim Joost van Hoek
 * @version 0.0.1
 * @since 0.0.1
 */
package com.pandora.toolbox;
