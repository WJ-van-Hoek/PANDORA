package com.pandora.calculation.data;

import lombok.extern.slf4j.Slf4j;

/**
 * Builder class for constructing {@link BootstrapDataContainer} instances.
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 */
@Slf4j
public class BootstrapDataContainerBuilder {
    /**
     * The discharge data to be included in the {@link BootstrapDataContainerBuilder}.
     */
    private TemporalCellDataPointVector dischargeData;

    /**
     * The volume data to be included in the {@link BootstrapDataContainerBuilder}.
     */
    private TemporalCellDataPointVector volumeData;

    /**
     * The fixCell data to be included in the {@link BootstrapDataContainerBuilder}.
     */
    private FixCellDataPointVector fixData;

    /**
     * Sets the discharge data for the builder.
     *
     * @param dischargeDataParam The discharge data to be included in the {@link BootstrapDataContainerBuilder}.
     * @return The {@code BootstrapDataContainerBuilder} instance with the specified discharge data.
     */
    public final BootstrapDataContainerBuilder dischargeData(final TemporalCellDataPointVector dischargeDataParam) {
        this.dischargeData = dischargeDataParam;
        log.debug("discharge data set in the bootdata builder: {}", dischargeDataParam);
        return this;
    }

    /**
     * Sets the volume data for the builder.
     *
     * @param volumeDataParam The volume data to be included in the {@link BootstrapDataContainerBuilder}.
     * @return The {@code BootstrapDataContainerBuilder} instance with the specified volume data.
     */
    public final BootstrapDataContainerBuilder volumeData(final TemporalCellDataPointVector volumeDataParam) {
        this.volumeData = volumeDataParam;
        log.debug("volume data set in the bootdata builder: {}", volumeDataParam);
        return this;
    }

    /**
     * Sets the fix data for the builder.
     *
     * @param fixDataParam The fix data to be included in the {@link BootstrapDataContainerBuilder}.
     * @return The {@code BootstrapDataContainerBuilder} instance with the specified fix data.
     */
    public final BootstrapDataContainerBuilder fixData(final FixCellDataPointVector fixDataParam) {
        this.fixData = fixDataParam;
        log.debug("fix data set in the bootdata builder: {}", fixDataParam);
        return this;
    }

    /**
     * Retrieves the discharge data from the builder.
     *
     * @return The discharge data included in the builder.
     */
    public TemporalCellDataPointVector getDischargeData() {
        return this.dischargeData;
    }

    /**
     * Retrieves the volume data from the builder.
     *
     * @return The volume data included in the builder.
     */
    public TemporalCellDataPointVector getVolumeData() {
        return this.volumeData;
    }

    /**
     * Retrieves the fix data from the builder.
     *
     * @return The fix data included in the builder.
     */
    public FixCellDataPointVector getFixData() {
        return this.fixData;
    }

    /**
     * Constructs a new {@link BootstrapDataContainer} instance using the configured parameters and datacontainers.
     *
     * @return A new {@link BootstrapDataContainer} instance constructed with the builder's parameters and
     * datacontainers.
     */
    public BootstrapDataContainer build() {
        return new BootstrapDataContainer(this);
    }
}
