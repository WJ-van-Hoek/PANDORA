package com.pandora.calculation.objects;

import org.slf4j.Logger;

import com.pandora.calculation.config.Amountable;
import com.pandora.calculation.config.Configuration;
import com.pandora.calculation.config.Configured;
import com.pandora.calculation.config.Logged;
import com.pandora.calculation.data.VariableData;
import com.pandora.calculation.logic.VariableLogic;

import lombok.Getter;

/**
 * The Variable class serves as a base abstraction for entities with a configuration, variable data, and logic. It
 * provides a foundation for implementing specific types of variables with customized configuration, data handling and
 * behaviour.
 *
 * @param <C> the type of VariableConfiguration associated with this variable
 * @param <D> the type of VariableData associated with this variable
 * @param <L> the type of VariableLogic associated with this variable
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 */
@Getter
public abstract class Variable<C extends Configuration, D extends VariableData, L extends VariableLogic>
        implements Amountable, Configured<C>, Logged {
    /**
     * The configuration associated with this variable.
     */
    private final C configuration;

    /**
     * The data associated with this variable.
     */
    private final D data;

    /**
     * The logic associated with this variable.
     */
    private final L logic;

    /**
     * Constructs a new Variable with the given data and logic.
     *
     * @param variableConfigurationParam the configuration associated with this variable.
     * @param variableDataParam the data associated with this variable.
     * @param variableLogicParam the logic associated with this variable.
     */
    public Variable(final C variableConfigurationParam, final D variableDataParam, final L variableLogicParam) {
        this.configuration = variableConfigurationParam;
        this.data = variableDataParam;
        this.logic = variableLogicParam;
    }

    @Override
    public final double getAmount() {
        return data.getAmount();
    }

    @Override
    public final Logger getLog() {
        return configuration.getLog();
    }
}
