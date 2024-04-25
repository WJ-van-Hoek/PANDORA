package com.pandora.calculation.config;

import java.util.List;

import com.pandora.calculation.data.TemporalCellDataPointVector;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * The SpecieConfiguration class represents the configuration associated with a chemical species. It extends the
 * VariableConfiguration class and adds additional properties specific to chemical species.
 *
 * @author Wim Joost van Hoek
 * @version 0.0.1
 * @since 0.0.1
 */
@Getter
@Builder
@Accessors(prefix = "_", chain = true) // Specify prefix and chain options
public final class SpecieConfiguration extends IndexedConfiguration {
    /**
     * The name of the chemical species.
     */
    private String _name;

    /**
     * The molar mass of the chemical species.
     */
    private double _molarMass;

    /**
     * The transportability of the chemical species.
     */
    private boolean _transportable;

    /**
     * The unit of associated with the configuration.
     */
    private String _unit;

    /**
     * The initial value.
     */
    private double _y0;

    /**
     * The configuration of sources of the chemical species.
     */
    private List<SourceReactionConfiguration> _sourceReactionConfigurations;

    /**
     * The configuration of fates of the chemical species.
     */
    private List<FateReactionConfiguration> _fateReactionConfigurations;

    /**
     * The list of terrestrial input data to be included in the {@link SpecieConfiguration}.
     */
    private List<TemporalCellDataPointVector> _terrestrialInputData;

    /**
     * Constructs a new SpecieConfiguration object using the provided builder.
     *
     * @param name The name of the species.
     * @param unit The unit of measurement for the species.
     * @param molarMass The molar mass of the species.
     * @param transportable Indicates if the species is transportable.
     * @param y0 The initial concentration of the species.
     * @param sourceReactionConfigurations The list of source reaction configurations associated with the species.
     * @param fateReactionConfigurations The list of fate reaction configurations associated with the species.
     * @param terrestrialInputData The list of temporal cell data points for terrestrial input data.
     */
    @Builder
    private SpecieConfiguration(final String name, final double molarMass, final boolean transportable,
            final String unit, final double y0, final List<SourceReactionConfiguration> sourceReactionConfigurations,
            final List<FateReactionConfiguration> fateReactionConfigurations,
            final List<TemporalCellDataPointVector> terrestrialInputData) {
        _name = name;
        _unit = unit;
        _molarMass = molarMass;
        _transportable = transportable;
        _y0 = y0;
        _sourceReactionConfigurations = sourceReactionConfigurations;
        _fateReactionConfigurations = fateReactionConfigurations;
        _terrestrialInputData = terrestrialInputData;
    }

    /**
     * Gets the transportability of the specie as an integer value.
     *
     * @return An integer representing the transportability of the specie. If the specie is transportable, returns 1,
     * otherwise returns 0.
     */
    public int getTransportability() {
        return _transportable ? 1 : 0;
    }
}
