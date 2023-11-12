package com.science.earth.biogeochemistry.freshwaters.pandora.config.species.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.config.species.DOC;

@PropertySource("classpath:species.properties")
@Service
public class DocBeanStatusService implements SpecieStatusService {

    @Value("${doc.enabled}")
    private boolean docEnabled;

    private final ApplicationContext applicationContext;
    
    public DocBeanStatusService(ApplicationContext applicationContext) {
	this.applicationContext = applicationContext;
    }

    @Override
    public boolean isBeanEnabled() {
	return docEnabled;
    }

    @Override
    public boolean toggleBeanStatus(boolean enable) {
        docEnabled = enable;

        if (enable) {
            if (!applicationContext.containsBean("DOC")) {
                ((ConfigurableApplicationContext) applicationContext).getBeanFactory().registerSingleton("DOC", new DOC());
            }
        } else {
            if (applicationContext.containsBean("DOC")) {
                ((ConfigurableApplicationContext) applicationContext).getBeanFactory().destroyBean("DOC");
            }
        }
        return enable;
//        "DOC bean is now " + (enable ? "enabled" : "disabled");

    }

}
