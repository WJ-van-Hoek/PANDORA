package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces;

import java.time.LocalDateTime;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.River;

public interface RiverTimestepService {
    void calculateNextTimestep(River river, LocalDateTime t0);
}
