package com.pandora.calculation.parsers;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.pandora.calculation.config.SourceReactionConfiguration;
import com.pandora.calculation.config.SpecieConfiguration.SpecieConfigurationBuilder;
import com.pandora.calculation.data.TemporalCellDataPointVector;

/**
 * Utility class for parsing source configurations from JSON data.
 */
public final class SourceConfigurationParser {

    private SourceConfigurationParser() {

    }

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
     * Key representing the type of source as a terrestrial input.
     */
    private static final String SOURCE_TERRESTRIALTYPE_KEY = "terrestrial";

    /**
     * Key for the source from which the reaction originates.
     */
    private static final String FROM_KEY = "from";

    /**
     * Parses source configurations from the given JSON node and adds them to the specified builder.
     *
     * @param speciesNode The JSON node containing species data.
     * @param builder     The builder to which source configurations will be added.
     */
    public static void parseSources(final JsonNode speciesNode, final SpecieConfigurationBuilder builder) {
        JsonNode dyNode = speciesNode.get(DY_NODE_KEY);
        JsonNode sourcesNode = dyNode.get(SOURCES_NODE_KEY);

        if (sourcesNode != null && sourcesNode.isArray()) {
            List<SourceReactionConfiguration> sourceReactions = parseSourceReactions(sourcesNode);
            List<TemporalCellDataPointVector> sourceTerrestrial = parseTerrestrialSources(sourcesNode);
            builder.sourceReactionConfigurations(sourceReactions);
            builder.terrestrialInputData(sourceTerrestrial);
        }
    }

    /**
     * Parses source reaction configurations from the given JSON node.
     *
     * @param sourcesNode The JSON node containing source reaction configurations.
     * @return A list of parsed source reaction configurations.
     */
    private static List<SourceReactionConfiguration> parseSourceReactions(final JsonNode sourcesNode) {
        List<SourceReactionConfiguration> sourceReactions = new ArrayList<>();
        for (JsonNode sourceNode : sourcesNode) {
            String sourceType = sourceNode.get(TYPE_KEY).asText();
            if (SOURCE_REACTIONTYPE_KEY.equals(sourceType)) {
                SourceReactionConfiguration sourceReaction = parseSourceReaction(sourceNode);
                if (sourceReaction != null) {
                    sourceReactions.add(sourceReaction);
                }
            }
        }
        return sourceReactions;
    }

    /**
     * Parses a single source reaction configuration from the given JSON node.
     *
     * @param sourceNode The JSON node containing a single source reaction configuration.
     * @return The parsed source reaction configuration.
     */
    private static SourceReactionConfiguration parseSourceReaction(final JsonNode sourceNode) {
        String name = sourceNode.has(NAME_KEY) ? sourceNode.get(NAME_KEY).asText() : null;
        String from = sourceNode.has(FROM_KEY) ? sourceNode.get(FROM_KEY).asText() : null;
        return SourceReactionConfiguration.builder()
                                          .name(name)
                                          .from(from)
                                          .build();
    }

    /**
     * Parses terrestrial sources configurations from the given JSON node.
     *
     * @param sourcesNode The JSON node containing terrestrial sources configurations.
     * @return A list of parsed terrestrial sources configurations.
     */
    private static List<TemporalCellDataPointVector> parseTerrestrialSources(final JsonNode sourcesNode) {
        List<TemporalCellDataPointVector> terrestrialSources = new ArrayList<>();
        for (JsonNode sourceNode : sourcesNode) {
            String sourceType = sourceNode.get(TYPE_KEY).asText();
            if (SOURCE_TERRESTRIALTYPE_KEY.equals(sourceType)) {
                String terrestrialInputDataFilePath = sourceNode.get("file").asText();
                TemporalCellDataPointVector terrestrialInputData = new TemporalCellDataPointVector();
                TemporalCellDataPointVectorNodeParser.parseTemporalCellDataPointVectorNode(terrestrialInputData,
                        terrestrialInputDataFilePath);
                terrestrialSources.add(terrestrialInputData);
            }
        }
        return terrestrialSources;
    }

}
