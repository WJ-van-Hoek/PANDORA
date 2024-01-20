package com.pandora.config.species.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.pandora.config.species.DIC;
import com.pandora.config.species.abstractions.AqueousSpecie;

/**
 * The {@code DicBeanStatusService} class is a service responsible for managing the status of the Dissolved Inorganic
 * Carbon (DIC) bean in the PANDORA model. It extends the {@link AbstractBeanStatusService} class and is conditionally
 * enabled using the {@link ConditionalOnProperty} annotation with the "dic.enabled" property.
 * <p>
 * This service maintains the status of the DIC bean, indicating whether it is currently enabled or disabled. It
 * provides methods to set and retrieve the status of the DIC bean and creates a new instance of the {@link DIC} bean
 * when requested.
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 */
@ConditionalOnProperty(name = "dic.enabled", havingValue = "true")
@Service
public class DicBeanStatusService extends AbstractBeanStatusService {
    /**
     * The {@code dicEnabled} field represents the status of the DIC bean, indicating whether it is currently enabled or
     * disabled. The initial value is set to {@code false}.
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
