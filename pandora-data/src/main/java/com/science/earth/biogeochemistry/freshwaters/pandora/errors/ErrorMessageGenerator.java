package com.science.earth.biogeochemistry.freshwaters.pandora.errors;

public interface ErrorMessageGenerator {
    /**
     * Generates an error message based on the provided message property and optional arguments.
     *
     * @param messageProperty The key or property identifying the error message.
     * @param args Optional arguments to be inserted into the error message template.
     * @return The formatted error message.
     */
    String generate(String messageProperty, Object... args);
}
