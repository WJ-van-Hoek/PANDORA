package com.science.earth.biogeochemistry.freshwaters.pandora.general.objects;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CellTimestepBaseObject extends AbstractBaseObject {
    CellBaseObject cell;
    List<Double> y0;
    List<Double> yEnd;
    List<Float> terrestrialSources;
    List<Float> upstreamSources;
    List<Float> transformations;
    Float netPrecipitation;
    
    public void setYEnd(List<Double> yEnd) {
	this.yEnd = yEnd;
    }
}
