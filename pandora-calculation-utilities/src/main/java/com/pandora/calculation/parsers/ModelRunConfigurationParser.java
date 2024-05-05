package com.pandora.calculation.parsers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.apache.commons.cli.CommandLine;

import com.fasterxml.jackson.databind.JsonNode;
import com.general.utils.json.mappers.File;
import com.pandora.calculation.config.ModelRunConfiguration;

public final class ModelRunConfigurationParser {

    private ModelRunConfigurationParser() {
    }

    /**
     * Parses model run configuration from the provided command line.
     *
     * @param cmd The command line containing the arguments.
     * @return A {@link DataContainer} parsed from the command line, or an empty Optional if no bootstrap data were
     * found.
     */
    public static Optional<ModelRunConfiguration> parse(final CommandLine cmd) {
        if (!cmd.hasOption("modelRunConfiguration")) {
            return Optional.empty();
        }

        String runConfigurationFilePath = cmd.getOptionValue("modelRunConfiguration");
        Optional<JsonNode> jsonNodeOptional = File.mapToJson(runConfigurationFilePath);
        return jsonNodeOptional.flatMap(ModelRunConfigurationParser::parseToConfiguration);
    }

    private static Optional<ModelRunConfiguration> parseToConfiguration(final JsonNode jsonNode) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        String startDateStr = jsonNode.get("startDate").asText();
        LocalDateTime startDate = LocalDateTime.parse(startDateStr, formatter);
        String endDateStr = jsonNode.get("endDate").asText();
        LocalDateTime endDate = LocalDateTime.parse(endDateStr, formatter);
        Integer timestep = jsonNode.get("timestep").asInt();
        String rootPath = jsonNode.get("root").asText();
        String bootstrapPath = jsonNode.get("bootstrap").asText();
        String specieConfigurationPath = jsonNode.get("species").asText();
        ModelRunConfiguration runConfiguration = ModelRunConfiguration.builder().startDateTime(startDate)
                .endDateTime(endDate).timestep(timestep).rootPath(rootPath).bootstrapPath(bootstrapPath)
                .speciesPath(specieConfigurationPath).build();
        return Optional.of(runConfiguration);
    }
}
