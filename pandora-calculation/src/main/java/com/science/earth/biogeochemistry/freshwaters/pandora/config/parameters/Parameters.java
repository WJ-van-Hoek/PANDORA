package com.science.earth.biogeochemistry.freshwaters.pandora.config.parameters;

import lombok.Getter;

@Getter
public class Parameters {
    private final int timestepLength;
    private final String timestepUnit;

    public Parameters(int timestepLength, String unit) {
        this.timestepLength = timestepLength;
        this.timestepUnit = unit;
    }
}
