package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.config.services.SpecieConfigurationBeanService;
import com.science.earth.biogeochemistry.freshwaters.pandora.config.species.SpecieConfiguration;
import com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces.SpecieCalculationService;

@Service
public class SpecieCalculationServiceImpl implements SpecieCalculationService {
    
    @Autowired
    SpecieConfigurationBeanService specieConfigurationBeanService;

    @Override
    public double calculateSpecieDy(SpecieConfiguration specie, double[] y) {
	return 0;
    }

}
