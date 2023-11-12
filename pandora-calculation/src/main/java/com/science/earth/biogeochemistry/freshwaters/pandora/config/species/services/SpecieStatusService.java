package com.science.earth.biogeochemistry.freshwaters.pandora.config.species.services;

public interface SpecieStatusService {
    boolean isBeanEnabled();
    boolean toggleBeanStatus(boolean enabled);
}
