package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.implementations;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.PandoraTimestep;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.PandoraTimestepImpl;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.CellTimestepBaseObject;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.interfaces.CellTimestepService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.interfaces.IntegratorService;

@Service
public class CellTimestepServiceImpl implements CellTimestepService {

    @Autowired
    IntegratorService integratorService;

    @Override
    public CellTimestepBaseObject calculateNextTimestep(CellTimestepBaseObject cellTimestep, LocalDateTime t0, LocalDateTime tEnd) {
	
	PandoraTimestep timestep = PandoraTimestepImpl.builder().build();
	double[] yEnd = integrator.integrate();
	
	
	return null;
    }

}
