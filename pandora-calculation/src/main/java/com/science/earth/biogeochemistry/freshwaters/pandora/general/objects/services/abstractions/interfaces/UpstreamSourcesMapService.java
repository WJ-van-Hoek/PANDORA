package com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.interfaces;

import java.time.LocalDateTime;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.Cell;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.PandoraTimestep;

public interface UpstreamSourcesMapService extends MapService {
    double[] findAtCellAndTimestep(Cell cell, LocalDateTime t);
    void saveAtCellAndTimestep(Cell cell, LocalDateTime t, double[] data);
    void saveAtCellAndTimestep(Cell cell, PandoraTimestep pandoraTimestep, LocalDateTime tEnd, double[] yEnd);
}
