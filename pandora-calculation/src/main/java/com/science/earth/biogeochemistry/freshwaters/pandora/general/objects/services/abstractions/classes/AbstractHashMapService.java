package com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.classes;

import java.time.LocalDateTime;
import java.util.Objects;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.Cell;

public abstract class AbstractHashMapService {
    
    protected int hashCellAndTime(Cell cell, LocalDateTime t) {
	return Objects.hash(cell, t);
    }
}
