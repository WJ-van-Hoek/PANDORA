//package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.implementations;
//
//import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.Cell;
//import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.PandoraTimestep;
//import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.interfaces.*;
//import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.implementations.LocalDateTimeServiceImpl;
//import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces.CellTimestepService;
//import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces.LocalDateTimeService;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.core.env.Environment;
//import org.springframework.test.context.TestPropertySource;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.util.ArrayList;
//import java.util.List;
//
//@SpringBootTest
//@TestPropertySource (locations = "classpath:test1.properties", properties = {"pandora.timestep.unit=nanosecond","timestep.unit=nanosecond"})
//public class CellTimestepServiceImplIntergrationDefaultExceptionTest {
//    private static final Cell CELL = Cell.builder().id(1l).centerLatitude(52.08f).centerLongitude(5.67f).surfaceArea(1754.27f).nextCellId(1l).build();
//    private static final LocalDate LOCAL_DATE = LocalDate.of(2023, 8, 9);
//    private static final LocalTime LOCAL_TIME = LocalTime.of(0, 0);
//    private static final LocalDateTime T_0 = LocalDateTime.of(LOCAL_DATE, LOCAL_TIME);
//    private static List<LocalDateTime> LOCAL_DATE_TIME_LIST = new ArrayList<LocalDateTime>();
//    private static final PandoraTimestep PANDORA_TIMESTEP = PandoraTimestep.builder().discharge(10d).volume(1d).build();
//    private static final double[] Y_0 = {1d,1d};
//    private static final double[] TERRESTRIAL_SOURCES = {2d, 2d};
//    private static final double[] UPSTREAM_SOURCES = {3d, 3d};
//    private static final Double DISCHARGE = 1d;
//    private static final double VOLUME = 1d;
//    private static final double[] Y_END = {19.7403d, 21.5063d};
//
//    @Autowired
//    YMapService yMapService;
//
//    @Autowired
//    TerrestrialSourcesMapService terrestrialSourcesMapService;
//
//    @Autowired
//    UpstreamSourcesMapService upstreamSourcesMapService;
//
//    @Autowired
//    DischargesMapService dischargesMapService;
//
//    @Autowired
//    VolumesMapService volumesMapService;
//
//    @Autowired
//    CellTimestepService cellTimestepService;
//
//    @Autowired
//    LocalDateTimeService localDateTimeService;
//
//    @Autowired
//    private Environment environment;
//
//    @Autowired
//    LocalDateTimeServiceImpl localDateTimeServiceImpl;
//
//    @BeforeEach
//    void setUp() throws Exception
//    {
//        MockitoAnnotations.openMocks(this);
//        yMapService.cleanMap();
//        yMapService.saveAtCellAndTimestep(CELL, T_0, Y_0);
//        terrestrialSourcesMapService.cleanMap();
//        terrestrialSourcesMapService.saveAtCellAndTimestep(CELL, T_0, TERRESTRIAL_SOURCES);
//        upstreamSourcesMapService.cleanMap();
//        upstreamSourcesMapService.saveAtCellAndTimestep(CELL, PANDORA_TIMESTEP, T_0, UPSTREAM_SOURCES);
//        dischargesMapService.cleanMap();
//        dischargesMapService.saveAtCellAndTimestep(CELL, T_0, DISCHARGE);
//        volumesMapService.cleanMap();
//        volumesMapService.saveAtCellAndTimestep(CELL, T_0, VOLUME);
//
//    }
//
//    //LocalDateTimeTest Coverage::
//
//    @Test
//    void testCalculateTimeSeriesDefaultException() {
//        Assertions.assertThrows (IllegalArgumentException.class, ()-> this.cellTimestepService.calculateTimeSeries(CELL, T_0, 1));
//        Assertions.assertNotNull (this.cellTimestepService.calculateNextTimestep(CELL, T_0));
//    }
//
//
//
//}
