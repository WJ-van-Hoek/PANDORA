package com.science.earth.biogeochemistry.freshwaters.pandora.general.calculations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.interfaces.PandoraRiverService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.interfaces.River;

@Service
public class PandoraRiverServiceImpl implements PandoraRiverService {
    
    protected List<River> rivers = new ArrayList<>();
 
    @Override
    public List<River> getAllRivers() {
	return rivers;
    }

    @Override
    public River getRiverByIndex(int index) {
	return rivers.get(index);
    }
}
