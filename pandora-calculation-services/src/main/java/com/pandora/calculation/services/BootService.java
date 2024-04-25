package com.pandora.calculation.services;

import com.pandora.calculation.bootstrap.BootContent;

/**
 * The {@code BootstrapService} interface defines the contract for services that require initialization parameters
 * during bootstrap.
 * <p>
 * Implementing classes must provide an implementation for the {@link #bootstrapCalculation(BootContent)}
 * method, which initializes the service with the provided bootstrap parameters.
 *
 * @see BootContent
 *
 * @author Wim Joost van Hoek
 * @version 0.0.1
 * @since 0.0.1
 */
public interface BootService {
    /**
     * Initializes the service with the provided bootstrap parameters.
     *
     * @param params the bootstrap parameters used to initialize the service
     */
    void boot(BootContent params);
}
