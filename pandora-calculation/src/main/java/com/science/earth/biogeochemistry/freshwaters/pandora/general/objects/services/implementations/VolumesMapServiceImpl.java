package com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.implementations;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.Cell;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.classes.AbstractHashMapService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.interfaces.VolumesMapService;

@Service
public class VolumesMapServiceImpl extends AbstractHashMapService implements VolumesMapService {
    
    protected Map<Integer, Double> map = new HashMap<>();
    
    @Override
    public void cleanMap() {
	map = new HashMap<>();
    }
    
    @Override
    public Double findAtCellAndTimestep(Cell cell, LocalDateTime t) {
	return map.get(hashCellAndTime(cell, t));
    }

    @Override
    public void saveAtCellAndTimestep(Cell cell, LocalDateTime t, Double volume) {
	map.put(hashCellAndTime(cell, t), volume);
    }
}
