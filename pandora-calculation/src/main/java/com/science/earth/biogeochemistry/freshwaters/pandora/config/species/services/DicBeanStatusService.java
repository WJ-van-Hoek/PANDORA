package com.science.earth.biogeochemistry.freshwaters.pandora.config.species.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.config.species.DIC;
import com.science.earth.biogeochemistry.freshwaters.pandora.config.species.abstractions.AqueousSpecie;

@ConditionalOnProperty(name = "dic.enabled", havingValue = "true")
@Service
public class DicBeanStatusService extends AbstractBeanStatusService {
    /**
     * The {@code dicEnabled} field represents the status of the DIC bean, indicating whether
     * it is currently enabled or disabled. The initial value is set to {@code false}.
     */
    @Value("${dic.enabled:false}")
    private boolean dicEnabled;

    /**
     * Constructs a new {@code DicBeanStatusService} with the specified {@link ApplicationContext}.
     *
     * @param applicationContext The application context used for managing beans.
     */
    public DicBeanStatusService(final ApplicationContext applicationContext) {
        super(applicationContext, "DIC");
    }

    /**
     * Sets the status of the DIC bean to the specified value.
     *
     * @param enabled The value indicating whether the DIC bean should be enabled.
     * @return The updated status of the DIC bean after setting its enabled state.
     */
    @Override
    protected final boolean setBeanEnabledImpl(final boolean enabled) {
        this.dicEnabled = enabled;
        return this.dicEnabled;
    }

    /**
     * Retrieves the current status of the DIC bean.
     *
     * @return {@code true} if the DIC bean is enabled, {@code false} otherwise.
     */
    @Override
    protected final boolean getBeanEnabledImpl() {
        return this.dicEnabled;
    }

    /**
     * Creates a new instance of {@link DIC} as the bean associated with the DIC status service.
     *
     * @return A new instance of {@link DIC}.
     */
    @Override
    protected AqueousSpecie createBeanInstance() {
        return new DIC();
    }
}
