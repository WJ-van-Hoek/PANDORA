package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.implementations;

import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.CellTimestepBaseObject;

class CellTimestepServiceImplTest {
    
    private static final LocalDateTime T_0 = LocalDateTime.of(2023, 7, 21, 0, 0);
    
    private CellTimestepBaseObject cellTimestep;


    @BeforeEach
    void setUp() throws Exception {
    }

    @Test
    void testCalculateNextTimestep() {
	fail("Not yet implemented");
    }

}