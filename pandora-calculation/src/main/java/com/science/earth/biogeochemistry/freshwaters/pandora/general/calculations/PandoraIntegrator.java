package com.science.earth.biogeochemistry.freshwaters.pandora.general.calculations;

import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;
import org.apache.commons.math3.ode.FirstOrderIntegrator;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.interfaces.PandoraScheme;

public class PandoraIntegrator {

    private FirstOrderIntegrator firstOrderIntegrator;
    private PandoraScheme pandoraScheme;

    public PandoraIntegrator(FirstOrderIntegrator firstOrderIntegrator, PandoraScheme pandoraScheme) {
	this.firstOrderIntegrator = firstOrderIntegrator;
	this.pandoraScheme = pandoraScheme;
    }

    public double integrate() {
	// FirstOrderDifferentialEquation System from the PandoraScheme
	FirstOrderDifferentialEquations ode = new PandoraDifferentialEquations(this.pandoraScheme);

	double t0 = pandoraScheme.getT0();
	double[] y0 = pandoraScheme.getY0();
	double tEnd = pandoraScheme.getTEnd();
	double[] y = new double[pandoraScheme.getY0().length];
	return firstOrderIntegrator.integrate(ode, t0, y0, tEnd, y);
    }
}