package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces;

import java.time.LocalDateTime;
import java.util.List;

public interface LocalDateTimeService {
    LocalDateTime calculateTEndAsLocalDateTime(LocalDateTime t0, double tEnd);
    List<LocalDateTime> getDateTimeList(LocalDateTime t0, int numberOfTimesteps);
}
