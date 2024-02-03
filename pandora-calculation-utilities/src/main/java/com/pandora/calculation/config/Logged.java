package com.pandora.calculation.config;

import org.slf4j.Logger;

/**
 * Represents an logged object
 *
 * <p>
 * Implementing classes must provide a method to retrieve the log.
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 */
public interface Logged {
    /**
     * @return the logger of the object.
     */
    Logger getLog();
}
