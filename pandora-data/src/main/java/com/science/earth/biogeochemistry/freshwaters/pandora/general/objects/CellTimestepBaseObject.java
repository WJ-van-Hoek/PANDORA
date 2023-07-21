package com.science.earth.biogeochemistry.freshwaters.pandora.general.objects;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
    
    @Builder
    public CellTimestepBaseObject(CellBaseObject cell,
	    List<Double> y0, 
	    List<Float> terrestrialSources, List<Float> upstreamSources, 
	    List<Float> transformations, Float netPrecipitation) {
	this.cell = cell;
	this.y0 = y0;
	this.terrestrialSources = terrestrialSources;
	this.upstreamSources = upstreamSources;
	this.transformations = transformations;
	this.netPrecipitation = netPrecipitation;
    }
    
    
    public void setYEnd(List<Double> yEnd) {
	this.yEnd = yEnd;
    }
}
