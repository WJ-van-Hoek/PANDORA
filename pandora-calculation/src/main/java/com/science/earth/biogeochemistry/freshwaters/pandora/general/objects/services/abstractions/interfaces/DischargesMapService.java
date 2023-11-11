package com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.interfaces;

import java.time.LocalDateTime;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.Cell;

public interface DischargesMapService extends MapService {
    Double findAtCellAndTimestep(Cell cell, LocalDateTime t);
    void saveAtCellAndTimestep(Cell cell, LocalDateTime t, Double discharge);
}
