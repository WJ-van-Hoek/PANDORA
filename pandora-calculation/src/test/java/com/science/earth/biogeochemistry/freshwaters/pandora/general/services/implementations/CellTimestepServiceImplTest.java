package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.implementations;

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

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.Cell;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.PandoraTimestep;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.interfaces.DischargesMapService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.interfaces.TerrestrialSourcesMapService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.interfaces.UpstreamSourcesMapService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.interfaces.VolumesMapService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.interfaces.YMapService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.implementations.CellMapCrudService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.implementations.CellTimestepServiceImpl;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces.LocalDateTimeService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces.PandoraIntegratorService;

class CellTimestepServiceImplTest {
    @Mock
    YMapService yMapService;
    
    @Mock
    TerrestrialSourcesMapService terrestrialSourcesMapService;
    
    @Mock
    UpstreamSourcesMapService upstreamSourcesMapService;
    
    @Mock
    DischargesMapService dischargesMapService;
    
    @Mock
    VolumesMapService volumesMapService;
    
    @Mock
    PandoraIntegratorService pandoraIntegratorService;
    
    @Mock
    CellMapCrudService cellMapCrudService;
    
    @Mock
    LocalDateTimeService localDateTimeService;
    
    @InjectMocks
    private CellTimestepServiceImpl cellTimestepService;
    
    private Cell cell;
    
    private Cell nextCell;
        
    private static final LocalDateTime T_0 = LocalDateTime.of(2023, 7, 21, 0, 0);
    
    private static final LocalDateTime T_END = T_0.plusYears(1);

    private static final LocalDateTime T_END_MONTH = T_0.plusMonths(1);
    
    private static final double[] Y_0 = {0d,0d};
    
    private static double[] Y_END = {3d,3d};
    
    private static final double[] TERRESTRIAL_SOURCES = {1d,1d};
    
    private static final double[] UPSTREAM_SOURCES = {1d,1d};
    
    private static final Double DISCHARGE = 1d;

    private static final Double VOLUME = 1d;
    
    @BeforeEach
    void setUp() throws Exception {
	MockitoAnnotations.openMocks(this);
	cell = Cell.builder().id(0L).build();
	nextCell = Cell.builder().id(1L).build();
    }

    @Test
    void testCalculateNextTimestep() {
	//given
//        System.setProperty("pandora.timestep.unit", "month");
//        System.setProperty("pandora.timestep.length", "1L");
	when(yMapService.findAtCellAndTimestep(cell, T_0)).thenReturn(Y_0);
	when(terrestrialSourcesMapService.findAtCellAndTimestep(cell, T_0)).thenReturn(TERRESTRIAL_SOURCES);
	when(upstreamSourcesMapService.findAtCellAndTimestep(cell, T_0)).thenReturn(UPSTREAM_SOURCES);
	when(dischargesMapService.findAtCellAndTimestep(cell, T_0)).thenReturn(DISCHARGE);
	when(volumesMapService.findAtCellAndTimestep(cell, T_0)).thenReturn(VOLUME);
	when(pandoraIntegratorService.integrate(any(PandoraTimestep.class))).thenReturn(Y_END);
	when(localDateTimeService.calculateTEndAsLocalDateTime(any(LocalDateTime.class), anyDouble())).thenReturn(T_END);
	when(cellMapCrudService.findById(anyLong())).thenReturn(nextCell);

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

	ArgumentCaptor<Cell> cellCaptor = ArgumentCaptor.forClass(Cell.class);
	ArgumentCaptor<LocalDateTime> dateTimeTEndCaptor = ArgumentCaptor.forClass(LocalDateTime.class);
	ArgumentCaptor<double[]> yEndCaptor = ArgumentCaptor.forClass(double[].class);
	verify(yMapService).saveAtCellAndTimestep(cellCaptor.capture(), dateTimeTEndCaptor.capture(), yEndCaptor.capture());
	Assertions.assertEquals(cell, cellCaptor.getValue());
	Assertions.assertEquals(T_END, dateTimeTEndCaptor.getValue());
	double[] capturedArray =  yEndCaptor.getValue();
	Assertions.assertEquals(Y_END, capturedArray);
    }
   
    private PandoraTimestep pandoraTimestepBuilder() {
	return PandoraTimestep.builder().y0(Y_0).t0(0d).tEnd(1d).discharge(DISCHARGE).volume(VOLUME).dimension(Y_0.length)
	.terrestrialSources(TERRESTRIAL_SOURCES).upstreamSources(UPSTREAM_SOURCES).build();
    }

}
