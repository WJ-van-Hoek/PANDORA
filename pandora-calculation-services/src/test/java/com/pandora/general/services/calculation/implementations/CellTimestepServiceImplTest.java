package com.pandora.general.services.calculation.implementations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.pandora.general.objects.Cell;
import com.pandora.general.objects.PandoraTimestep;
import com.pandora.general.objects.services.abstractions.interfaces.DischargesMapService;
import com.pandora.general.objects.services.abstractions.interfaces.TerrestrialSourcesMapService;
import com.pandora.general.objects.services.abstractions.interfaces.UpstreamSourcesMapService;
import com.pandora.general.objects.services.abstractions.interfaces.VolumesMapService;
import com.pandora.general.objects.services.abstractions.interfaces.YMapService;
import com.pandora.general.objects.services.implementations.CellMapCrudService;
import com.pandora.general.services.calculation.interfaces.LocalDateTimeService;
import com.pandora.general.services.calculation.interfaces.PandoraIntegratorService;

/**
 * Javadoc for the CellTimestepServiceImplTest class.
 *
 * This class contains unit tests for the CellTimestepServiceImpl, which is responsible for calculating and storing the
 * next timestep values for a given cell based on its current state and environmental factors.
 */
public class CellTimestepServiceImplTest {

    /**
     * Mock object for YMapService used in testing.
     */
    @Mock
    private YMapService yMapService;

    /**
     * Mock object for TerrestrialSourcesMapService used in testing.
     */
    @Mock
    private TerrestrialSourcesMapService terrestrialSourcesMapService;

    /**
     * Mock object for UpstreamSourcesMapService used in testing.
     */
    @Mock
    private UpstreamSourcesMapService upstreamSourcesMapService;

    /**
     * Mock object for DischargesMapService used in testing.
     */
    @Mock
    private DischargesMapService dischargesMapService;

    /**
     * Mock object for VolumesMapService used in testing.
     */
    @Mock
    private VolumesMapService volumesMapService;

    /**
     * Mock object for PandoraIntegratorService used in testing.
     */
    @Mock
    private PandoraIntegratorService pandoraIntegratorService;

    /**
     * Mock object for CellMapCrudService used in testing.
     */
    @Mock
    private CellMapCrudService cellMapCrudService;

    /**
     * Mock object for LocalDateTimeService used in testing.
     */
    @Mock
    private LocalDateTimeService localDateTimeService;

    /**
     * Instance of CellTimestepServiceImpl to be tested.
     */
    @InjectMocks
    private CellTimestepServiceImpl cellTimestepService;

    /**
     * Sample cell used in testing.
     */
    private Cell cell;

    /**
     * Next cell used in testing.
     */
    private Cell nextCell;

    /**
     * Constant representing the initial datetime used in testing.
     */
    private static final LocalDateTime T_0 = LocalDateTime.of(2023, 7, 21, 0, 0);

    /**
     * Constant representing the end datetime used in testing.
     */
    private static final LocalDateTime T_END = T_0.plusYears(1);

    /**
     * Initial values for the cell state used in testing.
     */
    private static final double[] Y_0 = {0d, 0d};

    /**
     * Expected values for the cell state at the end of the test scenario.
     */
    private static final double[] Y_END = {3d, 3d};

    /**
     * Terrestrial sources values used in testing.
     */
    private static final double[] TERRESTRIAL_SOURCES = {1d, 1d};

    /**
     * Upstream sources values used in testing.
     */
    private static final double[] UPSTREAM_SOURCES = {1d, 1d};

    /**
     * Discharge value used in testing.
     */
    private static final Double DISCHARGE = 1d;

    /**
     * Volume value used in testing.
     */
    private static final Double VOLUME = 1d;

    /**
     * Set up method to initialize mock objects and test data before each test.
     *
     * @throws Exception if an exception occurs during setup.
     */
    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        cell = Cell.builder().id(0L).build();
        nextCell = Cell.builder().id(1L).build();
    }

    /**
     * Unit test for the calculateNextTimestep method.
     *
     * Verifies that the method properly calculates and stores the next timestep values for the given cell.
     */
    @Test
    void testCalculateNextTimestep() {
        // given
        // Mocking various method calls and setting up input values
        when(yMapService.findAtCellAndTimestep(cell, T_0)).thenReturn(Y_0);
        when(terrestrialSourcesMapService.findAtCellAndTimestep(cell, T_0)).thenReturn(TERRESTRIAL_SOURCES);
        when(upstreamSourcesMapService.findAtCellAndTimestep(cell, T_0)).thenReturn(UPSTREAM_SOURCES);
        when(dischargesMapService.findAtCellAndTimestep(cell, T_0)).thenReturn(DISCHARGE);
        when(volumesMapService.findAtCellAndTimestep(cell, T_0)).thenReturn(VOLUME);
        when(pandoraIntegratorService.integrate(any(PandoraTimestep.class))).thenReturn(Y_END);
        when(localDateTimeService.calculateTEndAsLocalDateTime(any(LocalDateTime.class), anyDouble()))
                .thenReturn(T_END);
        when(cellMapCrudService.findById(anyLong())).thenReturn(nextCell);

        // when
        cellTimestepService.calculateNextTimestep(cell, T_0);

        // then
        // Verifying method calls and asserting the captured values
        ArgumentCaptor<PandoraTimestep> pandoraTimestepCaptor = ArgumentCaptor.forClass(PandoraTimestep.class);
        verify(pandoraIntegratorService).integrate(pandoraTimestepCaptor.capture());
        Assertions.assertEquals(pandoraTimestepBuilder(), pandoraTimestepCaptor.getValue());

        ArgumentCaptor<LocalDateTime> t0Captor = ArgumentCaptor.forClass(LocalDateTime.class);
        ArgumentCaptor<Double> tEndCaptor = ArgumentCaptor.forClass(Double.class);
        verify(localDateTimeService).calculateTEndAsLocalDateTime(t0Captor.capture(), tEndCaptor.capture());
        Assertions.assertEquals(T_0, t0Captor.getValue());
        Assertions.assertEquals(1d, tEndCaptor.getValue());

        ArgumentCaptor<Cell> cellCaptor = ArgumentCaptor.forClass(Cell.class);
        ArgumentCaptor<LocalDateTime> dateTimeTEndCaptor = ArgumentCaptor.forClass(LocalDateTime.class);
        ArgumentCaptor<double[]> yEndCaptor = ArgumentCaptor.forClass(double[].class);
        verify(yMapService).saveAtCellAndTimestep(cellCaptor.capture(), dateTimeTEndCaptor.capture(),
                yEndCaptor.capture());
        Assertions.assertEquals(cell, cellCaptor.getValue());
        Assertions.assertEquals(T_END, dateTimeTEndCaptor.getValue());
        double[] capturedArray = yEndCaptor.getValue();
        Assertions.assertEquals(Y_END, capturedArray);
    }

    /**
     * Helper method to build a PandoraTimestep with constant values for testing.
     *
     * @return a PandoraTimestep object with constant values.
     */
    private PandoraTimestep pandoraTimestepBuilder() {
        return PandoraTimestep.builder().y0(Y_0).t0(0d).tEnd(1d).discharge(DISCHARGE).volume(VOLUME)
                .dimension(Y_0.length).terrestrialSources(TERRESTRIAL_SOURCES).upstreamSources(UPSTREAM_SOURCES)
                .build();
    }
}
