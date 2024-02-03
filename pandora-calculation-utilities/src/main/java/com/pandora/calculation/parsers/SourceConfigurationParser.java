package com.pandora.calculation.parsers;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.pandora.calculation.config.SourceReactionConfiguration;
import com.pandora.calculation.config.builders.SourceReactionConfigurationBuilder;
import com.pandora.calculation.config.builders.SpecieConfigurationBuilder;

/**
 * Utility class for parsing source configurations from JSON data.
 */
public class SourceConfigurationParser {
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
            List<SourceReactionConfiguration> sourceReactions = new ArrayList<>();
            for (JsonNode sourceNode : sourcesNode) {
                String sourceType = sourceNode.get(TYPE_KEY).asText();
                String name = sourceNode.has(NAME_KEY) ? sourceNode.get(NAME_KEY).asText() : null;
                if (sourceType.equals(SOURCE_REACTIONTYPE_KEY)) {
                    SourceReactionConfigurationBuilder<?> reactionBuilder = SourceReactionConfiguration.builder();
                    String from = sourceNode.has(FROM_KEY) ? sourceNode.get(FROM_KEY).asText() : null;
                    sourceReactions.add(reactionBuilder.name(name).from(from).build());
                }
//              if (sourceType.equals("external")) {
////            TODO think about implementation
//            }
            }
            builder.sourceReactionConfigurations(sourceReactions);
        }
    }
}

