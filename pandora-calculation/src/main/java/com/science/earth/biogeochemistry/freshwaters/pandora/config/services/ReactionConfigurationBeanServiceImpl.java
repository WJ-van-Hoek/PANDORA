package com.science.earth.biogeochemistry.freshwaters.pandora.config.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.config.reactions.abstractions.ReactionConfiguration;

import jakarta.annotation.PostConstruct;

@Service
public class ReactionConfigurationBeanServiceImpl implements ReactionConfigurationBeanService {

    /**
     * The {@code applicationContext} field in the {@link ReactionConfigurationBeanServiceImpl} class represents the
     * Spring framework's {@link ApplicationContext} used for managing and accessing application components and beans.
     * This field is autowired to inject the application context into the {@code ReactionConfigurationBeanServiceImpl}
     * class.
     * <p>
     * Developers using or extending the {@code ReactionConfigurationBeanServiceImpl} class should be aware that the
     * {@code applicationContext} field provides access to the Spring application context, allowing retrieval of beans
     * and components during runtime. It is particularly used in this service for obtaining instances of
     * {@link ReactionConfiguration} beans.
     *
     * @see ApplicationContext
     * @see ReactionConfigurationBeanServiceImpl
     * @see ReactionConfiguration
     */
    @Autowired
    private ApplicationContext applicationContext;

    /**
     * The {@code indexedReactionConfigurations} field in the {@link ReactionConfigurationBeanServiceImpl} class
     * represents a list that stores instances of {@link ReactionConfiguration}. This list is initialized as an empty
     * {@link ArrayList} and is used to maintain a collection of reaction configurations with index-based access.
     * <p>
     * Developers using or extending the {@code ReactionConfigurationBeanServiceImpl} class should be aware that the
     * {@code indexedReactionConfigurations} list is populated during the initialization phase and provides a sequential
     * order for accessing reaction configurations by index. It is particularly used in this service for efficient
     * retrieval and indexing of reaction configurations.
     *
     * @see ArrayList
     * @see ReactionConfigurationBeanServiceImpl
     * @see ReactionConfiguration
     */
    private List<ReactionConfiguration> indexedReactionConfigurations = new ArrayList<>();

    @Override
    public final Map<String, ReactionConfiguration> getAllReactions() {
        return applicationContext.getBeansOfType(ReactionConfiguration.class);
    }

    @Override
    public final ReactionConfiguration getReactionConfiguration(final String name) {
        return getAllReactions().get(name);
    }

    @Override
    public final ReactionConfiguration getReactionConfiguration(final int i) {
        return indexedReactionConfigurations.get(i);
    }

    /**
     * The {@code initialize} method in the {@link ReactionConfigurationBeanServiceImpl} class is annotated with
     * {@link jakarta.annotation.PostConstruct}, indicating that it should be executed after the bean has been
     * constructed. This method populates the {@code indexedReactionConfigurations} list with instances of
     * {@link ReactionConfiguration}. It retrieves all available reaction configurations using the
     * {@link #getAllReactions()} method and adds them to the list for efficient index-based access.
     * <p>
     * Developers using or extending the {@code ReactionConfigurationBeanServiceImpl} class should be aware that the
     * {@code initialize} method is automatically invoked after the bean is constructed, providing an opportunity to set
     * up initial conditions, populate collections, or perform any necessary setup steps specific to this service.
     *
     * @see jakarta.annotation.PostConstruct
     * @see ReactionConfigurationBeanServiceImpl
     * @see ReactionConfiguration
     */
    @PostConstruct
    public void initialize() {
        indexedReactionConfigurations.addAll(getAllReactions().values());
    }
}
