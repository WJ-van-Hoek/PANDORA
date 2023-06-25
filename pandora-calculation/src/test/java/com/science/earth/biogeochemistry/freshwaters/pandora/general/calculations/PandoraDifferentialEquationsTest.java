package com.science.earth.biogeochemistry.freshwaters.pandora.general.calculations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.interfaces.PandoraScheme;

class PandoraDifferentialEquationsTest {

    @Mock
    PandoraScheme pandoraScheme;
    
    PandoraDifferentialEquations pandoraDifferentialEquations;

    @BeforeEach
    void setUp() throws Exception {
	MockitoAnnotations.openMocks(this);
	pandoraDifferentialEquations = PandoraDifferentialEquations.builder()
		.pandoraScheme(pandoraScheme).build();
    }

    @Test
    void testGetDimension() {
	//given
	when(pandoraScheme.getDimension()).thenReturn(2);
	
	//when
	int dimension = pandoraDifferentialEquations.getDimension();

	//then
	assertEquals(2, dimension);
    }

    @Test
    void testComputeDerivativesHappy() {
	//given
	when(pandoraScheme.getDimension()).thenReturn(2);	
	
	when(pandoraScheme.getTerrestrialSources(0)).thenReturn(1f);
	when(pandoraScheme.getTerrestrialSources(1)).thenReturn(5f);
	
	when(pandoraScheme.getTransformations(0)).thenReturn(2f);
	when(pandoraScheme.getTransformations(1)).thenReturn(7f);
	
	when(pandoraScheme.getTransport(0)).thenReturn(3f);
	when(pandoraScheme.getTransport(1)).thenReturn(2f);
	
	double t = 1f;
	double[] y = {0, 0};
	double[] dy = {0, 0};
	
	//when
	pandoraDifferentialEquations.computeDerivatives(t, y, dy);
	
	//then
	assertEquals(6f, dy[0]);
	assertEquals(14f, dy[1]);
    }

}
