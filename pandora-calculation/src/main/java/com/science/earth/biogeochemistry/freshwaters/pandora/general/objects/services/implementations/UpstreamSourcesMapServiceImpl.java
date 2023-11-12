package com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.implementations;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.Cell;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.PandoraTimestep;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.classes.AbstractHashMapService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.services.abstractions.interfaces.UpstreamSourcesMapService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces.TransportCalculationService;

@Service
public class UpstreamSourcesMapServiceImpl extends AbstractHashMapService implements UpstreamSourcesMapService {
    
    @Autowired
    TransportCalculationService transportCalculationService;
    
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
    public void saveAtCellAndTimestep(Cell cell, LocalDateTime t, double[] upstreamSources) {
	map.put(hashCellAndTime(cell, t), upstreamSources);
    }

    @Override
    public void saveAtCellAndTimestep(Cell cell, PandoraTimestep pandoraTimestep, LocalDateTime tEnd, double[] yEnd) {
	double[] upstreamSources = transportCalculationService.calculateTransport(yEnd, pandoraTimestep);
	map.put(hashCellAndTime(cell, tEnd), upstreamSources);
    }
}
