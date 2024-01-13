package com.science.earth.biogeochemistry.freshwaters.pandora.general.objects;

import java.util.List;
import java.util.Set;

public class RiverTimestep extends AbstractBaseObject {
    /** The list of independent cell timesteps associated with the river timestep. */
    private List<Set<CellTimestep>> independentCellTimesteps;
}
