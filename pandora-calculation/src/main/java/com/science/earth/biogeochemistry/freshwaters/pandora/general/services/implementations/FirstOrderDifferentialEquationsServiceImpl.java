package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.implementations;

import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;
import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.PandoraDifferentialEquations;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.PandoraTimestep;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.interfaces.FirstOrderDifferentialEquationsService;

@Service
public class FirstOrderDifferentialEquationsServiceImpl implements FirstOrderDifferentialEquationsService {

    @Override
    public FirstOrderDifferentialEquations getPandoraDifferentialEquations(PandoraTimestep pandoraTimestep) {
	return new PandoraDifferentialEquations(pandoraTimestep);
    }

}
