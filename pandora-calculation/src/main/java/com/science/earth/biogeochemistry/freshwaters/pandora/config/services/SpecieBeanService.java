package com.science.earth.biogeochemistry.freshwaters.pandora.config.services;

import java.util.Map;

import com.science.earth.biogeochemistry.freshwaters.pandora.config.species.abstractions.Specie;

public interface SpecieBeanService {
    public Map<String, Specie> getAllSpecies();
    public Specie getSpecie(String name);
    public Specie getSpecie(int i);
    int getSpecieIndex(Specie specie);
}
