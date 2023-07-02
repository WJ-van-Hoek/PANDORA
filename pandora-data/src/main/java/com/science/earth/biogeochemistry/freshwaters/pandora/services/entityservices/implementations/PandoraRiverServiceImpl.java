package com.science.earth.biogeochemistry.freshwaters.pandora.services.entityservices.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.commands.interfaces.RiverCommand;
import com.science.earth.biogeochemistry.freshwaters.pandora.services.entityservices.interfaces.PandoraRiverService;

@Service
public class PandoraRiverServiceImpl implements PandoraRiverService {
    
    protected List<RiverCommand> rivers = new ArrayList<>();
 
    @Override
    public List<RiverCommand> getAllRivers() {
	return rivers;
    }

    @Override
    public RiverCommand getRiverByIndex(int index) {
	return rivers.get(index);
    }
}
