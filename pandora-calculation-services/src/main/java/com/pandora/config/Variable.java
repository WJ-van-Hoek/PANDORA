package com.pandora.config;

import org.slf4j.Logger;

import lombok.extern.slf4j.Slf4j;

/**
 * The {@code Variable} class is an abstract implementation of the {@code VariableConfiguration} interface, providing
 * basic functionality for a variable within the PANDORA model.
 * <p>
 * This class includes methods for retrieving and setting the index, and accessing the logger associated with the
 * variable for logging messages and events.
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 */
@Slf4j
public abstract class Variable implements VariableConfiguration {
    /**
     * Indicates whether the variable is indexed or not.
     */
    private boolean indexed = false;

    /**
     * The index of the variable within the overall configuration. It represents the position of the variable in the
     * model.
     */
    private int index;

    /**
     * Retrieves the index associated with the variable configuration. The index represents the position of the variable
     * within the overall configuration.
     *
     * @return The index of the variable configuration.
     */
    public int getIndex() {
        return this.index;
    }

    /**
     * Sets the index for the variable. This method can only be called once, preventing multiple index assignments for
     * the same variable.
     *
     * @param indexParam The index to be set for the variable.
     * @throws Exception If an attempt is made to set the index multiple times for the same variable.
     */
    public void setIndex(final int indexParam) throws Exception {
        if (!indexed) {
            this.index = indexParam;
            indexed = true;
        } else {
            throw new Exception("This variable is already indexed");
        }
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
