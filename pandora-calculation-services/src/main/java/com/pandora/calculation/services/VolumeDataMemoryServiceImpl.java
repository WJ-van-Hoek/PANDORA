package com.pandora.calculation.services;

import org.springframework.stereotype.Service;

import com.pandora.calculation.repositories.VolumeDataRepository;

/**
 * An implementation of the {@link VolumeDataMemoryService} interface that saves volume data in memory.
 */
@Service
public class VolumeDataMemoryServiceImpl extends TemporalCellDataMemoryServiceImpl<VolumeDataRepository>
        implements VolumeDataMemoryService {
}
