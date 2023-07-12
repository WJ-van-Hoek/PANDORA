package com.science.earth.biogeochemistry.freshwaters.pandora.general.objects;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CellTimestepBaseObject extends AbstractBaseObject {
    CellBaseObject cell;
    List<Double> y0;
    LocalDateTime t0;
    LocalDateTime tEnd;
    List<Float> terrestrialSources;
    List<Float> upstreamSources;
    List<Float> transformations;
    Float netPrecipitation;
}
