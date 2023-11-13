package com.science.earth.biogeochemistry.freshwaters.pandora.controllers.responsebodies.services;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.science.earth.biogeochemistry.freshwaters.pandora.config.species.abstractions.Specie;
import com.science.earth.biogeochemistry.freshwaters.pandora.controllers.responsebodies.SpeciesResponse;

@Service
public class SpeciesResponseServiceImpl implements SpeciesResponseService {

    @Override
    public SpeciesResponse postprocess(Map<String, Specie> speciesMap) {
	List<String> speciesList = new ArrayList<>();
	for (Map.Entry<String, Specie> entry : speciesMap.entrySet()) {
	    speciesList.add(ObjectInspector.inspect(entry.getValue()));
	}
	return new SpeciesResponse(speciesList);
    }
}

class ObjectInspector {
    public static String inspect(Specie obj) {
	Class<?> clazz = obj.getClass();
	Class<?> originalClazz = clazz.getSuperclass();
	Field[] fields = originalClazz.getDeclaredFields();

	Map<String, Object> inspectionResult = new TreeMap<>((key1, key2) -> {
	    if ("name".equals(key1)) {
		return -1;
	    } else if ("name".equals(key2)) {
		return 1;
	    } else {
		return key1.compareTo(key2);
	    }
	});

	for (Field field : fields) {
	    field.setAccessible(true);
	    String fieldName = field.getName();
	    if (!"log".equals(fieldName)) {
		Object value = null;

		try {
		    value = field.get(obj);
		} catch (IllegalAccessException e) {
		    e.printStackTrace();
		}

		inspectionResult.put(fieldName, value);
	    }
	}

	return convertMapToJson(inspectionResult);
    }

    private static String convertMapToJson(Map<String, Object> map) {
	try {
	    ObjectMapper objectMapper = new ObjectMapper();
	    return objectMapper.writeValueAsString(map);
	} catch (Exception e) {
	    e.printStackTrace();
	    return null;
	}
    }
}
