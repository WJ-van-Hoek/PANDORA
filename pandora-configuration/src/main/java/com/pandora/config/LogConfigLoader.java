package com.pandora.config;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.util.StatusPrinter2;
import org.slf4j.LoggerFactory;

/**
 * Utility class for loading Logback configuration from a centralized logback.xml file.
 */
public class LogConfigLoader {

    /**
     * Loads and applies the Logback configuration from the classpath.
     */
    public static void loadConfig() {
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        try {
            JoranConfigurator configurator = new JoranConfigurator();
            configurator.setContext(context);
            context.reset();
            configurator.doConfigure(LogConfigLoader.class.getClassLoader().getResourceAsStream("logback.xml"));
        } catch (Exception e) {
            new StatusPrinter2().print(context);
        }
    }
}
