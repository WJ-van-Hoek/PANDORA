package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces;

import java.time.LocalDateTime;

public interface LocalDateTimeService {
    LocalDateTime calculateTEndAsLocalDateTime(LocalDateTime t0, double tEnd);
}
