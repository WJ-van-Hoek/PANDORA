package com.science.earth.biogeochemistry.freshwaters.pandora.general.calculations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.reflect.Field;

import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;
import org.apache.commons.math3.ode.FirstOrderIntegrator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.PandoraTimestep;

class PandoraIntegratorTest {
    @Mock
    private FirstOrderIntegrator firstOrderIntegrator;

    @Mock
    private PandoraTimestep pandoraScheme;

    @InjectMocks
    PandoraIntegrator integrator;

    @BeforeEach
    void setUp() throws Exception {
	MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPandoraIntegrator() {
	assertEquals(firstOrderIntegrator, getField(integrator, "firstOrderIntegrator"));
	assertEquals(pandoraScheme, getField(integrator, "pandoraScheme"));
    }

    @Test
    void testIntegrate() {
	// given
	double t0 = 0d;
	double[] y0 = { 0d, 0d };
	double tEnd = 1d;
	double[] y = { 0d, 0d };
	double expectedResult = 5d;

	when(pandoraScheme.getT0()).thenReturn(t0);
	when(pandoraScheme.getY0()).thenReturn(y0);
	when(pandoraScheme.getTEnd()).thenReturn(tEnd);
	ArgumentCaptor<FirstOrderDifferentialEquations> odeCaptor = ArgumentCaptor
		.forClass(FirstOrderDifferentialEquations.class);
	when(firstOrderIntegrator.integrate(odeCaptor.capture(), eq(t0), eq(y0), eq(tEnd), eq(y))).thenReturn(expectedResult);

	// when
	double actualResult = integrator.integrate();

	// then
	verify(pandoraScheme, times(1)).getT0();
	verify(pandoraScheme, times(2)).getY0();
	verify(pandoraScheme, times(1)).getTEnd();
	verify(firstOrderIntegrator, times(1)).integrate(odeCaptor.getValue(), t0, y0, tEnd, y);
	assertEquals(expectedResult, actualResult);
    }

    private Object getField(Object object, String fieldName) {
	try {
	    Field field = object.getClass().getDeclaredField(fieldName);
	    field.setAccessible(true);
	    return field.get(object);
	} catch (NoSuchFieldException | IllegalAccessException e) {
	    e.printStackTrace();
	}
	return null;
    }

}
