package com.science.earth.biogeochemistry.freshwaters.pandora.controllers.requestbodies;

import jakarta.xml.bind.ValidationException;

public interface RequestBody {
    /**
     * Validates the content of the request body.
     *
     * @throws ValidationException If the validation fails, indicating that the request body is not in a vsalid state.
     */
    void validate() throws ValidationException;
}
