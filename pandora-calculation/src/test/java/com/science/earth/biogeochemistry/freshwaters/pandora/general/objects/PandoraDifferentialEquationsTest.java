package com.science.earth.biogeochemistry.freshwaters.pandora.general.objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces.ReactionCalculationService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces.TransportCalculationService;

/**
 * Javadoc for the PandoraDifferentialEquationsTest class.
 *
 * This class contains unit tests for the PandoraDifferentialEquations class, which is responsible for solving a system
 * of differential equations using provided services for timestep, reaction calculation, and transport calculation.
 */
class PandoraDifferentialEquationsTest {

    /**
     * Mock object for PandoraTimestep used in testing.
     */
    @Mock
    private PandoraTimestep pandoraTimestep;

    /**
     * Mock object for ReactionCalculationService used in testing.
     */
    @Mock
    private ReactionCalculationService reactionCalculationService;

    /**
     * Mock object for TransportCalculationService used in testing.
     */
    @Mock
    private TransportCalculationService transportCalculationService;

    /**
     * Instance of PandoraDifferentialEquations used in testing.
     */
    private PandoraDifferentialEquations pandoraDifferentialEquations;

    /**
     * Set up method to initialize mock objects and the instance of PandoraDifferentialEquations before each test.
     *
     * @throws Exception if an exception occurs during setup.
     */
    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        pandoraDifferentialEquations = PandoraDifferentialEquations.builder().pandoraTimestep(pandoraTimestep)
                .transportCalculationService(transportCalculationService)
                .reactionCalculationService(reactionCalculationService).build();
    }

    /**
     * Unit test for the getDimension method.
     *
     * Verifies that the getDimension method returns the expected dimension value.
     */
    @Test
    void testGetDimension() {
        // given
        when(pandoraTimestep.getDimension()).thenReturn(2);

        // when
        int dimension = pandoraDifferentialEquations.getDimension();

        // then
        assertEquals(2, dimension);
    }

    /**
     * Unit test for the computeDerivatives method with happy path scenario.
     *
     * Verifies that the computeDerivatives method calculates derivatives correctly based on the provided inputs.
     */
    @Test
    void testComputeDerivativesHappy() {
        // given
        // Variables for dimension and array indices
        final int dimension = 2;
        final int indexElement1 = 0;
        final int indexElement2 = 1;
        final double reactionElement1 = -0.2;
        final double reactionElement2 = 0.2;
        final double terrestrialSourceElement1 = 1d;
        final double terrestrialSourceElement2 = 5d;
        final double upstreamSourceElement1 = 2d;
        final double upstreamSourceElement2 = 6d;
        final double transportElement1 = 0.1;
        final double transportElement2 = 0.1;

        // Variables for mock reaction and transport returns
        double[] mockReactionReturn = {reactionElement1, reactionElement2};
        double[] mockTransportReturn = {transportElement1, transportElement2};

        // Stubbing using variables
        when(pandoraTimestep.getDimension()).thenReturn(dimension);

        when(pandoraTimestep.getTerrestrialSources(indexElement1)).thenReturn(terrestrialSourceElement1);
        when(pandoraTimestep.getTerrestrialSources(indexElement2)).thenReturn(terrestrialSourceElement2);

        when(pandoraTimestep.getUpstreamSources(indexElement1)).thenReturn(upstreamSourceElement1);
        when(pandoraTimestep.getUpstreamSources(indexElement2)).thenReturn(upstreamSourceElement2);

        when(reactionCalculationService.calculateReactions(any(double[].class))).thenReturn(mockReactionReturn);

        when(transportCalculationService.calculateTransport(any(double[].class), any(PandoraTimestep.class)))
            .thenReturn(mockTransportReturn);

        double t = 1f;
        double[] y = {0, 0};
        double[] dy = {0, 0};

        // when
        pandoraDifferentialEquations.computeDerivatives(t, y, dy);

        // then
        final double expectedDerivative1 = 2.7d;
        final double expectedDerivative2 = 11.1d;
        final double tolerance = 1e-3;

        // Verifying that the computed derivatives match the expected values within a specified tolerance
        assertEquals(expectedDerivative1, dy[0], tolerance);
        assertEquals(expectedDerivative2, dy[1], tolerance);
    }
}
