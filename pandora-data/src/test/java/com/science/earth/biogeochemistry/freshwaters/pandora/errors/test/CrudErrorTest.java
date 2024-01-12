package com.science.earth.biogeochemistry.freshwaters.pandora.errors.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.science.earth.biogeochemistry.freshwaters.pandora.errors.CrudError;

class CrudErrorTest {

    @Test
    void testConstructor() {
        String message = "This is a test message";
        CrudError error = new CrudError(message);
        assertEquals(message, error.getMessage());
    }

}
