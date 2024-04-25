package com.pandora.calculation.services;

import org.springframework.stereotype.Service;

import com.pandora.calculation.repositories.DischargeDataRepository;

/**
 * An implementation of the {@link DischargeDataMemoryService} interface that saves discharge data in memory.
 */
@Service
public final class DischargeDataMemoryServiceImpl extends TemporalCellDataMemoryServiceImpl<DischargeDataRepository>
        implements DischargeDataMemoryService {
    }
