package com.science.earth.biogeochemistry.freshwaters.pandora.general.services.calculation.interfaces;

import com.science.earth.biogeochemistry.freshwaters.pandora.config.species.SpecieConfiguration;

public interface SpecieCalculationService {
    double calculateSpecieDy(SpecieConfiguration specie, double[] y);
}
