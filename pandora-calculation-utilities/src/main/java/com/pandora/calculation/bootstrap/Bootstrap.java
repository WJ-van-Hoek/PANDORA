package com.pandora.calculation.bootstrap;

import java.util.List;

import org.apache.commons.cli.CommandLine;

import com.pandora.calculation.config.SpecieConfiguration;
import com.pandora.calculation.data.BootstrapDataContainer;
import com.pandora.calculation.parsers.BootstrapDataParser;
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
public class Bootstrap implements Parsable<Bootstrap> {

    /**
     * The list of specie configurations for bootstrapping.
     */
    private List<SpecieConfiguration> specieConfigurations;

    /**
     * The bootstrap data.
     */
    private BootstrapDataContainer bootstrapData;

    /**
     * Constructs a new {@code BootstrapParams} instance using the provided builder.
     *
     * @param builder The builder containing the specie configurations and bootstrap data.
     */
    public Bootstrap(final BootstrapBuilder builder) {
        this.specieConfigurations = builder.getSpecieConfigurations();
        this.bootstrapData = builder.getBootstrapData();
    }

    /**
     * Returns a new builder for {@code BootstrapParams}.
     *
     * @return A {@link BootstrapBuilder} instance.
     */
    public static BootstrapBuilder builder() {
        return new BootstrapBuilder();
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
        Bootstrap params = builder()
                .specieConfigurations(SpecieConfigParser.parse(cmd).get())
                .bootstrapData(BootstrapDataParser.parse(cmd).get())
                .build();
        log.info("BootstrapParams constructed successfully.");
        return params;
    }
}
