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
public class CellTimestepServiceImplIntegrationTest {
    /**
     * Constant representing a sample cell ID used in testing.
     */
    private static final long CELL_ID = 1L;

    /**
     * Constant representing a sample center latitude used in testing.
     */
    private static final float CENTER_LATITUDE = 52.08f;

    /**
     * Constant representing a sample center longitude used in testing.
     */
    private static final float CENTER_LONGITUDE = 5.67f;

    /**
     * Constant representing a sample surface area used in testing.
     */
    private static final float SURFACE_AREA = 1754.27f;

    /**
     * Constant representing a sample next cell ID used in testing.
     */
    private static final long NEXT_CELL_ID = 1L;

    /**
     * Constant representing a sample cell used in testing.
     */
    private static final Cell CELL = Cell.builder().id(CELL_ID).centerLatitudeParam(CENTER_LATITUDE)
            .centerLongitudeParam(CENTER_LONGITUDE).surfaceAreaParam(SURFACE_AREA).nextCellIdParam(NEXT_CELL_ID)
            .build();

    /**
     * Constant representing a sample date used in testing.
     */
    private static final LocalDate LOCAL_DATE = LocalDate.of(2023, 8, 9);

    /**
     * Constant representing a sample time used in testing.
     */
    private static final LocalTime LOCAL_TIME = LocalTime.of(0, 0);

    /**
     * Constant representing the initial datetime used in testing.
     */
    private static final LocalDateTime T_0 = LocalDateTime.of(LOCAL_DATE, LOCAL_TIME);

    /**
     * Constant representing a sample discharge value used in testing.
     */
    private static final double DISCHARGE_VALUE = 10d;

    /**
     * Constant representing a sample volume value used in testing.
     */
    private static final double VOLUME_VALUE = 1d;

    /**
     * Constant representing a sample Pandora timestep used in testing.
     */
    private static final PandoraTimestep PANDORA_TIMESTEP = PandoraTimestep.builder().discharge(DISCHARGE_VALUE)
            .volume(VOLUME_VALUE).build();

    /**
     * Constant representing initial values for the cell state used in testing.
     */
    private static final double[] Y_0 = {1d, 1d};

    /**
     * Constant representing terrestrial sources values used in testing.
     */
    private static final double[] TERRESTRIAL_SOURCES = {2d, 2d};

    /**
     * Constant representing upstream sources values used in testing.
     */
    private static final double[] UPSTREAM_SOURCES = {3d, 3d};

    /**
     * Constant representing discharge value used in testing.
     */
    private static final Double DISCHARGE = 1d;

    /**
     * Constant representing volume value used in testing.
     */
    private static final double VOLUME = 1d;

    /**
     * Constant representing the expected cell state at the end of the test scenarios.
     */
    private static final double[] Y_END = {19.7403d, 21.5063d};

    /**
     * Constant representing the tolerance for deviation of the outcome of the integration.
     */
    private static final double TOLERANCE = 1e-3;

    /**
     * Autowired service for managing Y values.
     */
    @Autowired
    private YMapService yMapService;

    /**
     * Autowired service for managing terrestrial sources values.
     */
    @Autowired
    private TerrestrialSourcesMapService terrestrialSourcesMapService;

    /**
     * Autowired service for managing upstream sources values.
     */
    @Autowired
    private UpstreamSourcesMapService upstreamSourcesMapService;

    /**
     * Autowired service for managing discharge values.
     */
    @Autowired
    private DischargesMapService dischargesMapService;

    /**
     * Autowired service for managing volume values.
     */
    @Autowired
    private VolumesMapService volumesMapService;

    /**
     * Autowired implementation of the CellTimestepService to be tested.
     */
    @Autowired
    private CellTimestepService cellTimestepService;

    /**
     * Set up method to initialize test data in the maps before each test.
     *
     * @throws Exception if an exception occurs during setup.
     */
    @BeforeEach
    void setUp() throws Exception {
        // Cleaning and saving initial data in the maps for testing
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

    /**
     * Integration test for the calculateNextTimestep method.
     *
     * Verifies that the method properly calculates and stores the next timestep values for the given cell.
     */
    @Test
    void testCalculateNextTimestep() {
        cellTimestepService.calculateNextTimestep(CELL, T_0);
        Assertions.assertArrayEquals(Y_END, yMapService.findAtCellAndTimestep(CELL, T_0.plusYears(1)), TOLERANCE);
    }

    /**
     * Integration test for the calculateTimeSeries method.
     *
     * Verifies that the method properly calculates and stores the time series for the given cell.
     */
    @Test
    void testCalculateTimeSeries() {
        cellTimestepService.calculateTimeSeries(CELL, T_0, 1);
        Assertions.assertArrayEquals(Y_END, yMapService.findAtCellAndTimestep(CELL, T_0.plusYears(1)), TOLERANCE);
    }
}
