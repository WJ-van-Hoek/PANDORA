package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.implementations;

import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.PandoraDifferentialEquations;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.PandoraTimestep;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces.TransportCalculationService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces.FirstOrderDifferentialEquationsService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces.ReactionCalculationService;

@Service
public class FirstOrderDifferentialEquationsServiceImpl implements FirstOrderDifferentialEquationsService {
    
    @Autowired
    TransportCalculationService dischargeCalculationService;
    
    @Autowired
    ReactionCalculationService reactionCalculationService;

    @Override
    public FirstOrderDifferentialEquations getPandoraDifferentialEquations(PandoraTimestep pandoraTimestep) {
	return new PandoraDifferentialEquations(pandoraTimestep, dischargeCalculationService, reactionCalculationService);
    }

}
