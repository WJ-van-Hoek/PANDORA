package com.pandora.calculation.bootstrap;

import java.util.List;

import org.apache.commons.cli.CommandLine;

import com.pandora.calculation.config.ModelRunConfiguration;
import com.pandora.calculation.config.SpecieConfiguration;
import com.pandora.calculation.data.DataContainer;
import com.pandora.calculation.parsers.DataContainerParser;
import com.pandora.calculation.parsers.ModelRunConfigurationParser;
import com.pandora.calculation.parsers.Parsable;
import com.pandora.calculation.parsers.SpecieConfigurationParser;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * Represents the configuration, data and parameters required for running the application.
 *
 * This class implements the {@link Parsable} interface to provide parsing functionality.
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 */
@Getter
@Builder
@Accessors(prefix = "_", chain = true) // Specify prefix and chain options
public final class BootContent implements Parsable<BootContent> {

    /**
     * The configuration of the model run.
     */
    private ModelRunConfiguration _modelRunConfiguration;

    /**
     * The list of specie configurations for the model run.
     */
    private List<SpecieConfiguration> _specieConfigurations;

    /**
     * The data used in the model run.
     */
    private DataContainer _dataContainer;

    /**
     * Constructs a new BootContent object using the provided builder.
     *
     * <p>This constructor initializes model run settings with the specified model run configuration,
     * list of specie configurations, and data container.
     *
     * @param modelRunConfiguration The model run configuration for the settings.
     * @param specieConfigurations  The list of specie configurations for the settings.
     * @param dataContainer         The data container for the settings.
     */
    @Builder
    private BootContent(final ModelRunConfiguration modelRunConfiguration,
            final List<SpecieConfiguration> specieConfigurations, final DataContainer dataContainer) {
        _modelRunConfiguration = modelRunConfiguration;
        _specieConfigurations = specieConfigurations;
        _dataContainer = dataContainer;
    }

    /**
     * Parses the command line arguments and constructs {@code BootContent}.
     *
     * @param cmd The command line containing the arguments.
     * @return A {@code ModelRunSettings} instance parsed from the command line.
     */
    @Override
    public BootContent parse(final CommandLine cmd) {
        ModelRunConfiguration config = parseModelRunConfiguration(cmd);
        BootContent run = buildRun(cmd, config);
        run = postProcessBuild(run);
        return run;
    }

    private static BootContent postProcessBuild(final BootContent run) {
        if (run.getDataContainer() == null || run.getSpecieConfigurations() == null) {
            ModelRunConfiguration runConfiguration = run.getModelRunConfiguration();
            BootContentBuilder runBuilder = builder().modelRunConfiguration(runConfiguration);
            String rootPath = runConfiguration.getRootPath();
            parseDataContainer(run, runConfiguration, runBuilder, rootPath);
            parseSpecieConfiguration(run, runConfiguration, runBuilder, rootPath);
            return runBuilder.build();
        }
        return run;
    }

    private BootContent buildRun(final CommandLine cmd, final ModelRunConfiguration config) {
        return builder().modelRunConfiguration(config)
                .specieConfigurations(SpecieConfigurationParser.parse(cmd).orElse(null))
                .dataContainer(DataContainerParser.parse(cmd).orElse(null)).build();
    }

    private ModelRunConfiguration parseModelRunConfiguration(final CommandLine cmd) {
        ModelRunConfiguration config = ModelRunConfigurationParser.parse(cmd).orElse(null);
        if (config == null) {
            throw new IllegalStateException("A model run configuration is missing.");
        }
        return config;
    }

    private static void parseSpecieConfiguration(final BootContent run,
            final ModelRunConfiguration runConfiguration, final BootContentBuilder runBuilder,
            final String rootPath) {
        if (run.getSpecieConfigurations() == null) {
            String speciesPath = rootPath.concat(runConfiguration.getSpeciesPath());
            runBuilder.specieConfigurations(SpecieConfigurationParser.parse(speciesPath).get());
        }
    }

    private static void parseDataContainer(final BootContent run, final ModelRunConfiguration runConfiguration,
            final BootContentBuilder runBuilder, final String rootPath) {
        if (run.getDataContainer() == null) {
            String bootstrapPath = rootPath.concat(runConfiguration.getBootstrapPath());
            runBuilder.dataContainer(DataContainerParser.parse(bootstrapPath).get());
        }
    }
}
