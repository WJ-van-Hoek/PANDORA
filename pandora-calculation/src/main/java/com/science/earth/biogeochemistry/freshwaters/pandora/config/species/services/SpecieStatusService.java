package com.science.earth.biogeochemistry.freshwaters.pandora.config.species.services;

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
