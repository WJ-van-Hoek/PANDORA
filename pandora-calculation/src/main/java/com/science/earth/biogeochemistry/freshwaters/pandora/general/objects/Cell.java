package com.science.earth.biogeochemistry.freshwaters.pandora.general.objects;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Cell extends AbstractBaseObject {
    Float centerLatitude;
    Float centerLongitude;
    Float surfaceArea;
    Long nextCellId;

    @Builder
    public Cell(Long id, String name, Float centerLatitude, Float centerLongitude, Float surfaceArea, Long nextCellId) {
	super(id, name);
	this.centerLatitude = centerLatitude;
	this.centerLongitude = centerLongitude;
	this.surfaceArea = surfaceArea;
	this.nextCellId = nextCellId;
    }
}
