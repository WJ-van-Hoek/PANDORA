// checkstyle.suppressJavadocPackage
package com.pandora.general.objects;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;
import org.apache.commons.math3.ode.FirstOrderIntegrator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.pandora.general.services.calculation.implementations.PandoraIntegratorServiceImpl;
import com.pandora.general.services.calculation.interfaces.FirstOrderDifferentialEquationsService;

public class PandoraIntegratorServiceImplTest {

    /**
     * Mock object for the FirstOrderDifferentialEquationsService used in testing.
     */
    @Mock
    private FirstOrderDifferentialEquationsService firstOrderDifferentialEquationsService;

    /**
     * Mock object for the FirstOrderIntegrator used in testing.
     */
    @Mock
    private FirstOrderIntegrator firstOrderIntegratorMock;

    /**
     * Mock object for the PandoraTimestep used in testing.
     */
    @Mock
    private PandoraTimestep pandoraTimestep;

    /**
     * Instance of PandoraIntegratorServiceImpl to be tested.
     */
    @InjectMocks
    private PandoraIntegratorServiceImpl pandoraIntegratorService;

    /**
     * Set up method to initialize mock objects before each test.
     *
     * @throws Exception if an exception occurs during setup.
     */
    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Unit test for the integrate method.
     *
     * Verifies that the integrate method properly integrates the system of first-order differential equations using the
     * provided integrator and timestep.
     */
    @Test
    void testIntegrate() {
        // given
        // Mocking various method calls and setting up input values
        FirstOrderDifferentialEquations firstOrderDifferentialEquationsMock = Mockito
                .mock(FirstOrderDifferentialEquations.class);

        when(firstOrderDifferentialEquationsService.getPandoraDifferentialEquations(pandoraTimestep))
                .thenReturn(firstOrderDifferentialEquationsMock);

        double t0 = 0d;
        double[] y0 = {0d, 0d};
        double tEnd = 1d;

        when(pandoraTimestep.getT0()).thenReturn(t0);
        when(pandoraTimestep.getY0()).thenReturn(y0);
        when(pandoraTimestep.getTEnd()).thenReturn(tEnd);

        // when
        double[] actualResult = pandoraIntegratorService.integrate(pandoraTimestep);

        // then
        // Verifying method calls and asserting the result
        verify(firstOrderDifferentialEquationsService, times(1)).getPandoraDifferentialEquations(pandoraTimestep);
        verify(pandoraTimestep, times(1)).getT0();
        verify(pandoraTimestep, times(2)).getY0();
        verify(pandoraTimestep, times(1)).getTEnd();
        assertArrayEquals(new double[y0.length], actualResult);
    }
}
