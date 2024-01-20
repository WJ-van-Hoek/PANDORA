package com.pandora.controllers.responsebodies.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.general.utils.json.mappers.MapToJsonMapper;
import com.general.utils.object.mappers.ObjectToMapMapper;
import com.pandora.config.species.abstractions.Specie;
import com.pandora.controllers.responsebodies.SpeciesResponse;

@Service
public class SpeciesResponseServiceImpl implements SpeciesResponseService {

    @Override
    public final SpeciesResponse postprocess(final Map<String, Specie> speciesMap) {
        List<String> speciesList = new ArrayList<>();

        for (Map.Entry<String, Specie> entry : speciesMap.entrySet()) {
            Map<String, Object> specieMap = ObjectToMapMapper.convertObjectToMap(entry.getValue(), true);
            speciesList.add(MapToJsonMapper.convertMapToJson(specieMap));
        }
        return new SpeciesResponse(speciesList);
    }
}
