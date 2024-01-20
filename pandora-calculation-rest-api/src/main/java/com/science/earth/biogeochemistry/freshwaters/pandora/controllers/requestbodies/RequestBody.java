package com.pandora.controllers.requestbodies;

import jakarta.validation.ValidationException;

public interface RequestBody {
    /**
     * Validates the content of the request body.
     *
     * @throws ValidationException If the validation fails, indicating that the request body is not in a valid state.
     */
    void validate() throws ValidationException;
}
