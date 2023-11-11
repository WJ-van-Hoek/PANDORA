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

    @Autowired
    protected ConfigurableEnvironment environment;

    @Autowired
    private SpecieBeanService specieBeanService;

    private Map<Specie, Integer> producedSpecies = new HashMap<>();
    private Map<Specie, Integer> removedSpecies = new HashMap<>();

    @Override
    public Map<Specie, Integer> getProducedSpecies() {
	return producedSpecies;
    }

    @Override
    public Map<Specie, Integer> getRemovedSpecies() {
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

    protected Map<Specie, Integer> loadSpecieChangeMap(String propertyName, String prefix) {
	Integer changeValue = Integer.valueOf(environment.getProperty(propertyName));
	String specieName = propertyName.substring(prefix.length());
	Specie specie = specieBeanService
		.getSpecie(specieName.toLowerCase());
	Map<Specie, Integer> specieProduction = new HashMap<>();
	specieProduction.put(specie, changeValue);
	return specieProduction;
    }

    @Override
    public double[] calculate(double[] y) {
	double[] dy = new double[y.length];

	getProducedSpecies().keySet().forEach(specie -> calculate(y, dy, specie, getProducedSpecies().get(specie)));
	getRemovedSpecies().keySet().forEach(specie -> calculate(y, dy, specie, getRemovedSpecies().get(specie)));
	return dy;
    }

    private void calculate(double[] y, double[] dy, Specie specie, Integer changeValue) {
	int specieIndex = specieBeanService.getSpecieIndex(specie);
	dy[specieIndex] += y[specieIndex] * getRate(y) * changeValue;
    }

    protected abstract String getReactionProductionPrefix();

    protected abstract String getReactionRemovalPrefix();

    protected abstract double getRate(double[] y);
}
