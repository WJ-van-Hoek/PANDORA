package com.science.earth.biogeochemistry.freshwaters.pandora.config.species.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.config.species.DOC;
import com.science.earth.biogeochemistry.freshwaters.pandora.config.species.abstractions.AqueousSpecie;

@ConditionalOnProperty(name = "doc.enabled", havingValue = "true")
@Service
public class DocBeanStatusService extends AbstractBeanStatusService {

    @Value("${doc.enabled:false}")
    private boolean docEnabled;

    public DocBeanStatusService(ApplicationContext applicationContext) {
	super(applicationContext, "DOC");
    }

    protected boolean setBeanEnabledImpl(boolean enabled) {
	this.docEnabled = enabled;
	return this.docEnabled;
    }
    
    protected boolean getBeanEnabledImpl() {
	return this.docEnabled;
    }

    @Override
    protected AqueousSpecie createBeanInstance() {
	return new DOC();
    }

}
