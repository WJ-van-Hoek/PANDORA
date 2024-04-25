package com.pandora.calculation.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pandora.calculation.CellTimestep;
import com.pandora.calculation.PandoraTimestep;
import com.pandora.calculation.data.FixCellDataPoint;

/**
 * Service implementation for cell calculations.
 */
@Service
public final class CellProcessingServiceImpl implements CellProcessingService {

    /**
     * Service for accessing calculation result memory.
     */
    @Autowired
    private CalculationResultMemoryService _calculationResultMemoryService;

    /**
     * Service for accessing discharge data memory.
     */
    @Autowired
    private DischargeDataMemoryService _dischargeDataMemoryService;

    /**
     * Service for accessing model run configuration memory.
     */
    @Autowired
    private ModelRunConfigurationMemoryService _modelRunConfigurationMemoryService;

    /**
     * Service for integrating Pandora timestep.
     */
    @Autowired
    private PandoraIntegratorService _pandoraIntegratorService;

    /**
     * Service for accessing species configuration memory.
     */
    @Autowired
    private SpecieConfigurationMemoryService _specieConfigurationMemoryService;

    /**
     * Service for accessing terrestrial input data memory.
     */
    @Autowired
    private TerrestrialInputDataMemoryService _terrestrialDataMemoryService;

    /**
     * Service for calculating upstream data.
     */
    @Autowired
    private UpstreamInputCalculationService _upstreamDataMemoryService;

    /**
     * Service for accessing volume data memory.
     */
    @Autowired
    private VolumeDataMemoryService _volumeDataMemoryService;

    /**
     * Calculates the time series for the given cell starting from the specified time.
     *
     * @param cell The cell data point.
     * @param t0 The starting time.
     * @param numberOfTimesteps The number of timesteps.
     * @return A list of cell timesteps.
     */
    @Override
    public List<CellTimestep> calculateTimeSeries(final FixCellDataPoint cell, final LocalDateTime t0,
            final int numberOfTimesteps) {
        // TODO Auto-generated method stub
        return new ArrayList<>();
    }

    /**
     * Calculates the next timestep for the given cell at the specified time.
     *
     * @param cell The cell data point.
     * @param t0 The time.
     */
    @Override
    public void processNextTimestep(final FixCellDataPoint cell, final LocalDateTime t0) {
        PandoraTimestep timestep = PandoraTimestep.builder()
                .dimension(_specieConfigurationMemoryService.getNumberOfSpecies())
                .discharge(_dischargeDataMemoryService.findData(t0, cell.getCellId()))
                .volume(_volumeDataMemoryService.findData(t0, cell.getCellId())).t0(0)
                .tEnd(_modelRunConfigurationMemoryService.getTimestep())
                .y0(_calculationResultMemoryService.findData(t0, cell.getCellId()))
                .upstreamSources(_upstreamDataMemoryService.calculate(t0, cell.getCellId()))
                .terrestrialSources(_terrestrialDataMemoryService.findData(t0, cell.getCellId())).build();
        double[] y = _pandoraIntegratorService.integrate(timestep);
//        TODO add timestep better
        _calculationResultMemoryService.saveData(t0.plusYears((long) timestep.getTEnd()), cell.getCellId(), y);
    }

}
