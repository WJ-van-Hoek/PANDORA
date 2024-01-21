package com.pandora.config.species.services;

/**
 * The {@code SpecieStatusService} interface defines methods for checking and toggling the status of biogeochemical
 * species beans in the PANDORA model.
 * <p>
 * Implementing classes should provide concrete implementations for checking whether a species bean is currently enabled
 * and for toggling its status. The {@link #isBeanEnabled()} method should return {@code true} if the species bean is
 * enabled, and {@code false} otherwise. The {@link #toggleBeanStatus(boolean)} method should toggle the status of the
 * species bean based on the provided parameter, enabling it if currently disabled, or disabling it if currently
 * enabled.
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 */
public interface SpecieStatusService {
    /**
     * Checks whether the biogeochemical species bean is currently enabled.
     *
     * @return {@code true} if the species bean is enabled, {@code false} otherwise.
     */
    boolean isBeanEnabled();

    /**
     * Toggles the status of the biogeochemical species bean.
     * <p>
     * If the species bean is currently enabled, this method will disable it. If it is currently disabled, this method
     * will enable it.
     *
     * @param enabled The desired status for the species bean.
     * @return {@code true} if the status was successfully toggled, {@code false} otherwise.
     */
    boolean toggleBeanStatus(boolean enabled);
}
