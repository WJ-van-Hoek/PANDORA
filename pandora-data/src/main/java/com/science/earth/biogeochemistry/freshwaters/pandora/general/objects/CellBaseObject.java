package com.science.earth.biogeochemistry.freshwaters.pandora.general.objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class CellBaseObject extends AbstractBaseObject {
    Float latitude;
    Float longitude;
}
