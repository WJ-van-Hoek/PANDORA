package com.science.earth.biogeochemistry.freshwaters.pandora.config.parameters.services;

import java.time.LocalDateTime;
import java.util.List;

public interface DateTimeService {
    public List<LocalDateTime> getDateTimeList(LocalDateTime t0, int numberOfTimesteps);
}
