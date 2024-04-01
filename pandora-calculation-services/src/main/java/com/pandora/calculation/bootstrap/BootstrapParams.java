package com.pandora.calculation.bootstrap;

import java.util.List;

import org.apache.commons.cli.CommandLine;

import com.pandora.calculation.config.SpecieConfiguration;
import com.pandora.calculation.parsers.Parsable;
import com.pandora.calculation.parsers.SpecieConfigParser;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Represents the parameters required for bootstrapping the application.
 *
 * This class implements the {@link Parsable} interface to provide parsing functionality.
 *
 * @author Wim Joost van Hoek
 * @version 0.0.1
 * @since 0.0.1
 */
@Slf4j
@Getter
@NoArgsConstructor
public class BootstrapParams implements Parsable<Bootstrap> {

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
    public final Bootstrap parse(final CommandLine cmd) {
        log.debug("Parsing command line arguments to construct BootstrapParams...");
        Bootstrap params = builder().specieConfigurations(SpecieConfigParser.parseSpecieConfigs(cmd).get())
                .build();
        log.debug("BootstrapParams constructed successfully.");
        return params;
    }
}
