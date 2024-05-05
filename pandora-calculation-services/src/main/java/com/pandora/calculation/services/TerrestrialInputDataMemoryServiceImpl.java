package com.pandora.calculation.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service implementation for managing terrestrial input data in memory. This service interacts with the repository to
 * save and retrieve terrestrial input data.
 */
@Service
public class TerrestrialInputDataMemoryServiceImpl implements TerrestrialInputDataMemoryService {

    /**
     * A service for managing specie configurations in memory.
     */
    @Autowired
    private SpecieConfigurationMemoryService _specieConfigurationMemoryService;

    /**
     * Retrieves the terrestrial input data for a specific timestamp and cell ID.
     *
     * @param localDateTime The timestamp indicating the datetime of the input data.
     * @param cellId The unique identifier of the cell for which the data is being retrieved.
     * @return The array of double values representing the terrestrial input data, or null if not found.
     */
    @Override
    public double[] findData(final LocalDateTime localDateTime, final long cellId) {
        List<Double> terrestrialInputData = new ArrayList<>();
        _specieConfigurationMemoryService.findAllSpecieConfigurations().forEach(c -> {
            double[] total = {0}; // Using an array to hold the total value
            c.getTerrestrialInputData().forEach(d -> total[0] += d.getDataAtTime(localDateTime).get(cellId));
            terrestrialInputData.add(total[0]);
        });
        return terrestrialInputData.stream().mapToDouble(Double::doubleValue).toArray();
    }
}
