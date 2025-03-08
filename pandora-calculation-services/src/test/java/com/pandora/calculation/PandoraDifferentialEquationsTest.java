package com.pandora.calculation;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.pandora.calculation.services.ReactionCalculationService;
import com.pandora.calculation.services.TransportCalculationService;

class PandoraDifferentialEquationsTest {

    /**
     * The dimension of the ODE system being tested.
     */
    private static final int DIMENSION = 3;

    /**
     * The value of terrestrial sources used in calculations.
     */
    private static final double SOURCE_VALUE = 1.0;

    /**
     * The value of upstream sources used in calculations.
     */
    private static final double UPSTREAM_VALUE = 2.0;

    /**
     * The time parameter used in derivative calculations.
     */
    private static final double TIME = 0.0;

    /**
     * Acceptable delta for floating-point comparisons.
     */
    private static final double DELTA = 1e-6;

    /**
     * The initial values of the dependent variables.
     */
    private static final double[] INITIAL_Y = {1.0, 2.0, 3.0};

    /**
     * The expected computed derivative values.
     */
    private static final double[] EXPECTED_DY = {3.05, 3.1, 3.15};

    /**
     * The derivatives contributed by reaction calculations.
     */
    private static final double[] REACTION_DY = {0.1, 0.2, 0.3};

    /**
     * The derivatives contributed by transport calculations.
     */
    private static final double[] TRANSPORT_DY = {0.05, 0.1, 0.15};

    /**
     * Mock instance of PandoraTimestep used for testing.
     */
    @Mock
    private PandoraTimestep _mockPandoraTimestep;

    /**
     * Mock instance of TransportCalculationService used for testing transport calculations.
     */
    @Mock
    private TransportCalculationService _mockTransportService;

    /**
     * Mock instance of ReactionCalculationService used for testing reaction calculations.
     */
    @Mock
    private ReactionCalculationService _mockReactionService;

    /**
     * Instance of PandoraDifferentialEquations with injected mock dependencies.
     */
    @InjectMocks
    private PandoraDifferentialEquations _pandoraODE;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(_mockPandoraTimestep.getDimension()).thenReturn(DIMENSION);
    }

    @Test
    void testGetDimension() {
        assertEquals(DIMENSION, _pandoraODE.getDimension());
        verify(_mockPandoraTimestep).getDimension();
    }

    @Test
    void testComputeDerivatives() {
        double[] dy = new double[DIMENSION];

        when(_mockReactionService.calculateReactions(INITIAL_Y)).thenReturn(REACTION_DY);
        when(_mockTransportService.calculateTransport(INITIAL_Y, _mockPandoraTimestep)).thenReturn(TRANSPORT_DY);
        when(_mockPandoraTimestep.getTerrestrialSources(anyInt())).thenReturn(SOURCE_VALUE);
        when(_mockPandoraTimestep.getUpstreamSources(anyInt())).thenReturn(UPSTREAM_VALUE);

        _pandoraODE.computeDerivatives(TIME, INITIAL_Y, dy);

        assertArrayEquals(EXPECTED_DY, dy, DELTA);
        verify(_mockReactionService).calculateReactions(INITIAL_Y);
        verify(_mockTransportService).calculateTransport(INITIAL_Y, _mockPandoraTimestep);
    }
}
