package com.pandora.config.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.pandora.config.reactions.abstractions.ReactionConfiguration;

import jakarta.annotation.PostConstruct;

/**
 * The {@code ReactionConfigurationBeanServiceImpl} service class provides methods for managing and retrieving
 * {@link ReactionConfiguration} instances within the application. It uses the Spring framework's
 * {@link ApplicationContext} for obtaining bean configurations and indexing {@link ReactionConfiguration} instances
 * based on their order of appearance in the configuration. The class implements the
 * {@link ReactionConfigurationBeanService} interface to expose methods for retrieving reaction configurations and
 * specific reactions based on their names, indices, and instances.
 * <p>
 * Developers using or extending the {@code ReactionConfigurationBeanServiceImpl} class should be aware of the
 * {@code applicationContext} field, which provides access to the Spring application context for retrieving beans and
 * components during runtime. Additionally, the {@code indexedReactionConfigurations} list is populated during the
 * initialization phase to provide a sequential order for accessing reaction configurations by index.
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 * @see ReactionConfigurationBeanService
 * @see ReactionConfiguration
 * @see ApplicationContext
 */
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
