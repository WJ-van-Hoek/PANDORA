package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces;

import java.time.LocalDateTime;
import java.util.List;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.Cell;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.CellTimestep;

public interface CellTimestepService {
    public List<CellTimestep> calculateTimeSeries(Cell cell, LocalDateTime t0, int numberOfTimesteps);
    CellTimestep calculateNextTimestep(Cell cell, LocalDateTime t0);
}
