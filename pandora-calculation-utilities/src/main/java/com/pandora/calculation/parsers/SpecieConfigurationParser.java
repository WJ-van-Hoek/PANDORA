package com.pandora.calculation.parsers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.cli.CommandLine;

import com.fasterxml.jackson.databind.JsonNode;
import com.general.utils.json.mappers.File;
import com.pandora.calculation.config.SpecieConfiguration;
import com.pandora.calculation.config.SpecieConfiguration.SpecieConfigurationBuilder;

/**
 * Utility class for parsing species configurations from command line arguments.
 */
public final class SpecieConfigurationParser {

    private SpecieConfigurationParser() {

    }

    /**
     * Parses species configurations from the provided command line.
     *
     * @param cmd The command line containing the arguments.
     * @return A list of {@link SpecieConfiguration} objects parsed from the command line, or an empty Optional if no
     * configurations were found.
     */
    public static Optional<List<SpecieConfiguration>> parse(final CommandLine cmd) {
        if (!cmd.hasOption("specieConfigurations")) {
            return Optional.empty();
        }

        String specieConfigFilePath = cmd.getOptionValue("specieConfigurations");
        return parse(specieConfigFilePath);
    }

    /**
     * Parses the specie configuration file located at the specified path and returns a list of parsed specie
     * configurations. If parsing is successful, the list of parsed specie configurations is wrapped in an
     * {@link Optional}, otherwise, an empty {@link Optional} is returned.
     *
     * @param specieConfigFilePath The file path of the specie configuration file to parse.
     * @return An {@link Optional} containing the list of parsed {@link SpecieConfiguration} objects, or an empty
     * {@link Optional} if parsing fails or the file is not found.
     */
    public static Optional<List<SpecieConfiguration>> parse(final String specieConfigFilePath) {
        Optional<JsonNode> jsonNodeOptional = File.mapToJson(specieConfigFilePath);
        return jsonNodeOptional.flatMap(SpecieConfigurationParser::parseSpecies);
    }

    private static Optional<List<SpecieConfiguration>> parseSpecies(final JsonNode jsonNode) {
        List<SpecieConfiguration> specieConfigurations = new ArrayList<>();
        for (JsonNode speciesNode : jsonNode.get("species")) {
            parseSpecieNode(specieConfigurations, speciesNode);
        }
        return Optional.of(specieConfigurations);
    }

    /**
     * Parses a JSON node representing a species configuration and adds it to the list of specie configurations.
     *
     * @param specieConfigurations The list to which the parsed specie configuration will be added.
     * @param speciesNode The JSON node representing the specie configuration.
     */
    private static void parseSpecieNode(final List<SpecieConfiguration> specieConfigurations,
            final JsonNode speciesNode) {
        SpecieConfigurationBuilder builder = SpecieConfiguration.builder();
        parseSpecieConfiguration(speciesNode, builder);
        SpecieConfiguration specieConfiguration = builder.build();
        specieConfigurations.add(specieConfiguration);
    }

    private static void parseSpecieConfiguration(final JsonNode speciesNode, final SpecieConfigurationBuilder builder) {
        parseBaseConfiguration(speciesNode, builder);
        SourceConfigurationParser.parseSources(speciesNode, builder);
        FateConfigurationParser.parseFates(speciesNode, builder);
    }

    private static void parseBaseConfiguration(final JsonNode speciesNode, final SpecieConfigurationBuilder builder) {
        String name = speciesNode.get("name").asText();
        builder.name(name);
        String unit = speciesNode.get("unit").asText();
        builder.unit(unit);
        double molarMass = speciesNode.get("molarMass").asDouble();
        builder.molarMass(molarMass);
        boolean transportable = speciesNode.get("transportable").asBoolean();
        builder.transportable(transportable);
        double y0 = speciesNode.get("y0").asDouble();
        builder.y0(y0);
    }
}
