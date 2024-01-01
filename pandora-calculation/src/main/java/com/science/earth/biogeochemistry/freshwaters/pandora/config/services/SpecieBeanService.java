package com.science.earth.biogeochemistry.freshwaters.pandora.config.services;

import java.util.Map;

import com.science.earth.biogeochemistry.freshwaters.pandora.config.species.abstractions.Specie;

public interface SpecieBeanService {
    /**
     * Retrieves a map containing all species configurations. The map is keyed by species names, and the values are
     * corresponding {@link Specie} instances.
     *
     * @return A map of all species configurations.
     */
    Map<String, Specie> getAllSpecies();

    /**
     * Retrieves the {@link Specie} instance corresponding to the provided species name.
     *
     * @param name The name of the species.
     * @return The {@link Specie} instance for the specified species name.
     */
    Specie getSpecie(String name);

    /**
     * Retrieves the {@link Specie} instance at the specified index.
     *
     * @param i The index of the species.
     * @return The {@link Specie} instance at the specified index.
     */
    Specie getSpecie(int i);

    /**
     * Retrieves the index of the provided {@link Specie} instance within the list of species.
     *
     * @param specie The {@link Specie} instance for which to obtain the index.
     * @return The index of the specified {@link Specie} instance.
     */
    int getSpecieIndex(Specie specie);
}
