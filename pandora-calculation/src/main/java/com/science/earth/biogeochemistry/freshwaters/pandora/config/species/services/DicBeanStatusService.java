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

    @Value("${dic.enabled:false}")
    private boolean dicEnabled;

    public DicBeanStatusService(ApplicationContext applicationContext) {
	super(applicationContext, "DIC");
    }

    protected boolean setBeanEnabledImpl(boolean enabled) {
	this.dicEnabled = enabled;
	return this.dicEnabled;
    }
    
    protected boolean getBeanEnabledImpl() {
	return this.dicEnabled;
    }

    @Override
    protected AqueousSpecie createBeanInstance() {
	return new DIC();
    }

}
