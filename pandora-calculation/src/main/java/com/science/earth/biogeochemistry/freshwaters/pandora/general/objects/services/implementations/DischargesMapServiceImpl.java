package com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.implementations;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.Cell;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.classes.AbstractHashMapService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.interfaces.DischargesMapService;

@Service
public class DischargesMapServiceImpl extends AbstractHashMapService implements DischargesMapService {
    
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
    public void saveAtCellAndTimestep(Cell cell, LocalDateTime t, Double discharge) {
	map.put(hashCellAndTime(cell, t), discharge);
    }
}
