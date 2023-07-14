package com.science.earth.biogeochemistry.freshwaters.pandora.services.mapcrudservices.implementations;

import java.time.LocalDateTime;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.CellBaseObject;

public interface TerrestrialSourcesMapService {
    double[] findAtTimestep(CellBaseObject cell, LocalDateTime t);
}
