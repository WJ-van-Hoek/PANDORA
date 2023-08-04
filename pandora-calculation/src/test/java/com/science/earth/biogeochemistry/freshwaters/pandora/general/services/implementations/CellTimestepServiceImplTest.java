package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.implementations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
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

import com.science.earth.biogeochemistry.freshwaters.pandora.general.PandoraTimestep;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.PandoraTimestepImpl;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.CellBaseObject;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.interfaces.LocalDateTimeService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.interfaces.PandoraIntegratorService;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.mapcrudservices.implementations.TerrestrialSourcesMapService;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.mapcrudservices.implementations.UpstreamSourcesMapService;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.mapcrudservices.implementations.YMapService;

class CellTimestepServiceImplTest {
    @Mock
    YMapService yMapService;
    
    @Mock
    TerrestrialSourcesMapService terrestrialSourcesMapService;
    
    @Mock
    UpstreamSourcesMapService upstreamSourcesMapService;
    
    @Mock
    PandoraIntegratorService pandoraIntegratorService;
    
    @Mock
    LocalDateTimeService localDateTimeService;
    
    @InjectMocks
    private CellTimestepServiceImpl cellTimestepService;
    
    private CellBaseObject cell;
        
    private static final LocalDateTime T_0 = LocalDateTime.of(2023, 7, 21, 0, 0);
    
    private static final LocalDateTime T_END = T_0.plusYears(1);
    
    private static final double[] Y_0 = {0d,0d};
    
    private static double[] Y_END = {3d,3d};
    
    private static final double[] TERRESTRIAL_SOURCES = {1d,1d};
    
    private static final double[] UPSTREAM_SOURCES = {1d,1d};

    @BeforeEach
    void setUp() throws Exception {
	MockitoAnnotations.openMocks(this);
	cell = CellBaseObject.builder().build();
    }

    @Test
    void testCalculateNextTimestep() {
	//given
	when(yMapService.findAtCellAndTimestep(cell, T_0)).thenReturn(Y_0);
	when(terrestrialSourcesMapService.findAtTimestep(cell, T_0)).thenReturn(TERRESTRIAL_SOURCES);
	when(upstreamSourcesMapService.findAtTimestep(cell, T_0)).thenReturn(UPSTREAM_SOURCES);
	when(pandoraIntegratorService.integrate(any(PandoraTimestep.class))).thenReturn(Y_END);
	when(localDateTimeService.calculateTEndAsLocalDateTime(any(LocalDateTime.class), anyDouble())).thenReturn(T_END);
	
	//when
	cellTimestepService.calculateNextTimestep(cell, T_0);
	
	// then
	ArgumentCaptor<PandoraTimestep> pandoraTimestepCaptor = ArgumentCaptor.forClass(PandoraTimestep.class);
	verify(pandoraIntegratorService).integrate(pandoraTimestepCaptor.capture());
	Assertions.assertEquals(pandoraTimestepBuilder(), pandoraTimestepCaptor.getValue());
	
	ArgumentCaptor<LocalDateTime> t0Captor = ArgumentCaptor.forClass(LocalDateTime.class);
	ArgumentCaptor<Double> tEndCaptor = ArgumentCaptor.forClass(Double.class);
	verify(localDateTimeService).calculateTEndAsLocalDateTime(t0Captor.capture(), tEndCaptor.capture());
	Assertions.assertEquals(T_0, t0Captor.getValue());
	Assertions.assertEquals(1d, tEndCaptor.getValue());
	
	ArgumentCaptor<CellBaseObject> cellCaptor = ArgumentCaptor.forClass(CellBaseObject.class);
	ArgumentCaptor<LocalDateTime> dateTimeTEndCaptor = ArgumentCaptor.forClass(LocalDateTime.class);
	ArgumentCaptor<double[]> yEndCaptor = ArgumentCaptor.forClass(double[].class);
	verify(yMapService).saveAtCellAndTimestep(cellCaptor.capture(), dateTimeTEndCaptor.capture(), yEndCaptor.capture());
	Assertions.assertEquals(cell, cellCaptor.getValue());
	Assertions.assertEquals(T_END, dateTimeTEndCaptor.getValue());
	double[] capturedArray =  yEndCaptor.getValue();
	Assertions.assertEquals(Y_END, capturedArray);
    }
    
    private PandoraTimestep pandoraTimestepBuilder() {
	return PandoraTimestepImpl.builder().y0(Y_0).t0(0d).tEnd(1d).dimension(Y_0.length)
	.terrestrialSources(TERRESTRIAL_SOURCES).upstreamSources(UPSTREAM_SOURCES).build();
    }

}