package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.implementations;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.config.services.SpecieBeanService;
import com.science.earth.biogeochemistry.freshwaters.pandora.config.species.abstractions.Specie;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.PandoraTimestep;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces.TransportCalculationService;

@Service
public class TransportCalculationServiceImpl implements TransportCalculationService {
    
    @Autowired
    SpecieBeanService specieBeanService;

    @Override
    public double[] calculateTransport(double[] y, PandoraTimestep pandoraTimestep) {
	double[] transportDY = new double[y.length];
	Collection<Specie> species = specieBeanService.getAllSpecies().values();
	species.forEach(specie -> calculateTransport(specie, pandoraTimestep.getDischargeRate(), y, transportDY));
	return transportDY;
    }
    
    private void calculateTransport(Specie specie, double rate, double[] y, double[] transportDY) {
	int i = specie.getIndex();
	transportDY[i] = specie.calculateTransport(y[i], rate);
    }

}
