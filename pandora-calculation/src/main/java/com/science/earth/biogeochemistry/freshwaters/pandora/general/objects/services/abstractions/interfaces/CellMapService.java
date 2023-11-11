package com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.interfaces;

import java.time.LocalDateTime;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.Cell;

public interface CellMapService extends MapService {
    void saveAtCellAndTimestep(Cell cell, LocalDateTime t, double[] data);
}
