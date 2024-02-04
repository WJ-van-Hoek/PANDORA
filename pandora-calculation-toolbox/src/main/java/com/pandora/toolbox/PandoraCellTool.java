package com.pandora.toolbox;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.pandora.calculation.bootstrap.BootstrapParams;
import com.pandora.calculation.parsers.CommandLineToolParser;
import com.pandora.calculation.parsers.Parsable;
import com.pandora.calculation.services.BootstrapService;


//TODO write javdocs
/**
 *
 * @author Wim Joost van Hoek
 * @version 0.0.1
 * @since 0.0.1
 */
public class PandoraCellTool {
    /**
     * @param args
     */
    public static void main(final String[] args) {
        // Load the Spring context
        ApplicationContext context = new AnnotationConfigApplicationContext("com.pandora.calculation");
        boot(args, context);
        // Close the Spring context
        ((AnnotationConfigApplicationContext) context).close();
    }

    private static void boot(final String[] args, final ApplicationContext context) {
        boot(context, prepareBoot(args));
    }

    private static void boot(final ApplicationContext context, final BootstrapParams bootstrapParams) {
        BootstrapService bootstrapService = context.getBean(BootstrapService.class);
        bootstrapService.initializeCalculationParams(bootstrapParams);
    }

    private static BootstrapParams prepareBoot(final String[] args) {
        Parsable<BootstrapParams> params = new BootstrapParams();
        BootstrapParams bootstrapParams = CommandLineToolParser.parseArgs(args, params);
        return bootstrapParams;
    }

}
