package com.pandora.calculation.parsers;

import org.apache.commons.cli.CommandLine;

/**
 * The {@code Parsable} interface represents an entity capable of parsing command-line arguments into an object of type
 * {@code T}. Implementations of this interface provide a method for parsing command-line arguments.
 *
 * @param <T> The type of object to parse the command-line arguments into.
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 */
public interface Parsable<T> {
    /**
     * Parses the command-line arguments into an object of type {@code T}.
     *
     * @param cmd The command line containing the arguments to parse.
     * @return An object of type {@code T} parsed from the command line.
     */
    T parse(CommandLine cmd);
}
