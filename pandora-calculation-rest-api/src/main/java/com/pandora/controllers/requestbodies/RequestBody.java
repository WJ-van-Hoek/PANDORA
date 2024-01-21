package com.pandora.controllers.requestbodies;

import jakarta.validation.ValidationException;

/**
 * The {@code RequestBody} interface defines the contract for request body objects. Implementing classes are expected to
 * provide a method for validating the content of the request body. The validation is performed through the
 * {@link #validate()} method. If the validation fails, a {@link ValidationException} is thrown, indicating that the
 * request body is not in a valid state.
 *
 * @author Wim Joost van Hoek
 * @version 0.0.1
 */
public interface RequestBody {
    /**
     * Validates the content of the request body.
     *
     * @throws ValidationException If the validation fails, indicating that the request body is not in a valid state.
     */
    void validate() throws ValidationException;
}
