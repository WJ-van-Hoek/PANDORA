package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces;

import java.time.LocalDateTime;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.CellBaseObject;

public interface CellTimestepService {
    void calculateNextTimestep(CellBaseObject cell, LocalDateTime t0);
}
