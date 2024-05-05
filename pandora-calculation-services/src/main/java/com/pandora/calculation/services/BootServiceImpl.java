package com.pandora.calculation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pandora.calculation.bootstrap.BootContent;
import com.pandora.calculation.config.SpecieConfiguration;
import com.pandora.calculation.data.FixCellDataPoint;

/**
 * Implementation of the {@link BootService} interface for initializing service parameters.
 *
 * @author Wim Joost van Hoek
 * @version 0.0.1
 * @since 0.0.1
 */
@Service
public class BootServiceImpl implements BootService {

    /**
     * Service for managing the calculation results in memory.
     */
    @Autowired
    private CalculationResultMemoryService _calculationResultMemoryService;

    /**
     * Service for managing the model run configuration in memory.
     */
    @Autowired
    private ModelRunConfigurationMemoryService _modelRunConfigurationMemoryService;

    /**
     * Service for managing specie configurations in memory.
     */
    @Autowired
    private SpecieConfigurationMemoryService _specieConfigurationMemoryService;

    /**
     * Service for managing fixed cell data in memory.
     */
    @Autowired
    private FixCellDataMemoryService _fixCellDataMemoryService;

    /**
     * Service for managing discharge data in memory.
     */
    @Autowired
    private DischargeDataMemoryService _dischargeDataMemoryService;

    /**
     * Service for managing volume data in memory.
     */
    @Autowired
    private VolumeDataMemoryService _volumeDataMemoryService;

    /**
     * Bootstraps the backend data based on the provided {@link BootContent}.
     *
     * @param params The {@link BootContent} containing the data to bootstraps
     */
    @Override
    public final void boot(final BootContent params) {
        saveModelRunConfiguration(params);
        saveSpecieConfigurations(params);
        saveY0(params);
        saveFixCellData(params);
        saveDischargeData(params);
        saveVolumeData(params);
    }

    /**
     * Saves the model run configuration provided in the {@link BootContent}.
     *
     * @param params The {@link BootContent} containing the model run configuration to save.
     */
    private void saveModelRunConfiguration(final BootContent params) {
        _modelRunConfigurationMemoryService.saveModelRunConfiguration(params.getModelRunConfiguration());
    }

    /**
     * Saves the specie configurations provided in the {@link BootContent}.
     *
     * @param params The {@link BootContent} containing the specie configurations to save.
     */
    private void saveSpecieConfigurations(final BootContent params) {
        _specieConfigurationMemoryService.saveSpecieConfigurations(params.getSpecieConfigurations());
    }

    /**
     * Saves the initial state of the species provided in the {@link BootContent}.
     *
     * @param params The {@link BootContent} containing the specie configurations to save.
     */
    private void saveY0(final BootContent params) {
        double[] y = new double[params.getSpecieConfigurations().size()];
        int index = 0;
        for (SpecieConfiguration specieConfig : params.getSpecieConfigurations()) {
            y[index++] = specieConfig.getY0();
        }
        for (FixCellDataPoint fixDataPoint : params.getDataContainer().getFixData().getAllFixCellDataPoints()) {
            _calculationResultMemoryService.saveData(params.getModelRunConfiguration().getStartDateTime(),
                    fixDataPoint.getCellId(), y);
        }
    }

    /**
     * Saves the fixed cell data provided in the {@link BootContent}.
     *
     * @param params The {@link BootContent} containing the fixed cell data to save.
     */
    private void saveFixCellData(final BootContent params) {
        _fixCellDataMemoryService.saveFixCellData(params.getDataContainer().getFixData().getAllFixCellDataPoints());
    }

    /**
     * Saves the discharge data provided in the {@link BootContent}.
     *
     * @param params The {@link BootContent} containing the discharge data to save.
     */
    private void saveDischargeData(final BootContent params) {
        _dischargeDataMemoryService.saveData(params.getDataContainer().getDischargeData());
    }

    /**
     * Saves the volume data provided in the {@link BootContent}.
     *
     * @param params The {@link BootContent} containing the volume data to save.
     */
    private void saveVolumeData(final BootContent params) {
        _volumeDataMemoryService.saveData(params.getDataContainer().getVolumeData());
    }

}
