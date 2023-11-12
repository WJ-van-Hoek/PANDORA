package com.science.earth.biogeochemistry.freshwaters.pandora.config.species.services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

import com.science.earth.biogeochemistry.freshwaters.pandora.config.species.abstractions.AqueousSpecie;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@PropertySource("classpath:species.properties")
public abstract class AbstractBeanStatusService implements SpecieStatusService {

    protected final ApplicationContext applicationContext;
    protected final String beanName;

    protected AbstractBeanStatusService(ApplicationContext applicationContext, String beanName) {
	this.applicationContext = applicationContext;
	this.beanName = beanName;
    }

    @Override
    public boolean isBeanEnabled() {
        log.info("{} bean is {}", beanName, (getBeanEnabledImpl() ? "enabled" : "disabled"));
        return getBeanEnabledImpl();
    }

    @Override
    public boolean toggleBeanStatus(boolean enable) {
        if (enable) {
            if (!applicationContext.containsBean(beanName)) {
                ((ConfigurableApplicationContext) applicationContext).getBeanFactory().registerSingleton(beanName, createBeanInstance());
            }
        } else {
            if (applicationContext.containsBean(beanName)) {
                ((ConfigurableApplicationContext) applicationContext).getBeanFactory().destroyBean(beanName);
            }
        }
        return setBeanEnabledImpl(enable);
    }
    
    protected abstract boolean getBeanEnabledImpl();
    
    protected abstract boolean setBeanEnabledImpl(boolean enabled);
    
    protected abstract AqueousSpecie createBeanInstance();
  
}
