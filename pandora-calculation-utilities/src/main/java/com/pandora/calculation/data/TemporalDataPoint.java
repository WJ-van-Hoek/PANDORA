package com.pandora.calculation.data;

import java.time.LocalDateTime;

import com.pandora.calculation.config.Temporal;

/**
 * Represents a data point with a timestamp.
 * Extends {@link DataPoint} and implements {@link Temporal}.
 */
public class TemporalDataPoint extends DataPoint implements Temporal {

    /**
     * The timestamp associated with this data point.
     */
    private final LocalDateTime timestamp;

    /**
     * Constructs a new TemporalDataPoint with the given value and timestamp.
     *
     * @param valueParam     The value of the data point.
     * @param timestampParam The timestamp of the data point.
     */
    public TemporalDataPoint(final Double valueParam, final LocalDateTime timestampParam) {
        super(valueParam);
        this.timestamp = timestampParam;
    }

    /**
     * Returns the timestamp associated with this data point.
     *
     * @return The timestamp of the data point.
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

}
