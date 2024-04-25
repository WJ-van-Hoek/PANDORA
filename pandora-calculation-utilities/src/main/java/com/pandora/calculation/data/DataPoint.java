package com.pandora.calculation.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataPoint implements Valuable {
    /**
     * The logger used for logging messages and events related to the configuration.
     */
    private static final Logger LOG = LoggerFactory.getLogger(DataPoint.class);

    /**
     * The value of the datapoint.
     */
    private double value;

    /**
     * Constructs a new DataPoint with the specified value.
     *
     * @param valueParam the value of the data point
     */
    public DataPoint(final double valueParam) {
        this.value = valueParam;
    }

    /**
     * Retrieves the value of the datapoint.
     *
     * @see Valuable
     *
     * @return The value of the datapoint
     */
    @Override
    public double getValue() {
        getLog().debug("Retrieved datapoint with value {}", value);
        return value;
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
