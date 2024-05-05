package com.pandora.calculation.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pandora.calculation.data.FixCellDataPoint;
import com.pandora.calculation.repositories.FixCellDataRepository;

/**
 * Service implementation for managing fixed cell data in memory.
 */
@Service
public final class FixCellDataMemoryServiceImpl implements FixCellDataMemoryService {

    /**
     * Repository for accessing fixed cell data.
     */
    @Autowired
    private FixCellDataRepository _fixCellDataRepository;

    /**
     * Saves a single fixed cell data point.
     *
     * @param dataPoint The fixed cell data point to save.
     */
    @Override
    public void saveFixCellData(final FixCellDataPoint dataPoint) {
        _fixCellDataRepository.saveFixCellData(dataPoint);
    }

    /**
     * Saves a collection of fixed cell data points.
     *
     * @param dataPoints The collection of fixed cell data points to save.
     */
    @Override
    public void saveFixCellData(final Collection<FixCellDataPoint> dataPoints) {
        dataPoints.forEach(this::saveFixCellData);
    }

    /**
     * Finds a fixed cell data point by its ID.
     *
     * @param id The ID of the fixed cell data point to find.
     * @return The found fixed cell data point, or null if not found.
     */
    @Override
    public FixCellDataPoint findById(final long id) {
        return _fixCellDataRepository.findById(id);
    }

    // TODO think of refactoring to another service class

    /**
     * Finds parallel sets of fixed cell data points.
     *
     * @return A list of sets containing independent groups of fixed cell data points.
     */
    @Override
    public List<Set<FixCellDataPoint>> findParallelCellSets() {
        List<Set<FixCellDataPoint>> independentCellSets = new ArrayList<>();
        Set<FixCellDataPoint> unmatchedDataPoints = new HashSet<>();

        processIds(independentCellSets, unmatchedDataPoints);

        independentCellSets.add(unmatchedDataPoints);
        return independentCellSets;
    }

    private void processIds(final List<Set<FixCellDataPoint>> independentCellSets,
            final Set<FixCellDataPoint> unmatchedDataPoints) {
        findAllIds().stream().map(this::findById).forEach(dataPoint -> {
            Long[] previousCellIds = dataPoint.getPreviousCellIds();
            boolean addedToExistingSet = checkExistingSets(independentCellSets, dataPoint, previousCellIds);
            if (!addedToExistingSet) {
                unmatchedDataPoints.add(dataPoint);
            }
        });
    }

    private boolean checkExistingSets(final List<Set<FixCellDataPoint>> independentCellSets,
            final FixCellDataPoint dataPoint, final Long[] previousCellIds) {
        return independentCellSets.stream().anyMatch(cellSet -> {
            if (containsAny(cellSet, previousCellIds)) {
                cellSet.add(dataPoint);
                return true;
            }
            return false;
        });
    }

    private boolean containsAny(final Set<FixCellDataPoint> cellSet, final Long[] cellIds) {
        return Arrays.stream(cellIds).anyMatch(cellId -> cellSet.contains(findById(cellId)));
    }

    private Set<Long> findAllIds() {
        return _fixCellDataRepository.findAllIds();
    }

}
