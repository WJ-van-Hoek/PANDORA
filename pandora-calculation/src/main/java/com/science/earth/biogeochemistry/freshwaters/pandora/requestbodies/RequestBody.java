package com.science.earth.biogeochemistry.freshwaters.pandora.requestbodies;

import jakarta.xml.bind.ValidationException;

public interface RequestBody {
    void validate() throws ValidationException;
}
