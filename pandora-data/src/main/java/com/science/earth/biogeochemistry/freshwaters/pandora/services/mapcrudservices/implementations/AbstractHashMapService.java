package com.science.earth.biogeochemistry.freshwaters.pandora.services.mapcrudservices.implementations;

import java.time.LocalDateTime;
import java.util.Objects;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.CellBaseObject;

public abstract class AbstractHashMapService {
    
    protected int hashCellAndTime(CellBaseObject cell, LocalDateTime t) {
	return Objects.hash(cell, t);
    }
}
