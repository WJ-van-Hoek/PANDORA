package com.pandora.calculation.bootstrap;

import java.util.List;

import org.apache.commons.cli.CommandLine;

import com.pandora.calculation.config.SpecieConfiguration;
import com.pandora.calculation.parsers.Parsable;
import com.pandora.calculation.parsers.SpecieConfigParser;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * Represents the parameters required for bootstrapping the application.
 *
 * This class implements the {@link Parsable} interface to provide parsing functionality.
 *
 * @version 0.0.1
 * @author Wim Joost van Hoek
 */
@Slf4j
@Getter
public class BootstrapParams implements Parsable<BootstrapParams> {

    /**
     * The list of specie configurations for bootstrapping.
     */
    private List<SpecieConfiguration> specieConfigurations;

    /**
     * Constructs a new {@code BootstrapParams} instance using the provided builder.
     *
     * @param builder The builder containing the specie configurations.
     */
    public BootstrapParams(final BootstrapParamsBuilder builder) {
        this.specieConfigurations = builder.getSpecieConfigurations();
    }

    /**
     * Returns a new builder for {@code BootstrapParams}.
     *
     * @return A {@link BootstrapParamsBuilder} instance.
     */
    public static BootstrapParamsBuilder builder() {
        return new BootstrapParamsBuilder();
    }

    /**
     * Parses the command line arguments and constructs {@code BootstrapParams}.
     *
     * @param cmd The command line containing the arguments.
     * @return A {@code BootstrapParams} instance parsed from the command line.
     */
    @Override
    public final BootstrapParams parse(final CommandLine cmd) {
        log.debug("Parsing command line arguments to construct BootstrapParams...");
        BootstrapParams params = builder().specieConfigurations(SpecieConfigParser.parseSpecieConfigs(cmd).get())
                .build();
        log.debug("BootstrapParams constructed successfully.");
        return params;
    }
}
