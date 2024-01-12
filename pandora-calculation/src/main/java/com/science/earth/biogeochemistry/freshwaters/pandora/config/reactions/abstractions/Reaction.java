package com.science.earth.biogeochemistry.freshwaters.pandora.config.reactions.abstractions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.PropertySource;

import com.science.earth.biogeochemistry.freshwaters.pandora.config.services.SpecieBeanService;
import com.science.earth.biogeochemistry.freshwaters.pandora.config.species.abstractions.Specie;

import jakarta.annotation.PostConstruct;

public abstract class Reaction implements ReactionConfiguration {

    /**
     * The {@code environment} field in the {@link Reaction} class represents the Spring framework's
     * {@link ConfigurableEnvironment} that provides access to application properties. This field is autowired to inject
     * the application's environment configuration.
     * <p>
     * Developers using or extending the {@code Reaction} class should be aware that the {@code environment} field
     * allows access to properties and configuration settings, which can be useful for dynamically configuring reactions
     * based on external properties.
     *
     * @see ConfigurableEnvironment
     * @see Reaction
     */
    @Autowired
    private ConfigurableEnvironment environment;

    /**
     * The {@code specieBeanService} field in the {@link Reaction} class represents the service responsible for managing
     * and retrieving instances of {@link com.science.earth.biogeochemistry.freshwaters.pandora.config.species
     * .abstractions.Specie} beans. This field is autowired to inject the service into the {@code Reaction} class.
     * <p>
     * Developers using or extending the {@code Reaction} class should be aware that the {@code specieBeanService} field
     * provides functionality related to handling and retrieving instances of species within the biogeochemical context.
     * It allows access to methods for getting specific species and their properties.
     *
     * @see SpecieBeanService
     * @see Reaction
     * @see com.science.earth.biogeochemistry.freshwaters.pandora.config.species .abstractions.Specie
     */
    @Autowired
    private SpecieBeanService specieBeanService;

    /**
     * The {@code producedSpecies} field in the {@link Reaction} class represents a map that associates instances of
     * {@link com.science.earth.biogeochemistry .freshwaters.pandora.config.species.abstractions.Specie} with their
     * corresponding production values. This map is initialized as an empty {@link HashMap} and is used to store the
     * species produced by the reaction along with their respective production quantities.
     * <p>
     * Developers using or extending the {@code Reaction} class should be aware that the {@code producedSpecies} map is
     * populated during the initialization phase and is accessible for further analysis or modifications during the
     * simulation.
     *
     * @see HashMap
     * @see Reaction
     * @see com.science.earth.biogeochemistry.freshwaters.pandora.config.species .abstractions.Specie
     */
    private Map<Specie, Integer> producedSpecies = new HashMap<>();

    /**
     * The {@code removedSpecies} field in the {@link Reaction} class represents a map that associates instances of
     * {@link com.science.earth.biogeochemistry .freshwaters.pandora.config.species.abstractions.Specie} with their
     * corresponding removal values. This map is initialized as an empty {@link HashMap} and is used to store the
     * species removed by the reaction along with their respective removal quantities.
     * <p>
     * Developers using or extending the {@code Reaction} class should be aware that the {@code removedSpecies} map is
     * populated during the initialization phase and is accessible for further analysis or modifications during the
     * simulation.
     *
     * @see HashMap
     * @see Reaction
     * @see com.science.earth.biogeochemistry.freshwaters.pandora.config.species .abstractions.Specie
     */
    private Map<Specie, Integer> removedSpecies = new HashMap<>();

    /**
     * Initializes the reaction configuration during the post-construction phase. This method is annotated with
     * {@link jakarta.annotation.PostConstruct} to ensure it is executed after the bean has been constructed, allowing
     * for any necessary setup steps.
     * <p>
     * Developers extending the {@code Reaction} class can override this method to perform custom initialization tasks
     * specific to their reaction implementations. The method is invoked automatically after the bean is constructed,
     * providing an opportunity to set up initial conditions or configurations.
     *
     * @see jakarta.annotation.PostConstruct
     * @see Reaction
     */
    @PostConstruct
    public void initialize() {
        addProducedSpecies();
        addRemovedSpecies();
    }

    @Override
    public final Map<Specie, Integer> getProducedSpecies() {
        return producedSpecies;
    }

    @Override
    public final Map<Specie, Integer> getRemovedSpecies() {
        return removedSpecies;
    }

    @Override
    public final double[] calculate(final double[] y) {
        double[] dy = new double[y.length];

        getProducedSpecies().keySet().forEach(specie -> calculate(y, dy, specie, getProducedSpecies().get(specie)));
        getRemovedSpecies().keySet().forEach(specie -> calculate(y, dy, specie, getRemovedSpecies().get(specie)));
        return dy;
    }

    private void addRemovedSpecies() {
        getPropertyNamesWithReactionPrefix(getReactionRemovalPrefix()).forEach(
                propertyName -> removedSpecies.putAll(loadSpecieChangeMap(propertyName, getReactionRemovalPrefix())));
    }

    private void addProducedSpecies() {
        getPropertyNamesWithReactionPrefix(getReactionProductionPrefix()).forEach(propertyName -> producedSpecies
                .putAll(loadSpecieChangeMap(propertyName, getReactionProductionPrefix())));
    }

    private List<String> getPropertyNamesWithReactionPrefix(final String prefix) {
        List<String> propertyNames = new ArrayList<>();

        for (PropertySource<?> propertySource : environment.getPropertySources()) {
            if (propertySource instanceof EnumerablePropertySource) {
                for (String propertyName : ((EnumerablePropertySource<?>) propertySource).getPropertyNames()) {
                    if (propertyName.startsWith(prefix)) {
                        propertyNames.add(propertyName);
                    }
                }
            }
        }
        return propertyNames;
    }

    private Map<Specie, Integer> loadSpecieChangeMap(final String propertyName, final String prefix) {
        Integer changeValue = Integer.valueOf(environment.getProperty(propertyName));
        String specieName = propertyName.substring(prefix.length());
        Specie specie = specieBeanService.getSpecie(specieName.toLowerCase());
        Map<Specie, Integer> specieProduction = new HashMap<>();
        specieProduction.put(specie, changeValue);
        return specieProduction;
    }

    private void calculate(final double[] y, final double[] dy, final Specie specie, final Integer changeValue) {
        int specieIndex = specieBeanService.getSpecieIndex(specie);
        dy[specieIndex] += y[specieIndex] * getRate(y) * changeValue;
    }

    /**
     * Retrieves the prefix used to construct property names for species production values associated with this
     * reaction. Subclasses should implement this method to provide the specific prefix used in dynamically retrieving
     * configuration values related to the production of species during the reaction.
     *
     * @return A {@code String} representing the prefix for production property names.
     * @see Reaction
     */
    protected abstract String getReactionProductionPrefix();

    /**
     * Retrieves the prefix used to construct property names for species removal values associated with this reaction.
     * Subclasses should implement this method to provide the specific prefix used in dynamically retrieving
     * configuration values related to the removal of species during the reaction.
     *
     * @return A {@code String} representing the prefix for removal property names.
     * @see Reaction
     */
    protected abstract String getReactionRemovalPrefix();

    /**
     * Calculates and returns the rate of the reaction based on the current state of the system, represented by the
     * array {@code y} containing concentrations of different species. Subclasses should implement this method to define
     * the reaction kinetics specific to their reaction type.
     *
     * @param y The array representing the concentrations of different species in the system.
     * @return The rate of the reaction.
     * @see Reaction
     */
    protected abstract double getRate(double[] y);
}
