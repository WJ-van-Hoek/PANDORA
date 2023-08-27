package com.science.earth.biogeochemistry.freshwaters.pandora.config.reactions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.PropertySource;

import com.science.earth.biogeochemistry.freshwaters.pandora.config.services.SpecieConfigurationBeanService;
import com.science.earth.biogeochemistry.freshwaters.pandora.config.species.SpecieConfiguration;

import jakarta.annotation.PostConstruct;

public abstract class Reaction implements ReactionConfiguration {

    @Autowired
    protected ConfigurableEnvironment environment;

    @Autowired
    private SpecieConfigurationBeanService specieConfigurationBeanService;

    private Map<SpecieConfiguration, Integer> producedSpecies = new HashMap<>();
    private Map<SpecieConfiguration, Integer> removedSpecies = new HashMap<>();

    @Override
    public Map<SpecieConfiguration, Integer> getProducedSpecies() {
	return producedSpecies;
    }

    @Override
    public Map<SpecieConfiguration, Integer> getRemovedSpecies() {
	return removedSpecies;
    }

    @PostConstruct
    public void initialize() {
	addProducedSpecies();
	addRemovedSpecies();
    }

    private void addRemovedSpecies() {
	getPropertyNamesWithReactionPrefix(getReactionRemovalPrefix()).forEach(
		propertyName -> removedSpecies.putAll(loadSpecieChangeMap(propertyName, getReactionRemovalPrefix())));
    }

    private void addProducedSpecies() {
	getPropertyNamesWithReactionPrefix(getReactionProductionPrefix()).forEach(propertyName -> producedSpecies
		.putAll(loadSpecieChangeMap(propertyName, getReactionProductionPrefix())));
    }

    protected List<String> getPropertyNamesWithReactionPrefix(String prefix) {
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

    protected Map<SpecieConfiguration, Integer> loadSpecieChangeMap(String propertyName, String prefix) {
	Integer changeValue = Integer.valueOf(environment.getProperty(propertyName));
	String specieName = propertyName.substring(prefix.length());
	SpecieConfiguration specieConfiguration = specieConfigurationBeanService
		.getSpecieConfiguration(specieName.toLowerCase());
	Map<SpecieConfiguration, Integer> specieProduction = new HashMap<>();
	specieProduction.put(specieConfiguration, changeValue);
	return specieProduction;
    }

    @Override
    public double[] calculate(double[] y) {
	double[] dy = new double[y.length];

	getProducedSpecies().keySet().forEach(specie -> calculate(y, dy, specie, getProducedSpecies().get(specie)));
	getRemovedSpecies().keySet().forEach(specie -> calculate(y, dy, specie, getRemovedSpecies().get(specie)));
	return dy;
    }

    private void calculate(double[] y, double[] dy, SpecieConfiguration specie, Integer changeValue) {
	int specieIndex = specieConfigurationBeanService.getSpecieConfigurationIndex(specie);
	dy[specieIndex] += y[specieIndex] * getRate(y) * changeValue;
    }

    protected abstract String getReactionProductionPrefix();

    protected abstract String getReactionRemovalPrefix();

    protected abstract double getRate(double[] y);
}
