package com.science.earth.biogeochemistry.freshwaters.pandora.general.objects;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CellTimestep extends AbstractBaseObject {
    Cell cell;
    LocalDateTime t0;
    LocalDateTime tEnd;
    double[] y0;
    double[] yEnd;

    @Builder
    public CellTimestep(Cell cell, double[] y0, LocalDateTime t0, LocalDateTime tEnd) {
	this.cell = cell;
	this.y0 = y0;
    }

    public void setYEnd(double[] yEnd) {
	this.yEnd = yEnd;
    }
}
