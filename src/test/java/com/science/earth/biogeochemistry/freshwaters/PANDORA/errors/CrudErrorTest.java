package com.science.earth.biogeochemistry.freshwaters.PANDORA.errors;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CrudErrorTest {

    @Test
    void testConstructor() {
        String message = "This is a test message";
        CrudError error = new CrudError(message);
        assertEquals(message, error.getMessage());
    }

}
