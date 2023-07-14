package com.science.earth.biogeochemistry.freshwaters.pandora.general.calculations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.PandoraTimestep;

class PandoraDifferentialEquationsTest {

    @Mock
    PandoraTimestep pandoraTimestep;
    
    PandoraDifferentialEquations pandoraDifferentialEquations;

    @BeforeEach
    void setUp() throws Exception {
	MockitoAnnotations.openMocks(this);
	pandoraDifferentialEquations = PandoraDifferentialEquations.builder()
		.pandoraTimestep(pandoraTimestep).build();
    }

    @Test
    void testGetDimension() {
	//given
	when(pandoraTimestep.getDimension()).thenReturn(2);
	
	//when
	int dimension = pandoraDifferentialEquations.getDimension();

	//then
	assertEquals(2, dimension);
    }

    @Test
    void testComputeDerivativesHappy() {
	//given
	when(pandoraTimestep.getDimension()).thenReturn(2);	
	
	when(pandoraTimestep.getTerrestrialSources(0)).thenReturn(1d);
	when(pandoraTimestep.getTerrestrialSources(1)).thenReturn(5d);
	
	when(pandoraTimestep.getUpstreamSources(0)).thenReturn(2d);
	when(pandoraTimestep.getUpstreamSources(1)).thenReturn(6d);
		
	double t = 1f;
	double[] y = {0, 0};
	double[] dy = {0, 0};
	
	//when
	pandoraDifferentialEquations.computeDerivatives(t, y, dy);
	
	//then
	assertEquals(3d, dy[0]);
	assertEquals(11d, dy[1]);
    }

}
