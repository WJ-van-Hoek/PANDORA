package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.implementations;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.PandoraTimestep;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.PandoraTimestepImpl;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.CellTimestepBaseObject;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.interfaces.CellTimestepService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.interfaces.PandoraIntegratorService;

@Service
public class CellTimestepServiceImpl implements CellTimestepService {

    @Autowired
    PandoraIntegratorService pandoraIntegratorService;

    @Override
    public CellTimestepBaseObject calculateNextTimestep(CellTimestepBaseObject cellTimestep, LocalDateTime t0, LocalDateTime tEnd) {
	
	PandoraTimestep timestep = PandoraTimestepImpl.builder().build();
	
	double[] yEnd = pandoraIntegratorService.integrate(timestep);

	cellTimestep.setYEnd(Arrays.stream(yEnd).boxed().toList());
	return cellTimestep;
    }

}
