package com.pandora.calculation.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pandora.calculation.data.FixCellDataPoint;

/**
 * A service implementation for performing calculations based on model run configuration data. This implementation
 * retrieves the start and end date times from a {@link ModelRunConfigurationMemoryService} and performs calculations
 * within the specified date range.
 */
@Service
public final class CalculationServiceImpl implements CalculationService {

    /**
     * Service for accessing model run configuration memory.
     */
    @Autowired
    private ModelRunConfigurationMemoryService _modelRunConfigurationMemoryService;

    /**
     * Service for performing cell calculations.
     */
    @Autowired
    private CellProcessingService _cellCalculationService;

    /**
     * Service for accessing fix cell data memory.
     */
    @Autowired
    private FixCellDataMemoryService _fixCellDataMemoryService;

    /**
     * Performs calculations based on the model run configuration data. The calculation logic is executed within the
     * date range specified in the model run configuration.
     */
    @Override
    public void calculate() {
        LocalDateTime startDate = _modelRunConfigurationMemoryService.getStartDateTime();
        LocalDateTime endDate = _modelRunConfigurationMemoryService.getEndDateTime();
        LocalDateTime date = startDate; // Initialize date with startDate
        while (!date.isAfter(endDate)) {
            LocalDateTime currentDate = date; // Create a local variable to capture the current value of date
            List<Set<FixCellDataPoint>> parallelCellSets = _fixCellDataMemoryService.findParallelCellSets();
            // Create a stream on parallelCellSets
            parallelCellSets.stream().forEach(cellSet -> cellSet.parallelStream()
                    .forEach(id -> _cellCalculationService.processNextTimestep(id, currentDate)));
            date = date.plusYears(_modelRunConfigurationMemoryService.getTimestep());
        }
    }
}
