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
    @Value("${pandora.timestep.unit}")
    private String timestepUnit;
    
    @Value("${pandora.timestep.length}")
    private Long timestepLength;
    
    public LocalDateTime calculateTEndAsLocalDateTime(LocalDateTime t0, double tEnd) {
	LocalDateTime localDateTimeEnd;
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
    
    @Override
    public List<LocalDateTime> getDateTimeList(LocalDateTime t0, int numberOfTimesteps) {
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
    
    private List<LocalDateTime> generateDateTimes(LocalDateTime t0, int numberOfTimesteps, ChronoUnit chronoUnit) {
        return IntStream.range(0, numberOfTimesteps)
                .mapToObj(i -> t0.plus(i, chronoUnit))
                .collect(Collectors.toList());
    }
}
