package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.implementations;

import java.time.LocalDateTime;

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
}
