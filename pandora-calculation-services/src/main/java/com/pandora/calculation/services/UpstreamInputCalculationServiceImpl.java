package com.pandora.calculation.services;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service implementation for calculating upstream inputs.
 */
@Service
public class UpstreamInputCalculationServiceImpl implements UpstreamInputCalculationService {

    /**
     * Service for accessing species configuration memory.
     */
    @Autowired
    private SpecieConfigurationMemoryService _specieConfigurationMemoryService;

    /**
     * Service for accessing fix cell data memory.
     */
    @Autowired
    private FixCellDataMemoryService _fixCellDataMemoryService;

    /**
     * Service for accessing discharge data memory.
     */
    @Autowired
    private DischargeDataMemoryService _dischargeDataMemoryService;

    /**
     * Service for accessing volume data memory.
     */
    @Autowired
    private VolumeDataMemoryService _volumeDataMemoryService;

    /**
     * Service for accessing calculation result memory.
     */
    @Autowired
    private CalculationResultMemoryService _calculationResultMemoryService;

    /**
     * Calculates the upstream inputs for the specified local date and time and cell ID.
     *
     * @param localDateTime The local date and time.
     * @param cellId The cell ID.
     * @return An array containing the calculated upstream inputs.
     */
    @Override
    public double[] calculate(final LocalDateTime localDateTime, final long cellId) {
        double[] upstreamDy = new double[_specieConfigurationMemoryService.getNumberOfSpecies()];
        Arrays.fill(upstreamDy, 0.0);
        Long[] previousCellIds = _fixCellDataMemoryService.findById(cellId).getPreviousCellIds();
        for (Long previousCellId : previousCellIds) {
            double[] y = _calculationResultMemoryService.findData(localDateTime, previousCellId);
            double volume = _volumeDataMemoryService.findData(localDateTime, previousCellId);
            double discharge = _dischargeDataMemoryService.findData(localDateTime, previousCellId);
            int specieId = 0;
            for (double ySpecie : y) {
                upstreamDy[specieId] += (ySpecie / volume) * discharge;
                specieId++;
            }
        }
        return upstreamDy;
    }

}
