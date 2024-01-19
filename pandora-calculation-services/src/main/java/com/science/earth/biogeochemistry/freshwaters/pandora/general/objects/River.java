package com.science.earth.biogeochemistry.freshwaters.pandora.general.objects;

import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class River extends AbstractBaseObject {
    /** The list of independent cell sets associated with the river. */
    private List<Set<Cell>> independentCellSets;
}
