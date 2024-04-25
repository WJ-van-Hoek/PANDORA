package com.pandora.calculation.data;

public class DataContainer {
    /**
     * The discharge data to be included in the {@link DataContainer}.
     */
    private TemporalCellDataPointVector _dischargeData;

    /**
     * The volume data to be included in the {@link DataContainer}.
     */
    private TemporalCellDataPointVector _volumeData;

    /**
     * The fixCell data to be included in the {@link DataContainer}.
     */
    private FixCellDataPointVector _fixData;

    /**
     * Constructs a new {@code BootstrapDataContainer} instance using the provided builder.
     *
     * @param builder The builder containing the configurations and datasets.
     */
    public DataContainer(final BootstrapDataContainerBuilder builder) {
        _dischargeData = builder.getDischargeData();
        _volumeData = builder.getVolumeData();
        _fixData = builder.getFixData();
    }

    /**
     * Gets the discharge data.
     *
     * @return The discharge data.
     */
    public TemporalCellDataPointVector getDischargeData() {
        return _dischargeData;
    }

    /**
     * Gets the volume data.
     *
     * @return The volume data.
     */
    public TemporalCellDataPointVector getVolumeData() {
        return _volumeData;
    }

    /**
     * Gets the fixed data.
     *
     * @return The fixed data.
     */
    public FixCellDataPointVector getFixData() {
        return _fixData;
    }
}
