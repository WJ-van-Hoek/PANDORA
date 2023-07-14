package com.science.earth.biogeochemistry.freshwaters.pandora.general.calculations;

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

import com.science.earth.biogeochemistry.freshwaters.pandora.general.PandoraTimestep;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.implementations.PandoraIntegratorServiceImpl;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.interfaces.FirstOrderDifferentialEquationsService;

class PandoraIntegratorServiceImplTest {
    @Mock
    private FirstOrderDifferentialEquationsService firstOrderDifferentialEquationsService;
    
    @Mock
    private FirstOrderIntegrator firstOrderIntegratorMock;

    @Mock
    private PandoraTimestep pandoraTimestep;

    @InjectMocks
    PandoraIntegratorServiceImpl pandoraIntegratorService;

    @BeforeEach
    void setUp() throws Exception {
	MockitoAnnotations.openMocks(this);
    }

    @Test
    void testIntegrate() {
	// given
	FirstOrderDifferentialEquations firstOrderDifferentialEquationsMock = Mockito.mock(FirstOrderDifferentialEquations.class);
	
	when(firstOrderDifferentialEquationsService.getPandoraDifferentialEquations()).thenReturn(firstOrderDifferentialEquationsMock);
	
	double t0 = 0d;
	double[] y0 = { 0d, 0d };
	double tEnd = 1d;

	when(pandoraTimestep.getT0()).thenReturn(t0);
	when(pandoraTimestep.getY0()).thenReturn(y0);
	when(pandoraTimestep.getTEnd()).thenReturn(tEnd);

	// when
	double[] actualResult = pandoraIntegratorService.integrate(pandoraTimestep);

	// then
	verify(firstOrderDifferentialEquationsService, times(1)).getPandoraDifferentialEquations();
	verify(pandoraTimestep, times(1)).getT0();
	verify(pandoraTimestep, times(2)).getY0();
	verify(pandoraTimestep, times(1)).getTEnd();
	assertArrayEquals(new double[y0.length], actualResult);
    }
}
