package com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.implementations;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.Cell;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.classes.AbstractHashMapService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.interfaces.TerrestrialSourcesMapService;

@Service
public class TerrestrialSourcesMapServiceImpl extends AbstractHashMapService implements TerrestrialSourcesMapService {
    
    protected Map<Integer, double[]> map = new HashMap<>();
    
    @Override
    public void cleanMap() {
	map = new HashMap<>();
    }
    
    @Override
    public double[] findAtCellAndTimestep(Cell cell, LocalDateTime t) {
	return map.get(hashCellAndTime(cell, t));
    }

    @Override
    public void saveAtCellAndTimestep(Cell cell, LocalDateTime tEnd, double[] yEnd) {
	map.put(hashCellAndTime(cell, tEnd), yEnd);
    }
}
