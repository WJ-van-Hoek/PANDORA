package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.implementations;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.PandoraTimestep;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.PandoraTimestepImpl;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.CellTimestepBaseObject;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.interfaces.CellTimestepService;

@Service
public class CellTimestepServiceImpl implements CellTimestepService {

    @Override
    public CellTimestepBaseObject calculateNextTimestep(CellTimestepBaseObject cellTimestep, LocalDateTime t0, LocalDateTime tEnd) {
	
	PandoraTimestep timestep = PandoraTimestepImpl.builder().build();

	
	return null;
    }

}
