package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.implementations;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.River;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces.CellTimestepService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces.RiverTimestepService;

@Service
public class RiverTimestepServiceImpl implements RiverTimestepService {

    @Autowired
    CellTimestepService cellTimestepService;

    @Override
    public void calculateNextTimestep(River river, LocalDateTime t0) {
	river.getIndependentCellSets().forEach(cellSet -> cellSet.parallelStream()
		.forEach(cell -> cellTimestepService.calculateNextTimestep(cell, t0)));
    }
}
