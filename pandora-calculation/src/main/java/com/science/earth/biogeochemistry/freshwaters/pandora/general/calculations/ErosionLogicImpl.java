package com.science.earth.biogeochemistry.freshwaters.pandora.general.calculations;

import org.springframework.stereotype.Component;

@Component
public class ErosionLogicImpl implements ErosionLogic {
    public double calculateSedimentTransportCoefficient(double alpha, double r) {
	return alpha * Math.pow((r*2),-1.5);
    }
}
