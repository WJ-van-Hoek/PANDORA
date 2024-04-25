package com.pandora.calculation.repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.pandora.calculation.config.SpecieConfiguration;

@Repository
public final class SpecieConfigurationRepositoryImpl implements SpecieConfigurationRepository {

    /**
     * Map to store {@link SpecieConfiguration} indexed by its index {@link Integer}.
     */
    private Map<Integer, SpecieConfiguration> _dataMap = new HashMap<>();

    @Override
    public void saveSpecieConfiguration(final SpecieConfiguration specieConfiguration) {
        if (specieConfiguration.getIndex() == null) {
            specieConfiguration.setIndex(_dataMap.size());
        }
        int index = specieConfiguration.getIndex();
        if (_dataMap.containsKey(index)) {
            throw new IllegalArgumentException("Index already exists in SpecieConfigurationMemory: " + index);
        }
        String name = specieConfiguration.getName();
        _dataMap.forEach((k, v) -> {
            if (v.getName().equals(name)) {
                throw new IllegalArgumentException("Name already exists in SpecieConfigurationMemory: " + name);
            }
        });
        _dataMap.put(specieConfiguration.getIndex(), specieConfiguration);
    }

    /**
     * Saves a collection of specie configuration.
     *
     * @param specieConfigurations the specie configuration collection to add
     */
    @Override
    public void saveSpecieConfigurations(final Collection<SpecieConfiguration> specieConfigurations) {
        specieConfigurations.forEach(this::saveSpecieConfiguration);
    }

    @Override
    public SpecieConfiguration findSpecieConfiguration(final String name) {
        return _dataMap.values().stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public SpecieConfiguration findSpecieConfiguration(final int index) {
        return _dataMap.get(Integer.valueOf(index));
    }

    @Override
    public List<SpecieConfiguration> findAllSpecieConfigurations() {
        return new ArrayList<>(_dataMap.values());
    }

}
