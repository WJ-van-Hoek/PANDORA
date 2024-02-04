package com.pandora.calculation.parsers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pandora.calculation.config.SourceExternalConfiguration;
import com.pandora.calculation.config.SourceReactionConfiguration;
import com.pandora.calculation.config.builders.SourceExternalConfigurationBuilder;
import com.pandora.calculation.config.builders.SourceReactionConfigurationBuilder;
import com.pandora.calculation.config.builders.SpecieConfigurationBuilder;

/**
 * Utility class for parsing source configurations from JSON data.
 *
 * @author Wim Joost van Hoek
 * @version 0.0.1
 * @since 0.0.1
 */
public class SourceConfigurationParser {
    /**
     * String containing the relative path to which to find source files.
     */
    private static final String RELATIVE_PATH = "./src/main/resources/";

    /**
     * Key for the JSON node containing source data.
     */
    private static final String DY_NODE_KEY = "dy";

    /**
     * Key for the JSON node containing source reactions.
     */
    private static final String SOURCES_NODE_KEY = "sources";

    /**
     * Key for the type of source.
     */
    private static final String TYPE_KEY = "sourceType";

    /**
     * Key for the name of the source.
     */
    private static final String NAME_KEY = "name";

    /**
     * Key representing the type of source as a reaction.
     */
    private static final String SOURCE_REACTIONTYPE_KEY = "reaction";

    /**
     * Key representing the type of source as external.
     */
    private static final String SOURCE_EXTERNALTYPE_KEY = "external";

    /**
     * Key for the source from which the reaction originates.
     */
    private static final String FROM_KEY = "from";

    /**
     * Key for the file that contains an external source.
     */
    private static final String EXTERNAL_SOURCE_FILE_KEY = "file";

    /**
     * Parses source configurations from the given JSON node and adds them to the specified builder.
     *
     * @param speciesNode The JSON node containing species data.
     * @param builder The builder to which source configurations will be added.
     */
    public static void parseSources(final JsonNode speciesNode, final SpecieConfigurationBuilder builder) {
        JsonNode dyNode = speciesNode.get(DY_NODE_KEY);
        JsonNode sourcesNode = dyNode.get(SOURCES_NODE_KEY);

        if (sourcesNode != null && sourcesNode.isArray()) {
            parseSources(builder, sourcesNode);
        }
    }

    private static void parseSources(final SpecieConfigurationBuilder builder, final JsonNode sourcesNode) {
        List<SourceReactionConfiguration> sourceReactions = new ArrayList<>();
        List<SourceExternalConfiguration> sourceExternals = new ArrayList<>();
        parseSources(sourcesNode, sourceReactions, sourceExternals);
        builder.sourceReactionConfigurations(sourceReactions).sourceExternalConfigurations(sourceExternals);
    }

    private static void parseSources(final JsonNode sourcesNode,
            final List<SourceReactionConfiguration> sourceReactions,
            final List<SourceExternalConfiguration> sourceExternals) {
        for (JsonNode sourceNode : sourcesNode) {
            String sourceType = sourceNode.get(TYPE_KEY).asText();
            String name = sourceNode.has(NAME_KEY) ? sourceNode.get(NAME_KEY).asText() : null;
            if (sourceType.equals(SOURCE_REACTIONTYPE_KEY)) {
                parseSourceReactionConfiguration(sourceReactions, sourceNode, name);
            }
            if (sourceType.equals(SOURCE_EXTERNALTYPE_KEY)) {
                parseSourceExternalConfiguration(sourceExternals, sourceNode);
            }
        }
    }

    private static void parseSourceReactionConfiguration(final List<SourceReactionConfiguration> sourceReactions,
            final JsonNode sourceNode, final String name) {
        SourceReactionConfigurationBuilder reactionBuilder = SourceReactionConfiguration.builder();
        String from = sourceNode.has(FROM_KEY) ? sourceNode.get(FROM_KEY).asText() : null;
        sourceReactions.add(reactionBuilder.name(name).from(from).build());
    }

    private static void parseSourceExternalConfiguration(final List<SourceExternalConfiguration> sourceExternals,
            final JsonNode sourceNode) {
        SourceExternalConfigurationBuilder externalSourceBuilder = SourceExternalConfiguration.builder();
        String filename = sourceNode.has(EXTERNAL_SOURCE_FILE_KEY) ? sourceNode.get(EXTERNAL_SOURCE_FILE_KEY).asText()
                : null;
        try {
            parseData(sourceExternals, externalSourceBuilder, filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void parseData(final List<SourceExternalConfiguration> sourceExternals,
            final SourceExternalConfigurationBuilder externalSourceBuilder, final String filename) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(new File(RELATIVE_PATH + filename));
        JsonNode dataNode = rootNode.get("data");

        // Iterate over the elements in the 'data' object
        Map<LocalDateTime, Double> dataMap = new ConcurrentHashMap<>();
        dataNode.fields().forEachRemaining(entry -> {
            parseEntry(dataMap, entry);
        });
        sourceExternals.add(externalSourceBuilder.data(dataMap).build());
    }

    private static void parseEntry(final Map<LocalDateTime, Double> dataMap, final Entry<String, JsonNode> entry) {
        String date = entry.getKey();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
        double value = entry.getValue().asDouble();
        dataMap.put(dateTime, value);
    }
}
