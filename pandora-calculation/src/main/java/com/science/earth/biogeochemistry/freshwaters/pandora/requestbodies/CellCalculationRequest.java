package com.science.earth.biogeochemistry.freshwaters.pandora.requestbodies;

import java.time.LocalDateTime;

import com.science.earth.biogeochemistry.freshwaters.pandora.general.objects.Cell;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CellCalculationRequest {
    private Cell cell;
    private LocalDateTime t0;
    private int numberOfTimesteps;
}
