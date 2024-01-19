package com.science.earth.biogeochemistry.freshwaters.pandora.config.species.services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

import com.science.earth.biogeochemistry.freshwaters.pandora.config.species.abstractions.AqueousSpecie;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@PropertySource("classpath:species.properties")
public abstract class AbstractBeanStatusService implements SpecieStatusService {
    /**
     * The Spring {@link ApplicationContext} used for managing and accessing application components and beans. It is
     * autowired to inject the application context into the {@code AbstractBeanStatusService} class.
     *
     * @see ApplicationContext
     * @see AbstractBeanStatusService
     */
    private final ApplicationContext applicationContext;

    /**
     * The name of the biogeochemical species bean managed by this service.
     */
    private final String beanName;

    /**
     * Constructs an {@code AbstractBeanStatusService} instance with the specified application context and bean name.
     *
     * @param applicationContextParam The Spring application context.
     * @param beanNameParam The name of the biogeochemical species bean.
     */
    protected AbstractBeanStatusService(final ApplicationContext applicationContextParam, final String beanNameParam) {
        this.applicationContext = applicationContextParam;
        this.beanName = beanNameParam;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isBeanEnabled() {
        log.info("{} bean is {}", beanName, (getBeanEnabledImpl() ? "enabled" : "disabled"));
        return getBeanEnabledImpl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toggleBeanStatus(final boolean enable) {
        if (enable) {
            if (!applicationContext.containsBean(beanName)) {
                ((ConfigurableApplicationContext) applicationContext).getBeanFactory().registerSingleton(beanName,
                        createBeanInstance());
            }
        } else {
            if (applicationContext.containsBean(beanName)) {
                ((ConfigurableApplicationContext) applicationContext).getBeanFactory().destroyBean(beanName);
            }
        }
        return setBeanEnabledImpl(enable);
    }

    /**
     * Retrieves the current status of the biogeochemical species bean.
     *
     * @return {@code true} if the species bean is enabled, {@code false} otherwise.
     */
    protected abstract boolean getBeanEnabledImpl();

    /**
     * Sets the status of the biogeochemical species bean.
     *
     * @param enabled The desired status for the species bean.
     * @return {@code true} if the status was successfully set, {@code false} otherwise.
     */
    protected abstract boolean setBeanEnabledImpl(boolean enabled);

    /**
     * Creates an instance of the {@link AqueousSpecie} bean. This method is used when registering the bean in the
     * application context.
     *
     * @return An instance of the biogeochemical species bean.
     */
    protected abstract AqueousSpecie createBeanInstance();
}
