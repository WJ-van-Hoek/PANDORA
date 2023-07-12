package com.science.earth.biogeochemistry.freshwaters.pandora.general;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class RiverBaseObject extends AbstractBaseObject {
    Set<CellBaseObject> cells;
}
