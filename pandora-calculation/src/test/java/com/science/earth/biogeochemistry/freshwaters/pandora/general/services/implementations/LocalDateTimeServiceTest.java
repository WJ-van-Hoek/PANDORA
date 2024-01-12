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
 * JUnit test class for testing the functionality of the LocalDateTimeService implementation. This class includes tests
 * for various methods related to date and time calculations.
 */
@SpringBootTest
class LocalDateTimeServiceTest {

    /**
     * Autowired instance of LocalDateTimeService for testing.
     */
    @Autowired
    private LocalDateTimeServiceImpl localDateTimeService;
    /**
     * A constant representing the year (e.g., 2023).
     */
    private static final int YEAR = 2023;

    /**
     * A constant representing the month (e.g., 8 for August).
     */
    private static final int MONTH = 8;

    /**
     * A constant representing the day of the month (e.g., 9).
     */
    private static final int DAY = 9;

    /**
     * A constant representing the hour of the day in 24-hour format (e.g., 0 for midnight).
     */
    private static final int HOUR = 0;

    /**
     * A constant representing the minute of the hour (e.g., 0).
     */
    private static final int MINUTE = 0;

    /**
     * A constant representing the second of the hour (e.g., 0).
     */
    private static final int SECOND = 0;

    /**
     * A constant representing how much is added to the time unit (e.g., 1).
     */
    private static final int ADD = 1;

    /**
     * A constant representing how many days in a week (e.g., 7).
     */
    private static final int DAYS_IN_A_WEEK = 7;

    /**
     * An arbitrary constant representing how many timesteps should be calculated for the getDateTimeList tests.
     */
    private static final int DATETIME_LIST_LENGTH = 3;

    /**
     * A constant LocalDate for test purposes.
     */
    private static final LocalDate LOCAL_DATE = LocalDate.of(YEAR, MONTH, DAY);

    /**
     * A constant LocalTime for test purposes.
     */
    private static final LocalTime LOCAL_TIME = LocalTime.of(HOUR, MINUTE);

    /**
     * A constant LocalDateTime for test purposes.
     */
    private static final LocalDateTime T_0 = LocalDateTime.of(LOCAL_DATE, LOCAL_TIME);

    /**
     * A constant double representing T_END for test purposes.
     */
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
        assertEquals(result, LocalDateTime.of(YEAR, MONTH, DAY, HOUR, MINUTE, ADD));
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
        assertEquals(result, LocalDateTime.of(YEAR, MONTH, DAY, HOUR, ADD, SECOND));
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
        assertEquals(result, LocalDateTime.of(YEAR, MONTH, DAY, ADD, MINUTE, SECOND));
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
        assertEquals(result, LocalDateTime.of(YEAR, MONTH, DAY + ADD, HOUR, MINUTE, SECOND));
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
        assertEquals(result, LocalDateTime.of(YEAR, MONTH, DAY + DAYS_IN_A_WEEK, HOUR, MINUTE, SECOND));
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
        assertEquals(result, LocalDateTime.of(YEAR, MONTH + ADD, DAY, HOUR, MINUTE, SECOND));
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
        assertEquals(result, LocalDateTime.of(YEAR + ADD, MONTH, DAY, HOUR, MINUTE, SECOND));
    }

    /**
     * Test the generation of a list of LocalDateTimes with timestep unit set to 'day'.
     */
    @Test
    void testGetDateTimeListDay() {
        // given
        ReflectionTestUtils.setField(localDateTimeService, "timestepUnit", "day");

        // when
        List<LocalDateTime> result = localDateTimeService.getDateTimeList(T_0, DATETIME_LIST_LENGTH);

        // then
        assertNotNull(result);
        assertEquals(DATETIME_LIST_LENGTH, result.size());
        List<LocalDateTime> expected = Arrays.asList(LocalDateTime.of(YEAR, MONTH, DAY, HOUR, MINUTE),
                LocalDateTime.of(YEAR, MONTH, DAY + ADD, HOUR, MINUTE),
                LocalDateTime.of(YEAR, MONTH, DAY + ADD + ADD, HOUR, MINUTE));
        assertEquals(expected, result);
    }

    /**
     * Test the generation of a list of LocalDateTimes with timestep unit set to 'month'.
     */
    @Test
    void testGetDateTimeListMonth() {
        // given
        ReflectionTestUtils.setField(localDateTimeService, "timestepUnit", "month");

        // when
        List<LocalDateTime> result = localDateTimeService.getDateTimeList(T_0, DATETIME_LIST_LENGTH);

        // then
        assertNotNull(result);
        assertEquals(DATETIME_LIST_LENGTH, result.size());
        List<LocalDateTime> expected = Arrays.asList(LocalDateTime.of(YEAR, MONTH, DAY, HOUR, MINUTE),
                LocalDateTime.of(YEAR, MONTH + ADD, DAY, HOUR, MINUTE),
                LocalDateTime.of(YEAR, MONTH + ADD + ADD, DAY, HOUR, MINUTE));
        assertEquals(expected, result);
    }

    /**
     * Test the generation of a list of LocalDateTimes with timestep unit set to 'year'.
     */
    @Test
    void testGetDateTimeListYear() {
        // given
        ReflectionTestUtils.setField(localDateTimeService, "timestepUnit", "year");

        // when
        List<LocalDateTime> result = localDateTimeService.getDateTimeList(T_0, DATETIME_LIST_LENGTH);

        // then
        assertNotNull(result);
        assertEquals(DATETIME_LIST_LENGTH, result.size());
        List<LocalDateTime> expected = Arrays.asList(LocalDateTime.of(YEAR, MONTH, DAY, HOUR, MINUTE),
                LocalDateTime.of(YEAR + ADD, MONTH, DAY, HOUR, MINUTE),
                LocalDateTime.of(YEAR + ADD + ADD, MONTH, DAY, HOUR, MINUTE));
        assertEquals(expected, result);
    }

    /**
     * Test the generation of a list of LocalDateTimes with unsupported timestep unit 'second'. Expects an
     * IllegalArgumentException with an appropriate error message.
     */
    @Test
    void testGetDateTimeListSecond() {
        // given
        ReflectionTestUtils.setField(localDateTimeService, "timestepUnit", "second");

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            localDateTimeService.getDateTimeList(T_0, DATETIME_LIST_LENGTH);
        });

        // then
        assertNotNull(exception);
        assertEquals("Unsupported time unit: second", exception.getMessage());
    }
}
