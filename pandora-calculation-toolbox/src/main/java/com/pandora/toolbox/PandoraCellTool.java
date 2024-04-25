package com.pandora.toolbox;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pandora.calculation.bootstrap.BootContent;
import com.pandora.calculation.parsers.CommandLineToolParser;
import com.pandora.calculation.parsers.Parsable;
import com.pandora.calculation.services.BootService;
import com.pandora.calculation.services.CalculationService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Wim Joost van Hoek.
 * @since 0.0.1
 * @version 0.0.1
 */
@Slf4j
public class PandoraCellTool {
    /**
     * The main method serves as the entry point for the PANDORAl Cell Tool application.
     * <p>
     * The loads the Spring context, preprocesses all configurations, parameters and data, and closes the Spring context
     * afterwards.
     *
     * @param args Command-line arguments provided to the application.
     */
    public static void main(final String[] args) {
        ApplicationContext context = loadContext();
        preProcess(args, context);
        calculate(args, context);
        postProcess(args, context);
        closeContext(context);
    }

    private static void closeContext(final ApplicationContext context) {
        log.info("Closing Application Context.");
        ((AnnotationConfigApplicationContext) context).close();
        log.info("Sucessfully closed Application Context.");
    }

    private static ApplicationContext loadContext() {
        log.info("Loading Application Context.");
        ApplicationContext context = new AnnotationConfigApplicationContext("com.pandora.calculation");
        log.info("Sucessfully loaded Application Context.");
        return context;
    }

    /**
     * Postprocessing the results of the calculation.
     *
     * @param args Command-line arguments provided to the application.
     * @param context The Spring application context.
     */
    private static void postProcess(final String[] args, final ApplicationContext context) {
        log.info("Postprocessing...");
     // TODO Auto-generated method stub
        log.info("Sucessfully finished postprocessing.");
    }

    /**
     * The actual calculation.
     *
     * @param args Command-line arguments provided to the application.
     * @param context The Spring application context.
     */
    private static void calculate(final String[] args, final ApplicationContext context) {
        log.info("Calculating...");
        CalculationService calculationService = context.getBean(CalculationService.class);
        calculationService.calculate();
        log.info("Sucessfully finished the calculation.");
    }

    /**
     * Preprocess the application by initializing calculation parameters.
     *
     * @param args Command-line arguments provided to the application.
     * @param context The Spring application context.
     */
    private static void preProcess(final String[] args, final ApplicationContext context) {
        log.info("Preprocessing...");
        boot(context, prepareBoot(args));
        log.info("Sucessfully finished preprocessing.");
    }

    /**
     * Bootstraps the application by initializing calculation parameters.
     *
     * @param context The Spring application context.
     * @param bootstrap The bootstrap parameters for initialization.
     */
    private static void boot(final ApplicationContext context, final BootContent bootstrap) {
        BootService bootstrapService = context.getBean(BootService.class);
        bootstrapService.boot(bootstrap);
    }

    /**
     * Prepares the bootstrap parameters based on the provided command-line arguments.
     *
     * @param args Command-line arguments provided to the application.
     * @return The prepared bootstrap parameters.
     */
    private static BootContent prepareBoot(final String[] args) {
        Parsable<BootContent> params = BootContent.builder().build();
        BootContent bootstrap = CommandLineToolParser.parseArgs(args, params);
        return bootstrap;
    }
}
