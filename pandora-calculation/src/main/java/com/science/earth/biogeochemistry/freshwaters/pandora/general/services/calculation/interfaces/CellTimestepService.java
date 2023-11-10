package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces;

import java.time.LocalDateTime;
import java.util.List;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.Cell;

public interface CellTimestepService {
    public List<double[]> calculateTimeSeries(Cell cell, LocalDateTime t0, int numberOfTimesteps);
    double[] calculateNextTimestep(Cell cell, LocalDateTime t0);
}
