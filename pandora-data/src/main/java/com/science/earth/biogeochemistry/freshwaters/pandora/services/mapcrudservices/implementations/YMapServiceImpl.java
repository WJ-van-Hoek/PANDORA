package com.science.earth.biogeochemistry.freshwaters.pandora.services.mapcrudservices.implementations;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.CellBaseObject;

@Service
public class YMapServiceImpl implements YMapService {

    @Override
    public double[] findAtCellAndTimestep(CellBaseObject cell, LocalDateTime t){

	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void saveAtCellAndTimestep(CellBaseObject cell, LocalDateTime tEnd, double[] yEnd) {
	
	// TODO Auto-generated method stub
	
    }

}
