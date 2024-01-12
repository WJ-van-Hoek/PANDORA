package com.science.earth.biogeochemistry.freshwaters.pandora.errors;

public class ServiceImplError extends Error {
    /**
     * Constructs a new {@code ServiceImplError} with the specified error message.
     *
     * @param message The detailed error message providing information about the nature of the issue.
     */
    public ServiceImplError(final String message) {
        super(message);
    }
}
