package com.science.earth.biogeochemistry.freshwaters.pandora.config.parameters.services;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.config.parameters.Parameters;

@Service
public class DateTimeServiceImpl implements DateTimeService {

    @Autowired
    Parameters parameters;

    @Override
    public List<LocalDateTime> getDateTimeList(LocalDateTime t0, int numberOfTimesteps) {
        switch (parameters.getTimestepUnit().toLowerCase()) {
            case "year":
                return generateDateTimes(t0, numberOfTimesteps, ChronoUnit.YEARS);
            case "month":
                return generateDateTimes(t0, numberOfTimesteps, ChronoUnit.MONTHS);
            case "day":
		return generateDateTimes(t0, numberOfTimesteps, ChronoUnit.DAYS);
	    default:
		throw new IllegalArgumentException("Unsupported time unit: " + parameters.getTimestepUnit());
        }
    }

    private List<LocalDateTime> generateDateTimes(LocalDateTime t0, int numberOfTimesteps, ChronoUnit chronoUnit) {
        return IntStream.range(0, numberOfTimesteps)
                .mapToObj(i -> t0.plus(i, chronoUnit))
                .collect(Collectors.toList());
    }

}
