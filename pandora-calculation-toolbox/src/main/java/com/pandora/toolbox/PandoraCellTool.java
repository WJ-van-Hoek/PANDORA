package com.pandora.toolbox;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pandora.calculation.bootstrap.Bootstrap;
import com.pandora.calculation.parsers.CommandLineToolParser;
import com.pandora.calculation.parsers.Parsable;
import com.pandora.calculation.services.BootstrapService;

/**
 * The PandoraCellTool class serves as the entry point for a tool related to PANDORA cell calculations.
 * <p>
 * This tool is responsible for bootstrapping the application by initializing calculation parameters using Spring
 * framework's application context and parsing command-line arguments.
 * <p>
 * To use the tool, execute the main method of this class.
 * <p>
 * The tool loads the Spring context from the "com.pandora.calculation" package.
 * <p>
 * It then initializes the calculation parameters by parsing the command-line arguments and passing them to the
 * {@link com.pandora.calculation.services.BootstrapService BootstrapService} for further processing.
 * <p>
 *
 * @author Wim Joost van Hoek.
 * @since 0.0.1
 * @version 0.0.1
 */
public class PandoraCellTool {
    /**
     * The main method serves as the entry point for the PandoraCellTool application.
     * <p>
     * It loads the Spring context, initializes calculation parameters, and closes the Spring context afterwards.
     *
     * @param args Command-line arguments provided to the application.
     */
    public static void main(final String[] args) {
        // Load the Spring context
        ApplicationContext context = new AnnotationConfigApplicationContext("com.pandora.calculation");
        boot(args, context);
        // Close the Spring context
        ((AnnotationConfigApplicationContext) context).close();
    }

    /**
     * Bootstraps the application by initializing calculation parameters.
     *
     * @param args    Command-line arguments provided to the application.
     * @param context The Spring application context.
     */
    private static void boot(final String[] args, final ApplicationContext context) {
        boot(context, prepareBoot(args));
    }

    /**
     * Bootstraps the application by initializing calculation parameters.
     *
     * @param context         The Spring application context.
     * @param bootstrap The bootstrap parameters for initialization.
     */
    private static void boot(final ApplicationContext context, final Bootstrap bootstrap) {
        BootstrapService bootstrapService = context.getBean(BootstrapService.class);
        bootstrapService.initializeCalculationParams(bootstrap);
    }

    /**
     * Prepares the bootstrap parameters based on the provided command-line arguments.
     *
     * @param args Command-line arguments provided to the application.
     * @return The prepared bootstrap parameters.
     */
    private static Bootstrap prepareBoot(final String[] args) {
        Parsable<Bootstrap> params = Bootstrap.builder().build();
        Bootstrap bootstrap = CommandLineToolParser.parseArgs(args, params);
        return bootstrap;
    }
}
