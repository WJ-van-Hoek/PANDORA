package com.pandora.errors;

public class CrudError extends Error {
    /**
     * Constructs a new {@code CrudError} with the specified error message.
     *
     * @param message The descriptive message explaining the error.
     */
    public CrudError(final String message) {
        super(message);
    }
}
