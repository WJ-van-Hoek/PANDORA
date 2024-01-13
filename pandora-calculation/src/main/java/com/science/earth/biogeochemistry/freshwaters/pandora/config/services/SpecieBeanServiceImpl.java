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

    /**
     * The {@code applicationContext} field represents the Spring framework's {@link ApplicationContext}, which is
     * autowired to inject the application's context. It is used for obtaining bean configurations, specifically for
     * {@link Specie} instances.
     *
     * @see ApplicationContext
     * @see SpecieBeanServiceImpl
     */
    @Autowired
    private ApplicationContext applicationContext;

    /**
     * The {@code indexedSpecies} field is a list that holds {@link Specie} instances. These instances are indexed based
     * on their order of appearance in the configuration. The index is used for efficient retrieval and indexing
     * operations.
     *
     * @see SpecieBeanServiceImpl
     * @see Specie
     */
    private List<Specie> indexedSpecies = new ArrayList<>();

    /**
     * Retrieves a map containing all species configurations. The map is keyed by species names, and the values are
     * corresponding {@link Specie} instances. The keys are stored in lowercase for case-insensitive retrieval.
     *
     * @return A map of all species configurations.
     */
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

    /**
     * Retrieves the {@link Specie} instance corresponding to the provided species name. The retrieval is
     * case-insensitive.
     *
     * @param name The name of the species.
     * @return The {@link Specie} instance for the specified species name.
     */
    @Override
    public Specie getSpecie(final String name) {
        return getAllSpecies().get(name.toLowerCase());
    }

    /**
     * Retrieves the {@link Specie} instance at the specified index within the list of indexed species.
     *
     * @param i The index of the species.
     * @return The {@link Specie} instance at the specified index.
     */
    @Override
    public Specie getSpecie(final int i) {
        return indexedSpecies.get(i);
    }

    /**
     * Retrieves the index of the provided {@link Specie} instance within the list of indexed species.
     *
     * @param specie The {@link Specie} instance for which to obtain the index.
     * @return The index of the specified {@link Specie} instance.
     */
    @Override
    public int getSpecieIndex(final Specie specie) {
        return indexedSpecies.indexOf(specie);
    }

    @PostConstruct
    private void postConstruct() {
        getAllSpecies().values().forEach(this::addToIndexedSpecies);
    }

    private void addToIndexedSpecies(final Specie specie) {
        try {
            specie.setIndex(indexedSpecies.size());
            indexedSpecies.add(specie);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
