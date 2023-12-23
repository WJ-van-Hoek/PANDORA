package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.implementations;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.implementations.LocalDateTimeServiceImpl;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces.LocalDateTimeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@SpringBootTest
@TestPropertySource(locations = {"classpath:application.properties","classpath:integrator.properties",
"classpath:parameters.properties","classpath:physics-constraints.properties",
"classpath:species.properties"})
public class LocalDateTimeServiceTest {

    @Autowired
    LocalDateTimeServiceImpl localDateTimeService;
    @Autowired
    private Environment environment ;

    private static final LocalDate LOCAL_DATE = LocalDate.of(2023, 8, 9);
    private static final LocalTime LOCAL_TIME = LocalTime.of(0, 0);
    private static final LocalDateTime T_0 = LocalDateTime.of(LOCAL_DATE, LOCAL_TIME);
    private static final double TEND = 1d;
    @BeforeEach
    void setup() throws Exception {
    }

    @Test
    void testCalculateTEndAsLocalDateTime() {

        ReflectionTestUtils.setField(localDateTimeService,"timestepUnit","day");
        Assertions.assertNotNull(localDateTimeService.calculateTEndAsLocalDateTime(T_0,TEND));


    }
}
