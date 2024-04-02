package com.pandora.calculation.objects;

import com.pandora.calculation.config.SpecieConfiguration;
import com.pandora.calculation.data.VariableData;
import com.pandora.calculation.logic.VariableLogic;

/**
 * The Specie class represents a generic type of variable associated with a specific species. It extends the Variable
 * class and is parameterized by the type of SpecieConfiguration and VariableLogic.
 *
 * @param <C> the type of SpecieConfiguration associated with this specie
 * @param <L> the type of VariableLogic associated with this specie
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 */
public class Specie<C extends SpecieConfiguration, L extends VariableLogic> extends Variable<C, VariableData, L> {

    /**
     * Constructs a new Specie with the specified specie configuration, variable data, and variable logic.
     *
     * @param specieConfigurationParam the configuration associated with this specie
     * @param variableDataParam the data associated with this specie
     * @param variableLogicParam the logic associated with this specie
     */
    public Specie(final C specieConfigurationParam, final VariableData variableDataParam, final L variableLogicParam) {
        super(specieConfigurationParam, variableDataParam, variableLogicParam);
    }
}
