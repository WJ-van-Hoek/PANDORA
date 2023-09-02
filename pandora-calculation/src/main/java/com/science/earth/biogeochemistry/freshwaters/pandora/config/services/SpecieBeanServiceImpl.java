package com.science.earth.biogeochemistry.freshwaters.pandora.config.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.science.earth.biogeochemistry.freshwaters.pandora.config.species.abstractions.Specie;

import jakarta.annotation.PostConstruct;

@Service
public class SpecieBeanServiceImpl implements SpecieBeanService {
    
    @Autowired
    private ApplicationContext applicationContext;
    
    private List<Specie> indexedSpecies = new ArrayList<>();
    
    @Override
    public Map<String, Specie> getAllSpecies() {
	Map<String, Specie> original = applicationContext.getBeansOfType(Specie.class);
	Map<String, Specie> lowercasedKeys = new HashMap<>();
	original.forEach((key, value) -> {
            String lowercaseKey = key.toLowerCase();
            lowercasedKeys.put(lowercaseKey, value);
        });
	return lowercasedKeys;
    }
    
    @Override
    public Specie getSpecie(String name) {
	return getAllSpecies().get(name.toLowerCase());
    }

    @Override
    public Specie getSpecie(int i) {
	return indexedSpecies.get(i);
    }
    
    @Override
    public int getSpecieIndex(Specie specie) {
	return indexedSpecies.indexOf(specie);
    }
    
    @PostConstruct
    void postConstruct() {
	getAllSpecies().values().forEach(this::addToIndexedSpecies);
    }
    
    private void addToIndexedSpecies(Specie specie) {
	try {
	    specie.setIndex(indexedSpecies.size());
	    indexedSpecies.add(specie);
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}