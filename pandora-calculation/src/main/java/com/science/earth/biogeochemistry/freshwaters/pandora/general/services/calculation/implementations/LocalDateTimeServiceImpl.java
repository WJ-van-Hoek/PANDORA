package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.implementations;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces.LocalDateTimeService;

@Service
public class LocalDateTimeServiceImpl implements LocalDateTimeService {
    /**
     * The unit of the timestep, retrieved from configuration.
     */
    @Value("${pandora.timestep.unit}")
    private String timestepUnit;

    /**
     * The length of the timestep, retrieved from configuration.
     */
    @Value("${pandora.timestep.length}")
    private Long timestepLength;

    /**
     * Calculates the ending {@code LocalDateTime} based on the starting time {@code t0} and the specified end time
     * {@code tEnd}.
     *
     * @param t0 The starting time.
     * @param tEnd The ending time relative to the starting time.
     * @return The calculated ending {@code LocalDateTime}.
     */
    public LocalDateTime calculateTEndAsLocalDateTime(final LocalDateTime t0, final double tEnd) {
        final LocalDateTime localDateTimeEnd;
        switch (timestepUnit.toLowerCase()) {
        case "year":
            localDateTimeEnd = t0.plusYears(timestepLength);
            break;
        case "month":
            localDateTimeEnd = t0.plusMonths(timestepLength);
            break;
        case "week":
            localDateTimeEnd = t0.plusWeeks(timestepLength);
            break;
        case "day":
            localDateTimeEnd = t0.plusDays(timestepLength);
            break;
        case "hour":
            localDateTimeEnd = t0.plusHours(timestepLength);
            break;
        case "minute":
            localDateTimeEnd = t0.plusMinutes(timestepLength);
            break;
        case "second":
            localDateTimeEnd = t0.plusSeconds(timestepLength);
            break;
        default:
            localDateTimeEnd = t0.plusYears(timestepLength);
            break;
        }
        return localDateTimeEnd;
    }

    /**
     * Generates a list of {@code LocalDateTime} instances based on the starting time {@code t0} and the specified
     * number of timesteps.
     *
     * @param t0 The starting time.
     * @param numberOfTimesteps The number of timesteps to generate.
     * @return A list of generated {@code LocalDateTime} instances.
     * @throws IllegalArgumentException if the configured timestep unit is unsupported.
     */
    @Override
    public List<LocalDateTime> getDateTimeList(final LocalDateTime t0, final int numberOfTimesteps) {
        switch (timestepUnit.toLowerCase()) {
        case "year":
            return generateDateTimes(t0, numberOfTimesteps, ChronoUnit.YEARS);
        case "month":
            return generateDateTimes(t0, numberOfTimesteps, ChronoUnit.MONTHS);
        case "day":
            return generateDateTimes(t0, numberOfTimesteps, ChronoUnit.DAYS);
        default:
            throw new IllegalArgumentException("Unsupported time unit: " + timestepUnit.toLowerCase());
        }
    }

    private List<LocalDateTime> generateDateTimes(final LocalDateTime t0, final int numberOfTimesteps,
            final ChronoUnit chronoUnit) {
        return IntStream.range(0, numberOfTimesteps).mapToObj(i -> t0.plus(i, chronoUnit)).collect(Collectors.toList());
    }
}
