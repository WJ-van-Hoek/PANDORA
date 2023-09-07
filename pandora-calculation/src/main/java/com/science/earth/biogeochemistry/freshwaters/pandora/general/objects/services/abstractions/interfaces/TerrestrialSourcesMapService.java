package com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.interfaces;

import java.time.LocalDateTime;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.Cell;

public interface TerrestrialSourcesMapService extends MapService {
    double[] findAtCellAndTimestep(Cell cell, LocalDateTime t);
    void saveAtCellAndTimestep(Cell cell, LocalDateTime tEnd, double[] yEnd);
}
