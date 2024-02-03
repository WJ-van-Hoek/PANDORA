package com.pandora.calculation.parsers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.cli.CommandLine;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pandora.calculation.config.SpecieConfiguration;
import com.pandora.calculation.config.builders.SpecieConfigurationBuilder;

import lombok.extern.slf4j.Slf4j;

/**
 * Utility class for parsing species configurations from command line arguments.
 */
@Slf4j
public class SpecieConfigParser {

    /**
     * Parses species configurations from the provided command line.
     *
     * @param cmd The command line containing the arguments.
     * @return A list of {@link SpecieConfiguration} objects parsed from the command line, or an empty Optional if no
     * configurations were found.
     */
    public static Optional<List<SpecieConfiguration>> parseSpecieConfigs(final CommandLine cmd) {
        if (!cmd.hasOption("specieConfigurations")) {
            return Optional.empty();
        }

        String specieConfigFilePath = cmd.getOptionValue("specieConfigurations");
        try {
            JsonNode jsonNode = mapToJson(specieConfigFilePath);
            List<SpecieConfiguration> specieConfigurations = new ArrayList<>();
            for (JsonNode speciesNode : jsonNode.get("species")) {
                parseSpecieNode(specieConfigurations, speciesNode);
            }
            return Optional.of(specieConfigurations);
        } catch (IOException e) {
            // Handle IOException (e.g., file not found, invalid JSON)
            e.printStackTrace(); // Replace with proper error handling
            return Optional.empty();
        }
    }

    /**
     * Maps JSON file to JsonNode.
     *
     * @param filePath The path to the JSON file.
     * @return JsonNode representing the JSON data.
     * @throws IOException if an I/O error occurs while reading the file or parsing the JSON.
     */
    private static JsonNode mapToJson(final String filePath) throws IOException {
        byte[] jsonData = Files.readAllBytes(Paths.get(filePath));
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readTree(jsonData);
//        TODO refactor to json utils
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
    }

}
