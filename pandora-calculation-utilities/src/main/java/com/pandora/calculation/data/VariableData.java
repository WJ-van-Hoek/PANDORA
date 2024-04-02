package com.pandora.calculation.data;

import org.slf4j.Logger;

import com.pandora.calculation.config.Amountable;
import com.pandora.calculation.config.Logged;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * The VariableData class represents data associated with a variable. It provides methods to retrieve the instantaneous
 * amount. Additionally, the logger is accessable via the VariableData.
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 */
@Slf4j
@AllArgsConstructor
public abstract class VariableData implements Amountable, Logged {
    /**
     * The instantaneous amount of the variable.
     */
    private double amount;

    /**
     * Retrieves the instantaneous amount of the variable.
     *
     * @return The amount of the variable
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Retrieves the logger associated with the variable. The logger is used for logging messages and events related to
     * the variable.
     *
     * @return The logger for the variable.
     */
    public Logger getLog() {
        return log;
    }
}
