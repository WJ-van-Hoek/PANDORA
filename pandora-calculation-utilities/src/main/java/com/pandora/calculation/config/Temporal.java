package com.pandora.calculation.config;

import java.time.LocalDateTime;

/**
 * Represents an object that has a timestamp.
 */
public interface Temporal {

    /**
     * Returns the timestamp associated with this object.
     *
     * @return The timestamp of the object.
     */
    LocalDateTime getTimestamp();
}
