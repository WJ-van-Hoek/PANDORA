package com.pandora.calculation.config;

import org.slf4j.Logger;

/**
 * Represents an logged object
 *
 * <p>
 * Implementing classes must provide a method to retrieve the log.
 *
 * @author Wim Joost van Hoek
 * @version 0.0.1
 * @since 0.0.1
 */
public interface Logged {
    /**
     * @return the logger of the object.
     */
    Logger getLog();
}
