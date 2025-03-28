/**
 * Unit test for {@link BootServiceImpl}.
 *
 * <p>This test class verifies that the {@link BootServiceImpl} correctly calls the required services
 * during the boot process using Mockito.</p>
 */
package com.pandora.calculation.services;

import com.pandora.calculation.bootstrap.BootContent;
import com.pandora.calculation.config.ModelRunConfiguration;
import com.pandora.calculation.config.SpecieConfiguration;
import com.pandora.calculation.data.FixCellDataPoint;
import com.pandora.calculation.data.FixCellDataPointVector;
import com.pandora.calculation.data.TemporalCellDataPointVector;
import com.pandora.calculation.data.DataContainer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Test class for {@link BootServiceImpl}.
 */
@ExtendWith(MockitoExtension.class)
class BootServiceImplTest {

    /**
     * Mocked service for managing the calculation results in memory.
     */
    @Mock
    private CalculationResultMemoryService _calculationResultMemoryService;

    /**
     * Mocked service for managing the model run configuration in memory.
     */
    @Mock
    private ModelRunConfigurationMemoryService _modelRunConfigurationMemoryService;

    /**
     * Mocked service for managing specie configurations in memory.
     */
    @Mock
    private SpecieConfigurationMemoryService _specieConfigurationMemoryService;

    /**
     * Mocked service for managing fixed cell data in memory.
     */
    @Mock
    private FixCellDataMemoryService _fixCellDataMemoryService;

    /**
     * Mocked service for managing discharge data in memory.
     */
    @Mock
    private DischargeDataMemoryService _dischargeDataMemoryService;

    /**
     * Mocked service for managing volume data in memory.
     */
    @Mock
    private VolumeDataMemoryService _volumeDataMemoryService;

    /**
     * Instance of the BootServiceImpl being tested.
     */
    @InjectMocks
    private BootServiceImpl _bootService;

    /**
     * Mocked {@link BootContent} object used for testing the boot process.
     */
    private BootContent _bootContent;

    /**
     * Sets up mock objects before each test execution.
     */
    @BeforeEach
    void setUp() {
        ModelRunConfiguration modelRunConfig = mock(ModelRunConfiguration.class);
        when(modelRunConfig.getStartDateTime()).thenReturn(LocalDateTime.now());

        SpecieConfiguration specieConfig = mock(SpecieConfiguration.class);
        when(specieConfig.getY0()).thenReturn(1.0);

        FixCellDataPoint fixDataPoint = mock(FixCellDataPoint.class);
        when(fixDataPoint.getCellId()).thenReturn(1L);

        FixCellDataPointVector fixData = mock(FixCellDataPointVector.class);
        when(fixData.getAllFixCellDataPoints()).thenReturn(List.of(fixDataPoint));

        TemporalCellDataPointVector dischargeData = mock(TemporalCellDataPointVector.class);
        TemporalCellDataPointVector volumeData = mock(TemporalCellDataPointVector.class);
        DataContainer dataContainer = mock(DataContainer.class);

        when(dataContainer.getFixData()).thenReturn(fixData);
        when(dataContainer.getDischargeData()).thenReturn(dischargeData);
        when(dataContainer.getVolumeData()).thenReturn(volumeData);

        _bootContent = mock(BootContent.class);
        when(_bootContent.getModelRunConfiguration()).thenReturn(modelRunConfig);
        when(_bootContent.getSpecieConfigurations()).thenReturn(Collections.singletonList(specieConfig));
        when(_bootContent.getDataContainer()).thenReturn(dataContainer);
    }

    /**
     * Tests whether the {@link BootServiceImpl#boot(BootContent)} method correctly invokes the required services.
     */
    @Test
    void testBoot() {
        _bootService.boot(_bootContent);

        verify(_modelRunConfigurationMemoryService).saveModelRunConfiguration(any());
        verify(_specieConfigurationMemoryService).saveSpecieConfigurations(any());
        verify(_dischargeDataMemoryService).saveData(any());
        verify(_volumeDataMemoryService).saveData(any());

        ArgumentCaptor<Collection<FixCellDataPoint>> captor = ArgumentCaptor.forClass(Collection.class);
        verify(_fixCellDataMemoryService).saveFixCellData(captor.capture());
        Collection<FixCellDataPoint> capturedCollection = captor.getValue();
        assertNotNull(capturedCollection);
        assertFalse(capturedCollection.isEmpty());

        verify(_calculationResultMemoryService).saveData(any(LocalDateTime.class), anyLong(), any());

    }
}
