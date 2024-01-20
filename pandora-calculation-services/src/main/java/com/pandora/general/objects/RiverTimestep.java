package com.pandora.general.objects;

import java.util.List;
import java.util.Set;

/**
 * The {@code RiverTimestep} class extends {@link AbstractBaseObject} and represents a river timestep entity with a
 * unique identifier, name, and a list of independent cell timesteps associated with the river timestep.
 * <p>
 * This class includes a no-args constructor, allowing instances to be created without specifying initial values for the
 * properties.
 * </p>
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 * @see AbstractBaseObject
 */
public class RiverTimestep extends AbstractBaseObject {
    /** The list of independent cell timesteps associated with the river timestep. */
    private List<Set<CellTimestep>> independentCellTimesteps;
}
