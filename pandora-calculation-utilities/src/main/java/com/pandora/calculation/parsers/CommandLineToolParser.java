package com.pandora.calculation.parsers;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import lombok.extern.slf4j.Slf4j;

/**
 * A utility class for parsing command-line arguments.
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 */
@Slf4j
public class CommandLineToolParser {

    /**
     * Parses the command-line arguments and constructs an object of type T using the provided Parsable instance.
     *
     * @param args The command-line arguments.
     * @param parsable An instance of Parsable to parse the command-line arguments and construct the desired object.
     * @param <T> The type of object to be constructed.
     * @return The object of type T constructed from the command-line arguments, or null if parsing fails.
     */
    public static <T> T parseArgs(final String[] args, final Parsable<T> parsable) {
        Options options = createOptions();
        return parseArgs(args, options, parsable);
    }

    /**
     * Creates options for the command-line parser.
     *
     * @return The Options object containing the command-line options.
     */
    private static Options createOptions() {
        Options options = new Options();
        addSpecieConfigurationsOption(options);
        return options;
    }

    private static void addSpecieConfigurationsOption(final Options options) {
        options.addOption(Option.builder().longOpt("specieConfigurations").desc("Path to the specie configuration file")
                .hasArg().argName("file").build());
    }

    /**
     * Parses the command-line arguments using the provided options and constructs an object of type T using the
     * provided Parsable instance.
     *
     * @param args The command-line arguments.
     * @param options The Options object containing the command-line options.
     * @param parsable An instance of Parsable to parse the command-line arguments and construct the desired object.
     * @param <T> The type of object to be constructed.
     * @return The object of type T constructed from the command-line arguments, or null if parsing fails.
     */
    private static <T> T parseArgs(final String[] args, final Options options, final Parsable<T> parsable) {
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);
            return parsable.parse(cmd);
        } catch (ParseException e) {
            // Log parsing exceptions
            log.error("Error parsing command-line arguments: {}", e.getMessage());
            return null;
        }
    }
}
