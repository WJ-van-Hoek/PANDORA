package com.pandora.calculation.data;

import lombok.Getter;

@Getter
public class BootstrapDataContainer {
    /**
     * The discharge data to be included in the {@link BootstrapDataContainer}.
     */
    private TemporalCellDataPointVector dischargeData;

    /**
     * The volume data to be included in the {@link BootstrapDataContainer}.
     */
    private TemporalCellDataPointVector volumeData;

    /**
     * The fixCell data to be included in the {@link BootstrapDataContainer}.
     */
    private FixCellDataPointVector fixData;

    /**
     * Constructs a new {@code BootstrapDataContainer} instance using the provided builder.
     *
     * @param builder The builder containing the configurations and datasets.
     */
    public BootstrapDataContainer(final BootstrapDataContainerBuilder builder) {
        this.dischargeData = builder.getDischargeData();
        this.volumeData = builder.getVolumeData();
        this.fixData = builder.getFixData();
    }
}
