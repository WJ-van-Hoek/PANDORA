package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.implementations;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.CellBaseObject;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces.CellTimestepService;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.mapcrudservices.implementations.TerrestrialSourcesMapService;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.mapcrudservices.implementations.UpstreamSourcesMapService;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.mapcrudservices.implementations.YMapService;

@SpringBootTest
class CellTimestepServiceImplIntegrationTest {
    private static final CellBaseObject CELL = CellBaseObject.builder().centerlatitude(52.08f).centerlongitude(5.67f).surfaceArea(1754.27f).build();
    private static final LocalDate LOCAL_DATE = LocalDate.of(2023, 8, 9);
    private static final LocalTime LOCAL_TIME = LocalTime.of(0, 0);
    private static final LocalDateTime T_0 = LocalDateTime.of(LOCAL_DATE, LOCAL_TIME);
    private static final double[] Y_0 = {1d,1d}; 
    private static final double[] TERRESTRIAL_SOURCES = {2d, 2d};
    private static final double[] UPSTREAM_SOURCES = {3d, 3d};
    private static final double[] Y_END = {5.663d, 6.364d};
    
    @Autowired
    YMapService yMapService;
    
    @Autowired
    TerrestrialSourcesMapService terrestrialSourcesMapService;
    
    @Autowired
    UpstreamSourcesMapService upstreamSourcesMapService;
    
    @Autowired
    CellTimestepService cellTimestepService;

    @BeforeEach
    void setUp() throws Exception {
	yMapService.cleanMap();
	yMapService.saveAtCellAndTimestep(CELL, T_0, Y_0);
	terrestrialSourcesMapService.cleanMap();
	terrestrialSourcesMapService.saveAtCellAndTimestep(CELL, T_0, TERRESTRIAL_SOURCES);
	upstreamSourcesMapService.cleanMap();
	upstreamSourcesMapService.saveAtCellAndTimestep(CELL, T_0, UPSTREAM_SOURCES);
    }

    @Test
    void testCalculateNextTimestep() {
	cellTimestepService.calculateNextTimestep(CELL, T_0);
	Assertions.assertArrayEquals(Y_END,  yMapService.findAtCellAndTimestep(CELL, T_0.plusYears(1)), 1e-3);
    }
}