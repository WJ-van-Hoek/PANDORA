package com.pandora.calculation.services;

import com.pandora.calculation.bootstrap.BootstrapParams;

/**
 * The {@code BootstrapService} interface defines the contract for services that require initialization parameters
 * during bootstrap.
 * <p>
 * Implementing classes must provide an implementation for the {@link #initializeServiceParams(BootstrapParams)} method,
 * which initializes the service with the provided bootstrap parameters.
 *
 * @version 0.0.1
 * @since 0.0.1
 * @author Wim Joost van Hoek
 * @see BootstrapParams
 */
public interface BootstrapService {
    /**
     * Initializes the service with the provided bootstrap parameters.
     *
     * @param params the bootstrap parameters used to initialize the service
     */
    void initializeServiceParams(BootstrapParams params);
}
