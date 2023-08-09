package com.science.earth.biogeochemistry.freshwaters.pandora.services.mapcrudservices.implementations;

import java.time.LocalDateTime;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.CellBaseObject;

public interface YMapService extends MapService {
    double[] findAtCellAndTimestep(CellBaseObject cell, LocalDateTime t);
    void saveAtCellAndTimestep(CellBaseObject cell, LocalDateTime t, double[] y);
}
