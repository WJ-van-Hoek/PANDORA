package com.science.earth.biogeochemistry.freshwaters.pandora.requestbodies;

import java.time.LocalDateTime;
import java.util.List;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.Cell;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CellCalculationRequest {
    private Cell cell;
    double[] y0;
    List<double[]> upstreamSources;
    List<double[]> terrestrialSources;
    List<Double> discharges;
    List<Double> volumes;
    private LocalDateTime t0;
    private int numberOfTimesteps;
}
