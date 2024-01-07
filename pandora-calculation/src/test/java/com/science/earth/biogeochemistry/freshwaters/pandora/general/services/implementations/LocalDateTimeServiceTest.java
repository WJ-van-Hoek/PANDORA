package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.implementations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.implementations.LocalDateTimeServiceImpl;

/**
 * JUnit test class for testing the functionality of the LocalDateTimeService implementation.
 * This class includes tests for various methods related to date and time calculations.
 */
@SpringBootTest
class LocalDateTimeServiceTest {
    @Autowired
    LocalDateTimeServiceImpl localDateTimeService;

    // Constants for test data
    private static final LocalDate LOCAL_DATE = LocalDate.of(2023, 8, 9);

    private static final LocalTime LOCAL_TIME = LocalTime.of(0, 0);

    private static final LocalDateTime T_0 = LocalDateTime.of(LOCAL_DATE, LOCAL_TIME);

    private static final double T_END = 1d;

    /**
     * Test the calculation of T_END as LocalDateTime with timestep unit set to 'second'.
     */
    @Test
    void testCalculateTEndAsLocalDateTimeSecond() {
        // given
        ReflectionTestUtils.setField(localDateTimeService, "timestepUnit", "second");

        // when
        LocalDateTime result = localDateTimeService.calculateTEndAsLocalDateTime(T_0, T_END);

        // then
        assertNotNull(result);
        assertEquals(result, LocalDateTime.of(2023, 8, 9, 0, 0, 1));
    }

    /**
     * Test the calculation of T_END as LocalDateTime with timestep unit set to 'minute'.
     */
    @Test
    void testCalculateTEndAsLocalDateTimeMinute() {
        // given
        ReflectionTestUtils.setField(localDateTimeService, "timestepUnit", "minute");

        // when
        LocalDateTime result = localDateTimeService.calculateTEndAsLocalDateTime(T_0, T_END);

        // then
        assertNotNull(result);
        assertEquals(result, LocalDateTime.of(2023, 8, 9, 0, 1, 0));
    }

    /**
     * Test the calculation of T_END as LocalDateTime with timestep unit set to 'hour'.
     */
    @Test
    void testCalculateTEndAsLocalDateTimeHour() {
        // given
        ReflectionTestUtils.setField(localDateTimeService, "timestepUnit", "hour");

        // when
        LocalDateTime result = localDateTimeService.calculateTEndAsLocalDateTime(T_0, T_END);

        // then
        assertNotNull(result);
        assertEquals(result, LocalDateTime.of(2023, 8, 9, 1, 0, 0));
    }

    /**
     * Test the calculation of T_END as LocalDateTime with timestep unit set to 'day'.
     */
    @Test
    void testCalculateTEndAsLocalDateTimeDay() {
        // given
        ReflectionTestUtils.setField(localDateTimeService, "timestepUnit", "day");

        // when
        LocalDateTime result = localDateTimeService.calculateTEndAsLocalDateTime(T_0, T_END);

        // then
        assertNotNull(result);
        assertEquals(result, LocalDateTime.of(2023, 8, 10, 0, 0));
    }

    /**
     * Test the calculation of T_END as LocalDateTime with timestep unit set to 'week'.
     */
    @Test
    void testCalculateTEndAsLocalDateTimeWeek() {
        // given
        ReflectionTestUtils.setField(localDateTimeService, "timestepUnit", "week");

        // when
        LocalDateTime result = localDateTimeService.calculateTEndAsLocalDateTime(T_0, T_END);

        // then
        assertNotNull(result);
        assertEquals(result, LocalDateTime.of(2023, 8, 16, 0, 0, 0));
    }

    /**
     * Test the calculation of T_END as LocalDateTime with timestep unit set to 'month'.
     */
    @Test
    void testCalculateTEndAsLocalDateTimeMonth() {
        // given
        ReflectionTestUtils.setField(localDateTimeService, "timestepUnit", "month");

        // when
        LocalDateTime result = localDateTimeService.calculateTEndAsLocalDateTime(T_0, T_END);

        // then
        assertNotNull(result);
        assertEquals(result, LocalDateTime.of(2023, 9, 9, 0, 0, 0));
    }

    /**
     * Test the calculation of T_END as LocalDateTime with timestep unit set to 'year'.
     */
    @Test
    void testCalculateTEndAsLocalDateTimeYear() {
        // given
        ReflectionTestUtils.setField(localDateTimeService, "timestepUnit", "year");

        // when
        LocalDateTime result = localDateTimeService.calculateTEndAsLocalDateTime(T_0, T_END);

        // then
        assertNotNull(result);
        assertEquals(result, LocalDateTime.of(2024, 8, 9, 0, 0, 0));
    }

    /**
     * Test the generation of a list of LocalDateTimes with timestep unit set to 'day'.
     */
    @Test
    void testGetDateTimeListDay() {
        // given
        ReflectionTestUtils.setField(localDateTimeService, "timestepUnit", "day");
        int dateTimeListLength = 3;

        // when
        List<LocalDateTime> result = localDateTimeService.getDateTimeList(T_0, dateTimeListLength);

        // then
        assertNotNull(result);
        assertEquals(dateTimeListLength, result.size());
        List<LocalDateTime> expected = Arrays.asList(LocalDateTime.of(2023, 8, 9, 0, 0),
                LocalDateTime.of(2023, 8, 10, 0, 0), LocalDateTime.of(2023, 8, 11, 0, 0));
        assertEquals(expected, result);
    }

    /**
     * Test the generation of a list of LocalDateTimes with timestep unit set to 'month'.
     */
    @Test
    void testGetDateTimeListMonth() {
        // given
        ReflectionTestUtils.setField(localDateTimeService, "timestepUnit", "month");
        int dateTimeListLength = 3;

        // when
        List<LocalDateTime> result = localDateTimeService.getDateTimeList(T_0, dateTimeListLength);

        // then
        assertNotNull(result);
        assertEquals(dateTimeListLength, result.size());
        List<LocalDateTime> expected = Arrays.asList(LocalDateTime.of(2023, 8, 9, 0, 0),
                LocalDateTime.of(2023, 9, 9, 0, 0), LocalDateTime.of(2023, 10, 9, 0, 0));
        assertEquals(expected, result);
    }

    /**
     * Test the generation of a list of LocalDateTimes with timestep unit set to 'year'.
     */
    @Test
    void testGetDateTimeListYear() {
        // given
        ReflectionTestUtils.setField(localDateTimeService, "timestepUnit", "year");
        int dateTimeListLength = 3;

        // when
        List<LocalDateTime> result = localDateTimeService.getDateTimeList(T_0, dateTimeListLength);

        // then
        assertNotNull(result);
        assertEquals(dateTimeListLength, result.size());
        List<LocalDateTime> expected = Arrays.asList(LocalDateTime.of(2023, 8, 9, 0, 0),
                LocalDateTime.of(2024, 8, 9, 0, 0), LocalDateTime.of(2025, 8, 9, 0, 0));
        assertEquals(expected, result);
    }

    /**
     * Test the generation of a list of LocalDateTimes with unsupported timestep unit 'second'.
     * Expects an IllegalArgumentException with an appropriate error message.
     */
    @Test
    void testGetDateTimeListSecond() {
        // given
        ReflectionTestUtils.setField(localDateTimeService, "timestepUnit", "second");
        int dateTimeListLength = 3;

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            localDateTimeService.getDateTimeList(T_0, dateTimeListLength);
        });

        // then
        assertNotNull(exception);
        assertEquals("Unsupported time unit: second", exception.getMessage());
    }
}
