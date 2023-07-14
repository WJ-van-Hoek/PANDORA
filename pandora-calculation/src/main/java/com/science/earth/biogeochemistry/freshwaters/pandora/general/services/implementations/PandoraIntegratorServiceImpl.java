package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.implementations;

import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;
import org.apache.commons.math3.ode.FirstOrderIntegrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.PandoraTimestep;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.interfaces.FirstOrderDifferentialEquationsService;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.interfaces.PandoraIntegratorService;

@Service
public class PandoraIntegratorServiceImpl implements PandoraIntegratorService {
  
    @Autowired
    private FirstOrderDifferentialEquationsService firstOrderDifferentialEquationsService;
    
    @Autowired
    private FirstOrderIntegrator firstOrderIntegrator;

    public double[] integrate(PandoraTimestep pandoraTimestep) {
	FirstOrderDifferentialEquations ode = firstOrderDifferentialEquationsService.getPandoraDifferentialEquations();
	
	double t0 = pandoraTimestep.getT0();
	double[] y0 = pandoraTimestep.getY0();
	double tEnd = pandoraTimestep.getTEnd();
	double[] y = new double[pandoraTimestep.getY0().length];
	firstOrderIntegrator.integrate(ode, t0, y0, tEnd, y);
	return y;
    }
}