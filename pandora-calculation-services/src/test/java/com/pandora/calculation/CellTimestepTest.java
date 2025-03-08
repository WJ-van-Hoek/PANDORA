package com.pandora.calculation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.pandora.calculation.data.FixCellDataPoint;

class CellTimestepTest {

    /**
     * Mocked instance of FixCellDataPoint to simulate a cell data point.
     */
    private FixCellDataPoint _mockCell;

    /**
     * Array representing the initial state variables of the cell.
     */
    private double[] _initialY0;

    /**
     * Array representing the final state variables of the cell.
     */
    private double[] _finalYEnd;

    /**
     * Initial state variable 1 of the cell.
     */
    private static final double INIT_Y0_1 = 1.0;

    /**
     * Initial state variable 2 of the cell.
     */
    private static final double INIT_Y0_2 = 2.0;

    /**
     * Initial state variable 3 of the cell.
     */
    private static final double INIT_Y0_3 = 3.0;

    /**
     * Final state variable 1 of the cell.
     */
    private static final double FINAL_YEND_1 = 4.0;

    /**
     * Final state variable 2 of the cell.
     */
    private static final double FINAL_YEND_2 = 5.0;

    /**
     * Final state variable 3 of the cell.
     */
    private static final double FINAL_YEND_3 = 6.0;

    @BeforeEach
    void setUp() {
        _mockCell = Mockito.mock(FixCellDataPoint.class);
        _initialY0 = new double[]{INIT_Y0_1, INIT_Y0_2, INIT_Y0_3};
        _finalYEnd = new double[]{FINAL_YEND_1, FINAL_YEND_2, FINAL_YEND_3};
    }

    @Test
    void testConstructorAndGetters() {
        CellTimestep timestep = new CellTimestep(_mockCell, _initialY0);

        assertNotNull(timestep);
        assertEquals(_mockCell, timestep.getCell());
        assertArrayEquals(_initialY0, timestep.getY0());
        assertNull(timestep.getYEnd());
    }

    @Test
    void testSetYEnd() {
        CellTimestep timestep = new CellTimestep(_mockCell, _initialY0);
        timestep.setYEnd(_finalYEnd);

        assertArrayEquals(_finalYEnd, timestep.getYEnd());
    }
}
