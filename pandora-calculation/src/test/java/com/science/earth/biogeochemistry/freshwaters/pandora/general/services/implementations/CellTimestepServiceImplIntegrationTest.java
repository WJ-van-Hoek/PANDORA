package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.implementations;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.Cell;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.PandoraTimestep;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.interfaces.DischargesMapService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.interfaces.TerrestrialSourcesMapService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.interfaces.UpstreamSourcesMapService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.interfaces.VolumesMapService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.interfaces.YMapService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces.CellTimestepService;

@SpringBootTest
class CellTimestepServiceImplIntegrationTest {
    private static final Cell CELL = Cell.builder().id(1l).centerLatitude(52.08f).centerLongitude(5.67f).surfaceArea(1754.27f).nextCellId(1l).build();
    private static final LocalDate LOCAL_DATE = LocalDate.of(2023, 8, 9);
    private static final LocalTime LOCAL_TIME = LocalTime.of(0, 0);
    private static final LocalDateTime T_0 = LocalDateTime.of(LOCAL_DATE, LOCAL_TIME);
    private static final PandoraTimestep PANDORA_TIMESTEP = PandoraTimestep.builder().discharge(10d).volume(1d).build();
    private static final double[] Y_0 = {1d,1d}; 
    private static final double[] TERRESTRIAL_SOURCES = {2d, 2d};
    private static final double[] UPSTREAM_SOURCES = {3d, 3d};
    private static final Double DISCHARGE = 1d;
    private static final double VOLUME = 1d;
    private static final double[] Y_END = {19.7403d, 21.5063d};
    
    @Autowired
    YMapService yMapService;
    
    @Autowired
    TerrestrialSourcesMapService terrestrialSourcesMapService;
    
    @Autowired
    UpstreamSourcesMapService upstreamSourcesMapService;
    
    @Autowired
    DischargesMapService dischargesMapService;
    
    @Autowired
    VolumesMapService volumesMapService;
    
    @Autowired
    CellTimestepService cellTimestepService;

    @BeforeEach
    void setUp() throws Exception {
	yMapService.cleanMap();
	yMapService.saveAtCellAndTimestep(CELL, T_0, Y_0);
	terrestrialSourcesMapService.cleanMap();
	terrestrialSourcesMapService.saveAtCellAndTimestep(CELL, T_0, TERRESTRIAL_SOURCES);
	upstreamSourcesMapService.cleanMap();
	upstreamSourcesMapService.saveAtCellAndTimestep(CELL, PANDORA_TIMESTEP, T_0, UPSTREAM_SOURCES);
	dischargesMapService.cleanMap();
	dischargesMapService.saveAtCellAndTimestep(CELL, T_0, DISCHARGE);
	volumesMapService.cleanMap();
	volumesMapService.saveAtCellAndTimestep(CELL, T_0, VOLUME);
	
    }

    @Test
    void testCalculateNextTimestep() {
	cellTimestepService.calculateNextTimestep(CELL, T_0);
	Assertions.assertArrayEquals(Y_END,  yMapService.findAtCellAndTimestep(CELL, T_0.plusYears(1)), 1e-3);
    }
}