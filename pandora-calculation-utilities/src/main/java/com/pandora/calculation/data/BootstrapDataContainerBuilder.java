package com.pandora.calculation.data;

import lombok.extern.slf4j.Slf4j;

/**
 * Builder class for constructing {@link DataContainer} instances.
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 */
@Slf4j
public class BootstrapDataContainerBuilder {
    /**
     * The discharge data to be included in the {@link BootstrapDataContainerBuilder}.
     */
    private TemporalCellDataPointVector _dischargeData;

    /**
     * The volume data to be included in the {@link BootstrapDataContainerBuilder}.
     */
    private TemporalCellDataPointVector _volumeData;

    /**
     * The fixCell data to be included in the {@link BootstrapDataContainerBuilder}.
     */
    private FixCellDataPointVector _fixData;

    /**
     * Sets the discharge data for the builder.
     *
     * @param dischargeData The discharge data to be included in the {@link BootstrapDataContainerBuilder}.
     * @return The {@code BootstrapDataContainerBuilder} instance with the specified discharge data.
     */
    public final BootstrapDataContainerBuilder dischargeData(final TemporalCellDataPointVector dischargeData) {
        _dischargeData = dischargeData;
        log.debug("discharge data set in the bootdata builder: {}", dischargeData);
        return this;
    }

    /**
     * Sets the volume data for the builder.
     *
     * @param volumeData The volume data to be included in the {@link BootstrapDataContainerBuilder}.
     * @return The {@code BootstrapDataContainerBuilder} instance with the specified volume data.
     */
    public final BootstrapDataContainerBuilder volumeData(final TemporalCellDataPointVector volumeData) {
        _volumeData = volumeData;
        log.debug("volume data set in the bootdata builder: {}", volumeData);
        return this;
    }

    /**
     * Sets the fix data for the builder.
     *
     * @param fixData The fix data to be included in the {@link BootstrapDataContainerBuilder}.
     * @return The {@code BootstrapDataContainerBuilder} instance with the specified fix data.
     */
    public final BootstrapDataContainerBuilder fixData(final FixCellDataPointVector fixData) {
        _fixData = fixData;
        log.debug("fix data set in the bootdata builder: {}", fixData);
        return this;
    }

    /**
     * Retrieves the discharge data from the builder.
     *
     * @return The discharge data included in the builder.
     */
    public TemporalCellDataPointVector getDischargeData() {
        return _dischargeData;
    }

    /**
     * Retrieves the volume data from the builder.
     *
     * @return The volume data included in the builder.
     */
    public TemporalCellDataPointVector getVolumeData() {
        return _volumeData;
    }

    /**
     * Retrieves the fix data from the builder.
     *
     * @return The fix data included in the builder.
     */
    public FixCellDataPointVector getFixData() {
        return _fixData;
    }

    /**
     * Constructs a new {@link DataContainer} instance using the configured parameters and datacontainers.
     *
     * @return A new {@link DataContainer} instance constructed with the builder's parameters and
     * datacontainers.
     */
    public DataContainer build() {
        return new DataContainer(this);
    }
}
