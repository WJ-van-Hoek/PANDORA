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
    /**
     * The {@code docEnabled} field represents the status of the DOC bean, indicating whether
     * it is currently enabled or disabled. The initial value is set to {@code false}.
     */
    @Value("${doc.enabled:false}")
    private boolean docEnabled;

    /**
     * Constructs a new {@code DocBeanStatusService} with the specified {@link ApplicationContext}.
     *
     * @param applicationContext The application context used for managing beans.
     */
    public DocBeanStatusService(final ApplicationContext applicationContext) {
        super(applicationContext, "DOC");
    }

    /**
     * Sets the status of the DOC bean to the specified value.
     *
     * @param enabled The value indicating whether the DOC bean should be enabled.
     * @return The updated status of the DOC bean after setting its enabled state.
     */
    @Override
    protected final boolean setBeanEnabledImpl(final boolean enabled) {
        this.docEnabled = enabled;
        return this.docEnabled;
    }

    /**
     * Retrieves the current status of the DOC bean.
     *
     * @return {@code true} if the DOC bean is enabled, {@code false} otherwise.
     */
    @Override
    protected final boolean getBeanEnabledImpl() {
        return this.docEnabled;
    }

    /**
     * Creates a new instance of {@link DOC} as the bean associated with the DOC status service.
     *
     * @return A new instance of {@link DOC}.
     */
    @Override
    protected AqueousSpecie createBeanInstance() {
        return new DOC();
    }
}
