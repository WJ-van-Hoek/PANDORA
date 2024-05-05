package com.pandora.calculation.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataPoint {
    /**
     * The logger used for logging messages and events related to the configuration.
     */
    private static final Logger LOG = LoggerFactory.getLogger(DataPoint.class);

    /**
     * The value of the datapoint.
     */
    private double _value;

    /**
     * Constructs a new DataPoint with the specified value.
     *
     * @param value the value of the data point
     */
    public DataPoint(final double value) {
        _value = value;
    }

    /**
     * Retrieves the value of the datapoint.
     *
     * @return The value of the datapoint
     */
    public double getValue() {
        getLog().debug("Retrieved datapoint with value {}", _value);
        return _value;
    }

    /**
     * Retrieves the logger associated with the datapoint. The logger is used for logging messages and events related to
     * the variable.
     *
     * @return The logger for the variable.
     */
    public Logger getLog() {
        return LOG;
    }
}
